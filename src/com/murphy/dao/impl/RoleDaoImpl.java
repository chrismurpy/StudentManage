package com.murphy.dao.impl;

import com.murphy.bean.Menu;
import com.murphy.bean.Role;
import com.murphy.dao.DbUtils;
import com.murphy.dao.RoleDao;

import java.sql.ResultSet;
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

    @Override
    public List<Role> getRoleList(int pageIndex, int pageSize) {
        List<Role> roleList = new ArrayList<Role>();
        try {
            String sql = "select * from role limit ?,?";
            List params = new ArrayList();
            params.add((pageIndex-1)*pageSize);
            params.add(pageSize);

            resultSet = query(sql,params);
            while (resultSet.next()){
                Role role = new Role();
                role.setRoleId(resultSet.getInt("roleid"));
                role.setRoleName(resultSet.getString("rolename"));
                role.setRoleState(resultSet.getInt("rolestate"));
                roleList.add(role);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeAll();
        }
        return roleList;
    }

    @Override
    public int total() {
        int total = 0;
        try {
            String sql = "select count(1) from role";
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
    public int insert(Role role) {
        // 新增数据的ID
        int key = 0;
        try {
            String sql = "insert into role values(null,?,?)";
            List params = new ArrayList();
            params.add(role.getRoleName());
            params.add(role.getRoleState());
            // 保存受影响的行数
            int update = update(sql,params);
            ResultSet generatedKeys = pps.getGeneratedKeys();
            if (generatedKeys.next()){
                key = generatedKeys.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeAll();
        }
        return key;
    }

    @Override
    public Role findById(int roleId) {
        Role role = new Role();
        List<Menu> menuList = new ArrayList<>();
        try {
            String sql = "select * from role r,menu m, middle mid where r.roleid=mid.roleid " +
                    "and mid.menuid=m.menuid and r.roleid=?";
            List params = new ArrayList();
            params.add(roleId);
            resultSet = query(sql,params);
            while (resultSet.next()){
                role.setRoleId(resultSet.getInt("roleid"));
                role.setRoleName(resultSet.getString("rolename"));
                role.setRoleState(resultSet.getInt("rolestate"));

                Menu menu = new Menu();
                menu.setMenuId(resultSet.getInt("menuid"));
                menu.setMenuName(resultSet.getString("menuname"));
                menu.setUrl(resultSet.getString("url"));
                menu.setState(resultSet.getInt("state"));
                menu.setUpMenuId(resultSet.getInt("upmenuid"));
                menuList.add(menu);
            }
            role.setMenuList(menuList);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeAll();
        }
        return role;
    }

    @Override
    public int delete(int rid) {
        int delete = 0;
        try {
            String sql = "delete from role where roleid = ?";
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
    public int state(int roleState, int rid) {
        int update = 0;
        try {
            String sql = "update role set rolestate = ? where roleid = ?";
            List params = new ArrayList();
            params.add(roleState);
            params.add(rid);
            update = update(sql,params);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeAll();
        }
        return update;
    }
}
