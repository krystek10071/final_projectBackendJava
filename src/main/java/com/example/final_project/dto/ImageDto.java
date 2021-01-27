package com.example.final_project.dto;

import lombok.Builder;

@Builder
public class ImageDto {
    private long Id;

    private String fileName;
    private long size;
    private String fileDownloadUri;
    private String contentType;
    private long advertiseId;

    public long getId() {
        return Id;
    }

    public String getFileName() {
        return fileName;
    }

    public long getSize() {
        return size;
    }

    public String getFileDownloadUri() {
        return fileDownloadUri;
    }

    public String getContentType() {
        return contentType;
    }

    public long getAdvertiseId() {
        return advertiseId;
    }


}
