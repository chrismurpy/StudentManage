package com.murphy.service;

import com.murphy.bean.Users;

/**
 * @author murphy
 */
public interface UsersService {
    /**
     * 登录方法
     */
    public Users login(String username, String password);
}
