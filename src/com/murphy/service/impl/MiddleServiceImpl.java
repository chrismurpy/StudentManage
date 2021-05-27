package com.murphy.service.impl;

import com.murphy.bean.Middle;
import com.murphy.dao.DbUtils;
import com.murphy.dao.MiddleDao;
import com.murphy.dao.impl.MiddleDaoImpl;
import com.murphy.service.MiddleService;

import java.util.List;

/**
 * @author murphy
 */
public class MiddleServiceImpl extends DbUtils implements MiddleService {

    private MiddleDao middleDao = new MiddleDaoImpl();

    @Override
    public int deleteMiddle(int rid) {
        return middleDao.deleteMiddle(rid);
    }

    @Override
    public List<Middle> findMiddle(int rid) {
        return middleDao.findMiddle(rid);
    }
}
