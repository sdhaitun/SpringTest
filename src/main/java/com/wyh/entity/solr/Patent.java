package com.wyh.entity.solr;


import com.wyh.common.BaseEntity;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.solr.core.mapping.Indexed;
import org.springframework.data.solr.core.mapping.SolrDocument;

import java.util.List;

@NoArgsConstructor
@Data
@SolrDocument(solrCoreName = "patent")
public class Patent extends BaseEntity {
	private static final long serialVersionUID = 1L;
	@Indexed
	@Field
	private String id;
	// 以下是现行patent索引库里有的
	@Indexed
	@Field("title_cn_ais")
	private String title;
	@Indexed
	@Field("abstract_ais")
	private String abstractCn;
	@Indexed
	@Field("apply_number_s")
	private String applyNumber; // 申请号
	@Indexed
	@Field("public_number_s")
	private String publicNumber; // 公开号
	@Indexed
	@Field("year_if")
	private String year;
	@Indexed
	@Field("city_if")
	private String city;
	@Indexed
	@Field("author_ims")
	private List<String> authors;
	@Indexed
	@Field("organization_ifm")
	private List<String> organization;
	@Indexed
	@Field("date_s")
	private String publicdate; // 公开日期

}
