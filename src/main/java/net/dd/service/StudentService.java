package net.dd.service;

import mapper.Student;

public interface StudentService {
    int deleteByPrimaryKey(Long fileId);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Long fileId);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);
}