package com.murphy.dao;

import com.murphy.bean.Grade;

import java.util.List;

/**
 * @author murphy
 */
public interface GradeDao {
    /**
     * 查询年级列表
     * @return list
     */
    public List<Grade> getList();

}
