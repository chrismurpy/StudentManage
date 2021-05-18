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
     * @param name 姓名
     * @param stuNo 学号
     * @param sex 性别
     * @param pageIndex 页码值
     * @param pageSize 每页显示条数
     */
    public List<Student> getStudents(String name,String stuNo,int sex,int pageIndex,int pageSize);

    /**
     * 获得总条数(基于模糊查询)
     * @return int
     * @param name
     * @param stuNo
     * @param sex
     */
    public int total(String name,String stuNo,int sex);

    /**
     * 新增学生
     * @param student
     * @return
     */
    public int insertStu(Student student);

    /**
     * 主键查询
     * @param sid
     * @return
     */
    public Student findById(int sid);

    /**
     * 修改学生
     * @param student
     * @return
     */
    public int updateStu(Student student);
}
