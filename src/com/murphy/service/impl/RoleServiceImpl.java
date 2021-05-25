package com.murphy.service.impl;

import com.murphy.bean.Role;
import com.murphy.dao.RoleDao;
import com.murphy.dao.impl.RoleDaoImpl;
import com.murphy.service.RoleService;

import java.util.List;

/**
 * @author murphy
 */
public class RoleServiceImpl implements RoleService {

    private RoleDao roleDao = new RoleDaoImpl();

    @Override
    public List<Role> getLists() {
        return roleDao.getLists();
    }
}
