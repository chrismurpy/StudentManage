package com.murphy.dao.impl;

import com.murphy.bean.Student;
import com.murphy.dao.DbUtils;
import com.murphy.dao.StudentDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author murphy
 */
public class StudentDaoImpl extends DbUtils implements StudentDao {


    @Override
    public List<Student> getStudents(String name,String stuNo,int sex,int pageIndex,int pageSize) {
        List list = new ArrayList<Student>();
        List params = new ArrayList();
        try {
            StringBuffer sqlBuff = new StringBuffer(" select * from student where 1=1 ");
            if (name!=null && name.length()>0){
                sqlBuff.append(" and stuname like ? ");
                params.add("%"+name+"%");
            }
            if (stuNo!=null && stuNo.length()>0){
                sqlBuff.append(" and stuno=? ");
                params.add(stuNo);
            }
            if (sex!=-1){
                sqlBuff.append(" and sex=? ");
                params.add(sex);
            }
            // 分页
            sqlBuff.append(" limit ?,?");
            // limit  (pageIndex-1)*pageSize,pageSize;
            params.add((pageIndex-1)*pageSize);
            params.add(pageSize);


            resultSet = query(sqlBuff.toString(), params);
            while (resultSet.next()){
                Student student = new Student();
                student.setStuId(resultSet.getInt("stuid"));
                student.setStuNo(resultSet.getString("stuno"));
                student.setStuName(resultSet.getString("stuname"));
                student.setSex(resultSet.getInt("sex"));
                student.setPhone(resultSet.getString("phone"));
                student.setProfession(resultSet.getString("profession"));
                student.setRegDate(resultSet.getDate("regdate"));
                list.add(student);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeAll();
        }
        return list;
    }

    @Override
    public int total(String name, String stuNo, int sex) {
        int total = 0;
        List params = new ArrayList();
        try {
            StringBuffer sqlBuff = new StringBuffer(" select count(*) from student where 1=1 ");
            if (name != null && name.length() > 0) {
                sqlBuff.append(" and stuname like ? ");
                params.add("%" + name + "%");
            }
            if (stuNo != null && stuNo.length() > 0) {
                sqlBuff.append(" and stuno=? ");
                params.add(stuNo);
            }
            if (sex != -1) {
                sqlBuff.append(" and sex=? ");
                params.add(sex);
            }
            resultSet = query(sqlBuff.toString(), params);
            while (resultSet.next()){
                total = resultSet.getInt(1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeAll();
        }
        return total;
    }
}
