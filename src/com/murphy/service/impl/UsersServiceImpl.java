package com.murphy.service.impl;

import com.murphy.bean.Users;
import com.murphy.dao.UsersDao;
import com.murphy.dao.impl.UsersDaoImpl;
import com.murphy.service.UsersService;

import java.util.List;

/**
 * @author murphy
 */
public class UsersServiceImpl implements UsersService {

    private UsersDao usersDao = new UsersDaoImpl();

    @Override
    public Users login(String username, String password) {
        return usersDao.login(username, password);
    }

    @Override
    public List<Users> getUsersList(int pageIndex, int pageSize) {
        return usersDao.getUsersList(pageIndex, pageSize);
    }

    @Override
    public int total() {
        return usersDao.total();
    }

    @Override
    public int insertUser(Users users) {
        return usersDao.insertUser(users);
    }
}
