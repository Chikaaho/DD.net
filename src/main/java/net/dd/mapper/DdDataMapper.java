package net.dd.mapper;

import net.dd.pojo.DdData;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DdDataMapper {

    // 根据文件id查询
    DdData selectByFileId(@Param("fileId") long fileId);

    // 根据文件key查询
    DdData selectByFileKey(@Param("filekey") String filekey);

    // 更新文件信息
    int updateFile(@Param("fileId") long fileId, @Param("ddData") DdData ddData);

    // 删除文件
    int deleteById(@Param("fileId") long fileId);

    // 添加文件
    void insertFile(@Param("fileType") String fileType, @Param("fileKey") String fileKey, @Param("addUrl") String addUrl);

    // 查询所有文件
    List<DdData> selectAllFile();

}
