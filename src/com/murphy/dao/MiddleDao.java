package com.murphy.dao;

import com.murphy.bean.Middle;

import java.util.List;

/**
 * @author murphy
 */
public interface MiddleDao {
    /**
     * 新增中间表角色
     * @param roleId
     * @param ids
     * @return
     */
    public int insertMiddle(int roleId, String[] ids);

    /**
     * 删除中间表角色
     * @param rid
     * @return
     */
    public int deleteMiddle(int rid);

    /**
     * 查权限
     * @param rid
     * @return
     */
    public List<Middle> findMiddle(int rid);
}
