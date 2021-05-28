package net.dd.dto;

import lombok.Data;

import java.io.Serializable;


public class FileDto implements Serializable {
    private String filekey;

    public FileDto() {
    }

    public FileDto(String filekey) {
        this.filekey = filekey;
    }

    public String getFilekey() {
        return filekey;
    }

    public void setFilekey(String filekey) {
        this.filekey = filekey;
    }
}
