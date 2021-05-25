package com.murphy.dao.impl;

import com.murphy.bean.Role;
import com.murphy.dao.DbUtils;
import com.murphy.dao.RoleDao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author murphy
 */
public class RoleDaoImpl extends DbUtils implements RoleDao {

    @Override
    public List<Role> getLists() {
        List list = new ArrayList();
        String sql = "select * from role";
        try {
            resultSet = query(sql,null);
            while (resultSet.next()){
                Role role = new Role();
                role.setRoleId(resultSet.getInt(1));
                role.setRoleName(resultSet.getString(2));
                list.add(role);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeAll();
        }
        return list;
    }
}
