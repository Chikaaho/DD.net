package net.dd.mapper;

import mapper.Student;

public interface StudentMapper {
    int deleteByPrimaryKey(Long file_id);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Long file_id);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);
}