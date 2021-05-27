package com.murphy.dao.impl;

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
}
