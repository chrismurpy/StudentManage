package com.murphy.dao;

import com.murphy.bean.Menu;

import java.util.List;

/**
 * @author murphy
 */
public interface MenuDao {
    /**
     * 查询菜单列表
     * @return
     */
    public List<Menu> getMenuList();
}
