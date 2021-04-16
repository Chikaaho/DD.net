package net.dd.pojo;


import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Objects;

public class DdData implements Serializable {

//  @TableId(type = IdType.ASSIGN_ID)
  private long fileId;

  @ApiModelProperty(value="文件类型 0:txt 1:image 2:video")
  private int fileType;

  @ApiModelProperty(value="访问凭证")
  private long fileKey;

  @ApiModelProperty(value = "创建时间")
  private LocalDateTime createTime;

  @ApiModelProperty(value = "修改时间")
  private LocalDateTime updateTime;

  private static final long serialVersionUID = 1L;

  public DdData() {
  }

  public DdData(long fileId, int fileType, long fileKey, LocalDateTime createTime, LocalDateTime updateTime) {
    this.fileId = fileId;
    this.fileType = fileType;
    this.fileKey = fileKey;
    this.createTime = createTime;
    this.updateTime = updateTime;
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
    if (o == null || getClass() != o.getClass()) return false;
    DdData ddData = (DdData) o;
    return fileId == ddData.fileId &&
            fileType == ddData.fileType &&
            fileKey == ddData.fileKey &&
            Objects.equals(createTime, ddData.createTime) &&
            Objects.equals(updateTime, ddData.updateTime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(fileId, fileType, fileKey, createTime, updateTime);
  }

  @Override
  public String toString() {
    return "DdData{" +
            "fileId=" + fileId +
            ", fileType=" + fileType +
            ", fileKey=" + fileKey +
            ", createTime=" + createTime +
            ", updateTime=" + updateTime +
            '}';
  }
}
