package com.murphy.dao.impl;

import com.murphy.bean.Menu;
import com.murphy.dao.DbUtils;
import com.murphy.dao.MenuDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author murphy
 */
public class MenuDaoImpl extends DbUtils implements MenuDao {
    @Override
    public List<Menu> getMenuList() {
        List<Menu> menuList = new ArrayList<Menu>();
        try {
            String sql = "select * from menu";
            resultSet = query(sql, null);
            while (resultSet.next()){
                Menu menu = new Menu();
                menu.setMenuId(resultSet.getInt(1));
                menu.setMenuName(resultSet.getString(2));
                menu.setUpMenuId(resultSet.getInt(3));
                menu.setState(resultSet.getInt(4));
                menu.setDesc(resultSet.getString(5));
                menu.setUrl(resultSet.getString(6));
                menuList.add(menu);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeAll();
        }
        return menuList;
    }
}
