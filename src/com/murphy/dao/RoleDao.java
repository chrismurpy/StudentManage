package com.murphy.dao;

import com.murphy.bean.Role;
import com.murphy.bean.Student;

import java.util.List;

/**
 * @author murphy
 */
public interface RoleDao {
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
     * @param role
     * @return
     */
    public int insert(Role role);

    /**
     * 查询角色信息
     * @param roleId
     * @return
     */
    public Role findById(int roleId);

    /**
     * 删除角色信息
     * @param rid
     * @return
     */
    public int delete(int rid);
}
