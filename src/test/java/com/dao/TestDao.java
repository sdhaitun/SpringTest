package com.dao;

import com.wyh.dao.TestMapper;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import wyh.common.BaseJunit;

/**
 * Created by root on 2016/12/23.
 */
public class TestDao extends BaseJunit{
    public final Logger logger = LoggerFactory.getLogger(Test.class);
    /**
     *
     */
    @Autowired
    TestMapper testMapper;
    @Test
    public void test(){
        logger.info("fsf{}fsf", new com.wyh.entity.Test());
        logger.info("{}","test");
       System.out.println(testMapper.selectByPrimaryKey(1).getName());
    }
}
