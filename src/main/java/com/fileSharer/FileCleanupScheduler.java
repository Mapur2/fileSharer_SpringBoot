package com.fileSharer;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;

@Component
public class FileCleanupScheduler {

    private final FileStorageService storageService;

    public FileCleanupScheduler(FileStorageService storageService) {
        this.storageService = storageService;
    }

    @Scheduled(fixedRate = 60000)
    public void cleanup() {
        storageService.getFileMetaMap().forEach((uid, meta) -> {
            if (Duration.between(meta.getUploadTime(), Instant.now()).toMinutes() >= 10) {
                storageService.delete(uid);
            }
        });
    }
}