package net.dd.mapper;

import net.dd.pojo.StuSign;
import net.dd.pojo.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface StuSignMapper {
    // 查询签到信息
    List<StuSign> selectStuSign();

    StuSign selectStuSignByNumber(@Param("stunum") long stunum);

    // 修改签到信息
    int updateStuSign(@Param("stunum") long stunum
            ,@Param("signid") String signid);

}
