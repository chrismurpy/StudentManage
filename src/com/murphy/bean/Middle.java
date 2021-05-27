package com.murphy.bean;

/**
 * @author murphy
 */
public class Middle {
    private Integer middleId;
    private Integer roleId;
    private Integer menuId;
    private String roleName;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Integer getMiddleId() {
        return middleId;
    }

    public void setMiddleId(Integer middleId) {
        this.middleId = middleId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    @Override
    public String toString() {
        return "Middle{" +
                "middleId=" + middleId +
                ", roleId=" + roleId +
                ", menuId=" + menuId +
                '}';
    }
}
