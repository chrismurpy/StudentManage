package com.murphy.service;

import com.murphy.bean.Role;

import java.util.List;

/**
 * @author murphy
 */
public interface RoleService {

    /**
     * 查询角色列表
     * @return list
     */
    public List<Role> getLists();
}
