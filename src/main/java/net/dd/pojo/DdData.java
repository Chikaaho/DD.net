package net.dd.pojo;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

public class DdData implements Serializable {


    private long fileId;
    private long fileType;
    private long fileKey;
    private java.sql.Timestamp createTime;
    private java.sql.Timestamp updateTime;

    public DdData(long fileId, long fileType, long fileKey, Timestamp createTime, Timestamp updateTime) {
        this.fileId = fileId;
        this.fileType = fileType;
        this.fileKey = fileKey;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public DdData() {
    }

    public long getFileId() {
        return fileId;
    }

    public void setFileId(long fileId) {
        this.fileId = fileId;
    }


    public long getFileType() {
        return fileType;
    }

    public void setFileType(long fileType) {
        this.fileType = fileType;
    }


    public long getFileKey() {
        return fileKey;
    }

    public void setFileKey(long fileKey) {
        this.fileKey = fileKey;
    }


    public java.sql.Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(java.sql.Timestamp createTime) {
        this.createTime = createTime;
    }


    public java.sql.Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(java.sql.Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DdData ddData = (DdData) o;
        return fileId == ddData.fileId &&
                fileType == ddData.fileType &&
                fileKey == ddData.fileKey &&
                createTime.equals(ddData.createTime) &&
                updateTime.equals(ddData.updateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fileId, fileType, fileKey, createTime, updateTime);
    }
    
}
