package net.dd.service;

import net.dd.pojo.DdData;
import org.apache.ibatis.annotations.Param;
import org.springframework.lang.Nullable;

import java.util.List;

public interface DdDataService {

    // 根据文件id查询
    DdData selectByFileId(@Param("fileId") long fileId);

    // 更新文件信息
    int updateFile(@Param("fileId") long fileId, @Param("ddData") DdData ddData);

    // 删除文件
    int deleteById(@Param("fileId") long fileId);

    // 添加文件
    void insertFile(@Param("fileType") String fileType, @Param("fileKey") String fileKey, @Param("studentId") Long studentId, @Param("classesId") Long classesId, @Param("addUrl") String addUrl);

    // 查询所有文件
    List<DdData> selectAllFile();

}
