package net.dd.pojo;

public class DdData {

  private long fileId;
  private long fileType;
  private long fileKey;
  private java.sql.Timestamp createTime;
  private java.sql.Timestamp updateTime;


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

}
