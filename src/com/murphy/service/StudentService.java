package com.murphy.service;

import com.murphy.bean.Student;

import java.util.List;

/**
 * @author murphy
 */
public interface StudentService {
    /**
     * 获取学生信息列表
     * @return studentList
     * @param name
     * @param stuNo
     * @param sex
     */
    public List<Student> getStudents(String name,String stuNo,int sex);
}
