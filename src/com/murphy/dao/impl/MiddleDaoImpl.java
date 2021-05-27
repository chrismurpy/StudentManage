package com.murphy.dao.impl;

import com.murphy.bean.Middle;
import com.murphy.bean.Role;
import com.murphy.dao.DbUtils;
import com.murphy.dao.MiddleDao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MiddleDaoImpl extends DbUtils implements MiddleDao {
    @Override
    public int insertMiddle(int roleId, String[] ids) {
        int k = 0;
        try {
            String sql = "insert into middle values(null,?,?)";
            // 批量新增
            pps = getPps(sql);
            for (String id : ids) {
                pps.setInt(1,roleId);
                pps.setString(2,id);
                pps.addBatch();
            }
            pps.executeBatch();
            k = 1;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeAll();
        }
        return k;
    }

    @Override
    public int deleteMiddle(int rid) {
        int delete = 0;
        try {
            String sql = "delete from middle where roleid = ?";
            List params = new ArrayList();
            params.add(rid);
            delete = update(sql,params);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeAll();
        }
        return delete;
    }

    @Override
    public List<Middle> findMiddle(int rid) {
        List<Middle> middleList = new ArrayList<>();
        try {
            String sql = "select m.middleid, m.roleid, m.menuid, r.rolename from middle m," +
                    "role r where  r.roleid=m.roleid and r.roleid = ?";
            List params = new ArrayList();
            params.add(rid);
            resultSet = query(sql,params);
            while (resultSet.next()){
                Middle middle = new Middle();
                middle.setMiddleId(resultSet.getInt(1));
                middle.setRoleId(resultSet.getInt(2));
                middle.setMenuId(resultSet.getInt(3));
                middle.setRoleName(resultSet.getString(4));
                middleList.add(middle);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeAll();
        }
        return middleList;
    }
}
