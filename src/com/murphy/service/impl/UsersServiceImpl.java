package com.murphy.service.impl;

import com.murphy.bean.Menu;
import com.murphy.bean.Role;
import com.murphy.bean.Users;
import com.murphy.dao.RoleDao;
import com.murphy.dao.UsersDao;
import com.murphy.dao.impl.RoleDaoImpl;
import com.murphy.dao.impl.UsersDaoImpl;
import com.murphy.service.UsersService;

import java.util.ArrayList;
import java.util.List;

/**
 * @author murphy
 */
public class UsersServiceImpl implements UsersService {

    private UsersDao usersDao = new UsersDaoImpl();
    private RoleDao roleDao = new RoleDaoImpl();

    @Override
    public Users login(String username, String password) {
        Users users = usersDao.login(username, password);
        if (users == null){
            return null;
        }
        // 根据角色ID查询角色、菜单信息(三表联查)
        Integer roleId = users.getRoleId();
        Role role = roleDao.findById(roleId);
        // 需要对菜单进行分级
        List<Menu> menuList = role.getMenuList();
        List<Menu> newMenuList = new ArrayList<>();
        for (Menu menu : menuList) {
            if (menu.getUpMenuId()==0){
                ArrayList<Menu> secondList = new ArrayList<>();
                // 说明是一级菜单
                for (Menu second : menuList) {
                    if (second.getUpMenuId().equals(menu.getMenuId())){
                        secondList.add(second);
                    }
                }
                menu.setSecondMenuList(secondList);
                newMenuList.add(menu);
            }
        }
        role.setMenuList(newMenuList);
        users.setRole(role);

        return users;
    }

    @Override
    public List<Users> getUsersList(int pageIndex, int pageSize) {
        return usersDao.getUsersList(pageIndex, pageSize);
    }

    @Override
    public int total() {
        return usersDao.total();
    }

    @Override
    public int insertUser(Users users) {
        return usersDao.insertUser(users);
    }
}
