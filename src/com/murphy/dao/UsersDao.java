package com.murphy.dao;

import com.murphy.bean.Users;

/**
 * @author murphy
 */
public interface UsersDao {
    /**
     * 登录方法
     */
    public Users login(String username, String password);
}
