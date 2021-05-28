package net.dd.dto;

import java.io.Serializable;

public class DownloadDto implements Serializable {
    private String filekey;

    public DownloadDto() {
    }

    public DownloadDto(String filekey) {
        this.filekey = filekey;
    }

    public String getFilekey() {
        return filekey;
    }

    public void setFilekey(String filekey) {
        this.filekey = filekey;
    }
}
