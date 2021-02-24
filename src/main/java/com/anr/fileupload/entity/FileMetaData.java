package com.anr.fileupload.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class FileMetaData {

    @Id
    @GeneratedValue(generator = "uuid")
    private Integer id;

    private String fileName;

    @Lob
    private byte[] data;

    public FileMetaData(Integer id, String fileName, byte[] data) {
        this.id = id;
        this.fileName = fileName;
        this.data = data;
    }

    public FileMetaData() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }
}
