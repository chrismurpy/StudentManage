package com.murphy.service.impl;

import com.murphy.bean.Users;
import com.murphy.dao.UsersDao;
import com.murphy.dao.impl.UsersDaoImpl;
import com.murphy.service.UsersService;

/**
 * @author murphy
 */
public class UsersServiceImpl implements UsersService {

    private UsersDao usersDao = new UsersDaoImpl();

    @Override
    public Users login(String username, String password) {
        return usersDao.login(username, password);
    }
}
