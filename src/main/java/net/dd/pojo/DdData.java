package net.dd.pojo;


import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.BeanUtils;
import org.springframework.lang.Nullable;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Objects;

public class DdData implements Serializable {

//  @TableId(type = IdType.ASSIGN_ID)
  private long fileId;

  private String fileType;

  @ApiModelProperty(value="访问凭证")
  private String fileKey;

  @ApiModelProperty(value = "创建时间")
  private LocalDateTime createTime;

  @ApiModelProperty(value = "修改时间")
  private LocalDateTime updateTime;

  private String addUrl;

  private static final long serialVersionUID = 1L;

  public DdData() {
  }

  public DdData(String fileType, String fileKey, @Nullable String addUrl) {
    this.fileType = fileType;
    this.fileKey = fileKey;
    this.addUrl = addUrl;
  }

  public DdData(long fileId, String fileType, String fileKey, LocalDateTime createTime, LocalDateTime updateTime, String addUrl) {
    this.fileId = fileId;
    this.fileType = fileType;
    this.fileKey = fileKey;
    this.createTime = createTime;
    this.updateTime = updateTime;
    this.addUrl = addUrl;
  }

  public long getFileId() {
    return fileId;
  }

  public void setFileId(long fileId) {
    this.fileId = fileId;
  }


  public String getFileType() {
    return fileType;
  }

  public void setFileType(String fileType) {
    this.fileType = fileType;
  }


  public String getFileKey() {
    return fileKey;
  }

  public void setFileKey(String fileKey) {
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


  public void setAddUrl(String addUrl) {
    this.addUrl = addUrl;
  }


  public String getAddUrl() {
    return addUrl;
  }

  @Override
  public String toString() {
    return "DdData{" +
            "fileId=" + fileId +
            ", fileType='" + fileType + '\'' +
            ", fileKey='" + fileKey + '\'' +
            ", createTime=" + createTime +
            ", updateTime=" + updateTime +
            ", addUrl='" + addUrl + '\'' +
            '}';
  }

  public static void main(String[] args) {
    DdData ddData = new DdData();
    ddData.setAddUrl(" ");
    System.out.println(ddData.getAddUrl().isBlank());
  }
}
