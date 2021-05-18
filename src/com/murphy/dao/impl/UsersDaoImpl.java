package com.murphy.dao.impl;

import com.murphy.bean.Users;
import com.murphy.dao.DbUtils;
import com.murphy.dao.UsersDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author murphy
 */
public class UsersDaoImpl extends DbUtils implements UsersDao {
    @Override
    public Users login(String username, String password) {
        Users users = null;
        try {
            String sql = "select * from users where loginname=? and password=?";
            ArrayList arrayList = new ArrayList();
            arrayList.add(username);
            arrayList.add(password);
            resultSet = query(sql, arrayList);

            if (resultSet==null){
                return null;
            }
            while (resultSet.next()){
                users = new Users();
                users.setLoginName(username);
                users.setRealName(resultSet.getString(4));
                users.setUserId(resultSet.getInt(1));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeAll();
        }
        return users;
    }
}
