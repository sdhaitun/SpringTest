package com.wyh.entity.solr;

import com.wyh.common.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.Indexed;
import org.springframework.data.solr.core.mapping.SolrDocument;

import java.io.Serializable;

/**
 * Created by root on 2016/12/26.
 */

@NoArgsConstructor
@AllArgsConstructor
@Data
@SolrDocument(solrCoreName = "new_core")
public class NewCore extends BaseEntity {
    @Id
    @Field("id")
    @Indexed
    private int id;

    @Field("name")
    @Indexed
    private String name;

    @Field("s")
    @Indexed
    private String s;
}
