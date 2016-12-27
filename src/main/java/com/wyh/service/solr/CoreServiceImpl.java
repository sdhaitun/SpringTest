package com.wyh.service.solr;


import com.sun.tools.javac.util.List;
import com.wyh.dao.solr.CoreDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * Created by root on 2016/12/27.
 */

@Service
public class CoreServiceImpl implements CoreService{
    @Autowired
    CoreDao coreDao;

    @Override
    public void test() {
        System.out.println(coreDao.findById(1));
    }

    @Override
    public int save(Object obj) {
        return 0;
    }

    @Override
    public int delete(Object obj) {
        return 0;
    }

    @Override
    public int update(Object obj) {
        return 0;
    }

    @Override
    public Object selectById(Serializable serializable) {
        return null;
    }

    @Override
    public List selectAll() {
        return null;
    }

    @Override
    public int deleteById(Serializable serializable) {
        return 0;
    }
}
