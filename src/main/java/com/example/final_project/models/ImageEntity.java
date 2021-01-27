package com.example.final_project.models;


import javax.persistence.*;

@Entity
@Table(name = "Image")
public class ImageEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long Id;

    private String fileName;
    private long size;
    private String fileDownloadUri;
    private String contentType;
    private long advertiseId;

    @Lob
    private byte[] image;

    public ImageEntity(){

    }

    public ImageEntity(String fileName, long size, String fileDownloadUri, String contentType, byte[] image, long advertise_id) {
        this.fileName = fileName;
        this.size = size;
        this.fileDownloadUri = fileDownloadUri;
        this.contentType = contentType;
        this.image = image;
        this.advertiseId = advertise_id;
    }


    public long getId() {
        return Id;
    }

    public long getAdvertiseId() {
        return advertiseId;
    }

    public void setAdvertiseId(long advertise_id) {
        this.advertiseId = advertise_id;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public String getFileDownloadUri() {
        return fileDownloadUri;
    }

    public void setFileDownloadUri(String fileDownloadUri) {
        this.fileDownloadUri = fileDownloadUri;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

}
