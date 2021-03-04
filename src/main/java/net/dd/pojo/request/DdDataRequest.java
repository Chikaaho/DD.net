package net.dd.pojo.request;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDateTime;
import java.util.Objects;

public class DdDataRequest {

    @TableId(type = IdType.ASSIGN_ID)
    private long fileId;

    @ApiModelProperty(value = "文件类型 0:txt 1:image 2:video")
    private int fileType;

    @ApiModelProperty(value = "访问凭证")
    private long fileKey;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "修改时间")
    private LocalDateTime updateTime;


    public long getFileId() {
        return fileId;
    }

    public void setFileId(long fileId) {
        this.fileId = fileId;
    }

    public int getFileType() {
        return fileType;
    }

    public void setFileType(int fileType) {
        this.fileType = fileType;
    }

    public long getFileKey() {
        return fileKey;
    }

    public void setFileKey(long fileKey) {
        this.fileKey = fileKey;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DdDataRequest)) return false;
        DdDataRequest that = (DdDataRequest) o;
        return getFileId() == that.getFileId() &&
                getFileType() == that.getFileType() &&
                getFileKey() == that.getFileKey() &&
                Objects.equals(getCreateTime(), that.getCreateTime()) &&
                Objects.equals(getUpdateTime(), that.getUpdateTime());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFileId(), getFileType(), getFileKey(), getCreateTime(), getUpdateTime());
    }

    @Override
    public String toString() {
        return "DdDataRequest{" +
                "fileId=" + fileId +
                ", fileType=" + fileType +
                ", fileKey=" + fileKey +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }

}
