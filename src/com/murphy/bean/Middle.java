package com.murphy.bean;

/**
 * @author murphy
 */
public class Middle {
    Integer middleId;
    Integer roleId;
    Integer menuId;

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
