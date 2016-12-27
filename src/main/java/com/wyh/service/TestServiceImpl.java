package com.wyh.service;

import com.sun.tools.javac.util.List;
import com.wyh.dao.TestMapper;
import com.wyh.entity.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by root on 2016/12/27.
 */

@Service
public class TestServiceImpl implements TestService {
    @Autowired
    TestMapper testMapper;

    @Override
    public void test() {
        System.out.println(testMapper.selectByPrimaryKey(10));
    }


    @Override
    public int save(Test obj) {
        return 0;
    }

    @Override
    public int delete(Test obj) {
        return 0;
    }

    @Override
    public int update(Test obj) {
        return 0;
    }

    @Override
    public Test selectById(Integer integer) {
        return null;
    }

    @Override
    public List<Test> selectAll() {
        return null;
    }

    @Override
    public int deleteById(Integer integer) {
        return 0;
    }
}
