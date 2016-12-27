package com.dao;

import com.wyh.dao.TestMapper;
import com.wyh.dao.solr.CoreDao;
import com.wyh.entity.solr.NewCore;
import com.wyh.entity.solr.Patent;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.solr.core.query.result.HighlightEntry;
import org.springframework.data.solr.core.query.result.HighlightPage;
import wyh.common.BaseJunit;

import java.util.List;

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

    @Autowired
    CoreDao coreDao;

    @Test
    @Ignore
    public void test(){
        logger.info("fsf{}fsf", new com.wyh.entity.Test());
        logger.info("{}","test");
        System.out.println(testMapper.selectByPrimaryKey(1).getName());
    }

    @Test
//    @Ignore
    public void testCore() {
//        Page<NewCore> page = coreDao.findAll(new PageRequest(0,3));
//        for (NewCore core : page){
//            System.out.println(core.getName());
//        }
//
//        System.out.println(page.getTotalElements());
//        System.out.println(coreDao.exists(100));
//        System.out.println(coreDao.exists(1));
//        System.out.println(coreDao.findOne(1).getName());
        List<NewCore> p = coreDao.findByName("李朝奎");
        for (NewCore cor : p) {
            System.out.println(cor.getName() + "i");
        }
        HighlightPage<NewCore> p2 = coreDao.findBySAndName("中国", "中国", new PageRequest(0, 10));
        for (HighlightEntry<NewCore> h : p2.getHighlighted()){
            System.out.println(h.getEntity().getId() + h.getEntity().getName() + h.getEntity().getS() );
            for (HighlightEntry.Highlight highlight : h.getHighlights()) {
                System.out.println(highlight.getSnipplets().get(0));
            }
        }
//        System.out.println(coreDao.findById(1));
//        System.out.println(coreDao.countByName("黄"));
    }

}
