package com.murphy.service;

import com.murphy.bean.Middle;

import java.util.List;

/**
 * @author murphy
 */
public interface MiddleService {
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
