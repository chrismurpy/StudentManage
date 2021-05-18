package com.murphy.bean;

/**
 * @author murphy
 */
public class Users {
    private Integer userId;
    private String loginName;
    private String password;
    private String realName;

    public Users() {
    }

    public Users(Integer userId, String loginName, String password, String realName) {
        this.userId = userId;
        this.loginName = loginName;
        this.password = password;
        this.realName = realName;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }
}
