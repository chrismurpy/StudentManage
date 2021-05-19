package com.murphy.service;

import com.murphy.bean.Users;

import java.util.List;

/**
 * @author murphy
 */
public interface UsersService {
    /**
     * 登录方法
     * @param username
     * @param password
     */
    public Users login(String username, String password);

    /**
     * 查询用户列表
     * @param pageIndex
     * @param pageSize
     * @return
     */
    public List<Users> getUsersList(int pageIndex, int pageSize);

    /**
     * 查询总条数
     * @return
     */
    public int total();
}
