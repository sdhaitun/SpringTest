package com.service;

import com.wyh.service.solr.CoreService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import wyh.common.BaseJunit;

/**
 * Created by root on 2016/12/27.
 */
public class TestService extends BaseJunit{

    @Autowired
    com.wyh.service.TestService testService;

    @Autowired
    CoreService coreService;

    @Test
    public void testTest() {
        testService.test();
        System.out.println(testService.deleteById(1));
    }

    @Test
    public void testCore() {
        coreService.test();
    }
}
