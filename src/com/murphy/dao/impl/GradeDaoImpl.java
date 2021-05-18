package com.murphy.dao.impl;

import com.murphy.bean.Grade;
import com.murphy.dao.DbUtils;
import com.murphy.dao.GradeDao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author murphy
 */
public class GradeDaoImpl extends DbUtils implements GradeDao {
    @Override
    public List<Grade> getList() {
        List gs = new ArrayList();
        String sql = "select * from grade";
        try {
            resultSet = query(sql,null);
            while (resultSet.next()){
                Grade grade = new Grade();
                grade.setGradeId(resultSet.getInt(1));
                grade.setGradeName(resultSet.getString(2));
                gs.add(grade);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeAll();
        }
        return gs;
    }
}
