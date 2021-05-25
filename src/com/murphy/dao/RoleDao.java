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
}
