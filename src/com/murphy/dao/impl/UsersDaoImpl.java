package com.murphy.dao.impl;

import com.murphy.bean.Role;
import com.murphy.bean.Users;
import com.murphy.dao.DbUtils;
import com.murphy.dao.UsersDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
                users.setRoleId(resultSet.getInt("roleId"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeAll();
        }
        return users;
    }

    @Override
    public List<Users> getUsersList(int pageIndex, int pageSize) {
        List<Users> usersList = new ArrayList<Users>();
        try {
            String sql = "select userid,loginname,realname,rolename from users u,role r where u.roleid=r.roleid limit ?,?";
            List params = new ArrayList();
            params.add((pageIndex-1)*pageSize);
            params.add(pageSize);
            resultSet = query(sql, params);
            while (resultSet.next()){
                // 1. 取出各表的数据
                Users users = new Users();
                users.setUserId(resultSet.getInt("userid"));
                users.setLoginName(resultSet.getString("loginname"));
                users.setRealName(resultSet.getString("realname"));

                Role role = new Role();
                role.setRoleName(resultSet.getString("rolename"));
                // 2. 建立关系
                users.setRole(role);
                usersList.add(users);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeAll();
        }
        return usersList;
    }

    @Override
    public int total() {
        int total = 0;
        try {
            String sql = "select count(1) from users u,role r where u.roleid=r.roleid";
            resultSet = query(sql, null);
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
    public int insertUser(Users users) {
        int i = 0;
        try {
            String sql = "insert into users values(null,?,?,?,?,?,?,?,?,?,?)";
            List params = new ArrayList();
            params.add(users.getLoginName());
            params.add(users.getPassword());
            params.add(users.getRealName());
            params.add(users.getSex());
            params.add(users.getEmail());
            params.add(users.getAddress());
            params.add(users.getPhone());
            params.add(users.getCardId());
            params.add(users.getDesc());
            params.add(users.getRoleId());
            i = update(sql,params);
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            closeAll();
        }
        return i;
    }

    @Override
    public Users findById(int uid) {
        Users user = new Users();
        try {
            String sql = "select * from users where userid = ?";
            List params = new ArrayList();
            params.add(uid);
            resultSet = query(sql,params);
            while (resultSet.next()){
                user.setUserId(resultSet.getInt(1));
                user.setLoginName(resultSet.getString(2));
                user.setPassword(resultSet.getString(3));
                user.setRealName(resultSet.getString(4));
                user.setSex(resultSet.getInt(5));
                user.setEmail(resultSet.getString(6));
                user.setAddress(resultSet.getString(7));
                user.setPhone(resultSet.getString(8));
                user.setCardId(resultSet.getString(9));
                user.setDesc(resultSet.getString(10));
                user.setRoleId(resultSet.getInt(11));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeAll();
        }
        return user;
    }

    @Override
    public int updateUser(Users user) {
        int update = 0;
        try {
            String sql = "update users set loginname=?,password=?,realname=?,sex=?,email=?,address=?," +
                    "phone=?,cardid=?,roleid=? where userid=?";
            List params = new ArrayList();
            params.add(user.getLoginName());
            params.add(user.getPassword());
            params.add(user.getRealName());
            params.add(user.getSex());
            params.add(user.getEmail());
            params.add(user.getAddress());
            params.add(user.getPhone());
            params.add(user.getCardId());
            params.add(user.getRoleId());
            params.add(user.getUserId());
            update = update(sql,params);
        } finally {
            closeAll();
        }
        return update;
    }
}
