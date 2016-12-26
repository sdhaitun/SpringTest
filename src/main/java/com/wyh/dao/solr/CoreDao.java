package com.wyh.dao.solr;

import com.wyh.entity.solr.NewCore;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.solr.core.query.result.HighlightPage;
import org.springframework.data.solr.repository.Highlight;
import org.springframework.data.solr.repository.Query;
import org.springframework.data.solr.repository.SolrCrudRepository;

import java.util.List;

/**
 * Created by root on 2016/12/26.
 */
public interface CoreDao extends SolrCrudRepository<NewCore, Integer>{

    /**
     *
     * @param name
     * @return
     */
//    @Highlight(prefix = "<em>", postfix = "</em>")
    List<NewCore> findByName(String name);

    List<NewCore> findByS(String name);

    NewCore findById(int id);
}
