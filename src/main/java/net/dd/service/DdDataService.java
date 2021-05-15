package net.dd.service;

import net.dd.pojo.DdData;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DdDataService {

    // 根据文件id查询
    DdData selectByFileId(@Param("fileId") long fileId);

    // 更新文件信息
    int updateFile(@Param("fileId") long fileId, @Param("ddData") DdData ddData);

    // 删除文件
    int deleteById(@Param("fileId") long fileId);

    // 添加文件
    void insertFile(@Param("fileType") int fileType, @Param("fileKey") String fileKey);

    // 查询所有文件
    List<DdData> selectAllFile(@Param("roles") Integer roles);

}
