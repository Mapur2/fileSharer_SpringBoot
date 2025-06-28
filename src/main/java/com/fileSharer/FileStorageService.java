package com.fileSharer;
import com.fileSharer.UIDGenerator;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.*;
import java.time.Instant;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class FileStorageService {

    private final Path storageLocation = Paths.get("uploaded-files");
    private final Map<String, FileMeta> fileMetaMap = new ConcurrentHashMap<>();

    public FileStorageService() {
        try {
            Files.createDirectories(storageLocation);
        } catch (IOException e) {
            throw new RuntimeException("Could not create storage directory.", e);
        }
    }

    public String store(MultipartFile file) {
        String uid = UIDGenerator.generateUID();
        Path target = storageLocation.resolve(uid);
        try {
            Files.copy(file.getInputStream(), target, StandardCopyOption.REPLACE_EXISTING);
            fileMetaMap.put(uid, new FileMeta(uid, file.getOriginalFilename(), Instant.now()));
        } catch (IOException e) {
            throw new RuntimeException("Failed to store file.", e);
        }
        return uid;
    }

    public Resource load(String uid) {
        FileMeta meta = fileMetaMap.get(uid);
        if (meta == null || Instant.now().isAfter(meta.getUploadTime().plusSeconds(600))) {
            delete(uid);
            throw new RuntimeException("File expired or not found.");
        }
        Path file = storageLocation.resolve(uid);
        return new FileSystemResource(file.toFile()) {
            @Override
            public String getFilename() {
                return meta.getFileName();
            }
        };
    }

    public void delete(String uid) {
        fileMetaMap.remove(uid);
        try {
            Files.deleteIfExists(storageLocation.resolve(uid));
        } catch (IOException ignored) {}
    }

    public Map<String, FileMeta> getFileMetaMap() {
        return fileMetaMap;
    }
}