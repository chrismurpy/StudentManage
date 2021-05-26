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

    /**
     * 查询所有角色的列表
     * @param pageIndex
     * @param pageSize
     * @return
     */
    public List<Role> getRoleList(int pageIndex, int pageSize);

    /**
     * 查询总条数
     * @return
     */
    public int total();
}
