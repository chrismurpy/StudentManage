package com.murphy.dao.impl;

import com.murphy.bean.Student;
import com.murphy.dao.DbUtils;
import com.murphy.dao.StudentDao;
import com.murphy.util.StudentEnum;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
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
            StringBuffer sqlBuff = new StringBuffer(" select * from student where 1=1 and state!=4 ");
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
            StringBuffer sqlBuff = new StringBuffer(" select count(*) from student where 1=1 and state!=4 ");
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

    @Override
    public int insertStu(Student student) {
        int i = 0;
        try {
            String sql = "insert into student values(null,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            List params = new ArrayList();
            params.add(student.getStuName());
            params.add(student.getStuNo());
            params.add(student.getSex());
            params.add(student.getPhone());
            params.add(student.getEmail());
            params.add(student.getRegistered());
            params.add(student.getAddress());
            params.add(student.getProfession());
            params.add(student.getIdNumber());
            params.add(student.getPolitics());
            params.add(new Date());
            // 1 - 在读 / 2 - 休学 / 3 - 退学 / 4 - 删除
            params.add(StudentEnum.READING.type);
            params.add(student.getIntroduction());
            params.add(student.getGid());
            i = update(sql,params);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeAll();
        }
        return i;
    }

    @Override
    public Student findById(int sid) {
        Student student = new Student();
        try {
            String sql = "select * from student where stuid = ?";
            List params = new ArrayList();
            params.add(sid);
            resultSet = query(sql, params);
            while (resultSet.next()){
                student.setStuId(resultSet.getInt("stuid"));
                student.setStuNo(resultSet.getString("stuno"));
                student.setStuName(resultSet.getString("stuname"));
                student.setGid(resultSet.getInt("gid"));
                student.setSex(resultSet.getInt("sex"));
                student.setEmail(resultSet.getString("email"));
                student.setPhone(resultSet.getString("phone"));
                student.setRegistered(resultSet.getString("registered"));
                student.setRegDate(resultSet.getDate("regdate"));
                student.setPolitics(resultSet.getString("politics"));
                student.setIdNumber(resultSet.getString("idnumber"));
                student.setProfession(resultSet.getString("profession"));
                student.setIntroduction(resultSet.getString("introduction"));
                student.setAddress(resultSet.getString("address"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeAll();
        }
        return student;
    }

    @Override
    public Student findByStuNo(String stuNo) {
        Student student = new Student();
        try {
            String sql = "select * from student where stuno = ?";
            List params = new ArrayList();
            params.add(stuNo);
            resultSet = query(sql,params);
            while (resultSet.next()){
                student.setStuId(resultSet.getInt("stuid"));
                student.setStuNo(resultSet.getString("stuno"));
                student.setStuName(resultSet.getString("stuname"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeAll();
        }
        return student;
    }

    @Override
    public int updateStu(Student student) {
        int update = 0;
        try {
            String sql = "update student set stuname=?,stuno=?,sex=?,phone=?,email=?,registered=?" +
                    ",profession=?,idnumber=?,politics=?,address=?,introduction=? where stuid=?";
            List params = new ArrayList();
            params.add(student.getStuName());
            params.add(student.getStuNo());
            params.add(student.getSex());
            params.add(student.getPhone());
            params.add(student.getEmail());
            params.add(student.getRegistered());
            params.add(student.getProfession());
            params.add(student.getIdNumber());
            params.add(student.getPolitics());
            params.add(student.getAddress());
            params.add(student.getIntroduction());
            params.add(student.getStuId());
            update = update(sql, params);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeAll();
        }
        return update;
    }

    @Override
    public int deleteStu(String sid) {
        int update = 0;
        try {
            String sql = "update student set state=? where stuid=?";
            List params = new ArrayList();
            params.add(StudentEnum.DELETE.type);
            params.add(sid);
            update = update(sql, params);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeAll();
        }
        return update;
    }
}
