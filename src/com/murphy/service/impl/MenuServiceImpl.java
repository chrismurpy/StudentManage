package com.murphy.service.impl;

import com.murphy.bean.Menu;
import com.murphy.dao.MenuDao;
import com.murphy.dao.impl.MenuDaoImpl;
import com.murphy.service.MenuService;

import java.util.ArrayList;
import java.util.List;

/**
 * @author murphy
 */
public class MenuServiceImpl implements MenuService {

    private MenuDao menuDao = new MenuDaoImpl();

    @Override
    public List<Menu> getMenuList() {
        // 未分一、二级
        List<Menu> menuList = menuDao.getMenuList();
        // 保证分级以后的菜单
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
        return newMenuList;
    }
}
