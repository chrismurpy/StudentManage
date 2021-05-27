package com.murphy.service.impl;

import com.murphy.bean.Role;
import com.murphy.dao.MiddleDao;
import com.murphy.dao.RoleDao;
import com.murphy.dao.impl.MiddleDaoImpl;
import com.murphy.dao.impl.RoleDaoImpl;
import com.murphy.service.RoleService;

import java.util.List;

/**
 * @author murphy
 */
public class RoleServiceImpl implements RoleService {

    private RoleDao roleDao = new RoleDaoImpl();
    private MiddleDao middleDao = new MiddleDaoImpl();

    @Override
    public List<Role> getLists() {
        return roleDao.getLists();
    }

    @Override
    public List<Role> getRoleList(int pageIndex, int pageSize) {
        return roleDao.getRoleList(pageIndex, pageSize);
    }

    @Override
    public int total() {
        return roleDao.total();
    }

    @Override
    public int insertRole(String roleName, String state, String[] ids) {
        // 事务问题
        int k1 = 0;
        try {
            // 1. 新增角色表
            Role role = new Role();
            role.setRoleName(roleName);
            role.setRoleState(Integer.parseInt(state));
            int k = roleDao.insert(role);
            // 2. 新增中间表
            // 如何获得新增数据的ID
            middleDao.insertMiddle(k,ids);
            k1 = 1;
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return k1;
    }

    @Override
    public Role findById(int rid) {
        return roleDao.findById(rid);
    }

    @Override
    public int deleteRole(int rid) {
        return roleDao.delete(rid);
    }
}
