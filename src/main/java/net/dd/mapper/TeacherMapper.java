package net.dd.mapper;

import mapper.Teacher;

public interface TeacherMapper {
    int deleteByPrimaryKey(Long file_id);

    int insert(Teacher record);

    int insertSelective(Teacher record);

    Teacher selectByPrimaryKey(Long file_id);

    int updateByPrimaryKeySelective(Teacher record);

    int updateByPrimaryKey(Teacher record);
}