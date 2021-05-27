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

    /**
     * 新增角色
     * @param roleName
     * @param state
     * @param ids
     * @return
     */
    public int insertRole(String roleName, String state, String[] ids);

    /**
     * 查询角色信息
     * @param rid
     * @return
     */
    public Role findById(int rid);

    /**
     * 删除角色信息
     * @param rid
     * @return
     */
    public int deleteRole(int rid);

    /**
     * 角色状态(启用/禁用)
     * @param roleState
     * @param rid
     * @return
     */
    public int state(int roleState, int rid);
}
