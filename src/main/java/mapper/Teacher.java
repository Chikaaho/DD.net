package mapper;

import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * dd_data
 * @author 
 */
@Data
public class Teacher implements Serializable {
    private Long file_id;

    /**
     * 文件类型 0:txt 1:image 2:video
     */
    private Boolean file_type;

    /**
     * 访问凭证
     */
    private Long file_key;

    /**
     * 创建文件时间
     */
    private LocalDateTime create_time;

    /**
     * 最近一次修改文件时间
     */
    private LocalDateTime update_time;

    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Teacher other = (Teacher) that;
        return (this.getFile_id() == null ? other.getFile_id() == null : this.getFile_id().equals(other.getFile_id()))
            && (this.getFile_type() == null ? other.getFile_type() == null : this.getFile_type().equals(other.getFile_type()))
            && (this.getFile_key() == null ? other.getFile_key() == null : this.getFile_key().equals(other.getFile_key()))
            && (this.getCreate_time() == null ? other.getCreate_time() == null : this.getCreate_time().equals(other.getCreate_time()))
            && (this.getUpdate_time() == null ? other.getUpdate_time() == null : this.getUpdate_time().equals(other.getUpdate_time()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getFile_id() == null) ? 0 : getFile_id().hashCode());
        result = prime * result + ((getFile_type() == null) ? 0 : getFile_type().hashCode());
        result = prime * result + ((getFile_key() == null) ? 0 : getFile_key().hashCode());
        result = prime * result + ((getCreate_time() == null) ? 0 : getCreate_time().hashCode());
        result = prime * result + ((getUpdate_time() == null) ? 0 : getUpdate_time().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", file_id=").append(file_id);
        sb.append(", file_type=").append(file_type);
        sb.append(", file_key=").append(file_key);
        sb.append(", create_time=").append(create_time);
        sb.append(", update_time=").append(update_time);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}