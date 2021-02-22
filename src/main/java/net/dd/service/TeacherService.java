package net.dd.service;

import mapper.Teacher;

public interface TeacherService {
    int deleteByPrimaryKey(Long fileId);

    int insert(Teacher record);

    int insertSelective(Teacher record);

    Teacher selectByPrimaryKey(Long fileId);

    int updateByPrimaryKeySelective(Teacher record);

    int updateByPrimaryKey(Teacher record);
}