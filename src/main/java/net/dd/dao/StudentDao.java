package net.dd.dao;

import mapper.Student;

public interface StudentDao {
    int deleteByPrimaryKey(Long fileId);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Long fileId);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);
}