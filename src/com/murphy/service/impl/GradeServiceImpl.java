package com.murphy.service.impl;

import com.murphy.bean.Grade;
import com.murphy.dao.GradeDao;
import com.murphy.dao.impl.GradeDaoImpl;
import com.murphy.service.GradeService;

import java.util.List;

/**
 * @author murphy
 */
public class GradeServiceImpl implements GradeService {

    private GradeDao gradeDao = new GradeDaoImpl();

    @Override
    public List<Grade> getList() {
        return gradeDao.getList();
    }
}
