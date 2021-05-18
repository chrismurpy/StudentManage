package com.murphy.dao;

import com.murphy.bean.Student;

import java.util.List;

/**
 * @author murphy
 */
public interface StudentDao {
    /**
     * 获取学生信息列表
     * @return studentList
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
}
