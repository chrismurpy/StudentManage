package com.murphy.service;

import com.murphy.bean.Menu;

import java.util.List;

/**
 * @author murphy
 */
public interface MenuService {
    /**
     * 查询菜单列表
     * @return
     */
    public List<Menu> getMenuList();
}
