package com.murphy.dao;

import com.murphy.bean.Users;

import java.util.List;

/**
 * @author murphy
 */
public interface UsersDao {
    /**
     * 登录方法
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

    /**
     * 新增用户
     * @param users
     * @return
     */
    public int insertUser(Users users);

    /**
     * 主键查询
     * @param uid
     * @return
     */
    public Users findById(int uid);

    /**
     * 修改用户
     * @param user
     * @return
     */
    public int updateUser(Users user);
}
