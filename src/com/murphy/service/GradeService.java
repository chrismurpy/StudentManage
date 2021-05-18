package com.murphy.service;

import com.murphy.bean.Grade;

import java.util.List;

/**
 * @author murphy
 */
public interface GradeService {

    /**
     * 查询年级列表
     * @return list
     */
    public List<Grade> getList();
}
