package com.fileSharer;
import java.time.Instant;

public class FileMeta {
    private String uid;
    private String fileName;
    private Instant uploadTime;

    public FileMeta(String uid, String fileName, Instant uploadTime) {
        this.uid = uid;
        this.fileName = fileName;
        this.uploadTime = uploadTime;
    }

    public String getUid() { return uid; }
    public String getFileName() { return fileName; }
    public Instant getUploadTime() { return uploadTime; }
}