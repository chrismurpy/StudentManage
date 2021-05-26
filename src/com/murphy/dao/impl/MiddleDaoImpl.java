package com.murphy.dao.impl;

import com.murphy.dao.DbUtils;
import com.murphy.dao.MiddleDao;

import java.sql.SQLException;

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
}
