package com.murphy.service.impl;

import com.murphy.bean.Student;
import com.murphy.dao.StudentDao;
import com.murphy.dao.impl.StudentDaoImpl;
import com.murphy.service.StudentService;

import java.util.List;

/**
 * @author murphy
 */
public class StudentServiceImpl implements StudentService {

    private StudentDao studentDao = new StudentDaoImpl();

    @Override
    public List<Student> getStudents(String name,String stuNo,int sex,int pageIndex,int pageSize) {
        return studentDao.getStudents(name, stuNo, sex, pageIndex, pageSize);
    }

    @Override
    public int total(String name, String stuNo, int sex) {
        return studentDao.total(name, stuNo, sex);
    }

    @Override
    public int insertStu(Student student) {
        return studentDao.insertStu(student);
    }

    @Override
    public Student findById(int sid) {
        return studentDao.findById(sid);
    }

    @Override
    public Student findByStuNo(String stuNo) {
        return studentDao.findByStuNo(stuNo);
    }

    @Override
    public int updateStu(Student student) {
        return studentDao.updateStu(student);
    }

    @Override
    public int deleteStu(String sid) {
        return studentDao.deleteStu(sid);
    }
}
