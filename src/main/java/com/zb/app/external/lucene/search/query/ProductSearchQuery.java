/*
 * Copyright 2011-2016 ZuoBian.com All right reserved. This software is the confidential and proprietary information of
 * ZuoBian.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with ZuoBian.com.
 */
package com.zb.app.external.lucene.search.query;

import java.io.Serializable;
import java.util.List;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrQuery.ORDER;

import com.zb.app.external.lucene.search.utils.ZuobianSolrQueryConvert;
import com.zb.app.external.lucene.solr.query.SearchQuery;

/**
 * @author zxc Sep 3, 2014 12:20:39 PM
 */
public class ProductSearchQuery implements SearchQuery, Serializable {

    private static final long serialVersionUID = 3401107234009904866L;

    private int               rows             = 30;                  // 行数
    private int               start;                                  // 开始
    private String            Title;                                  // 线路标题
    private Integer           lType;                                  // 线路类型
    private Integer           lDay;                                   // 线路天数
    private Long[]            zIds;                                   // 专线类别
    private Long              zId;                                    // 专线类别
    private String            lArrivalCity;                           // 到达城市
    private List<String>      products;                               // 分词后集合
    private String            lGroupNumber;                           // 产品编号
    private boolean           expectMatch      = false;               // 是否精确

    public Long getzId() {
        return zId;
    }

    public void setzId(Long zId) {
        this.zId = zId;
    }

    public Integer getlType() {
        return lType;
    }

    public void setlType(Integer lType) {
        this.lType = lType;
    }

    public Integer getlDay() {
        return lDay;
    }

    public void setlDay(Integer lDay) {
        this.lDay = lDay;
    }

    public Long[] getzIds() {
        return zIds;
    }

    public void setzIds(Long... zIds) {
        this.zIds = zIds.length == 0 ? new Long[] { -1L } : zIds;
    }

    public String getlArrivalCity() {
        return lArrivalCity;
    }

    public void setlArrivalCity(String lArrivalCity) {
        this.lArrivalCity = lArrivalCity;
    }

    public ProductSearchQuery(String lGroupNumber) {
        this.lGroupNumber = lGroupNumber;
    }

    public String getlGroupNumber() {
        return lGroupNumber;
    }

    public void setlGroupNumber(String lGroupNumber) {
        this.lGroupNumber = lGroupNumber;
    }

    public ProductSearchQuery(List<String> products) {
        this.products = products;
    }

    public ProductSearchQuery(String title, List<String> products) {
        this.Title = title;
        this.products = products;
    }

    public boolean isExpectMatch() {
        return expectMatch;
    }

    public void setExpectMatch(boolean expectMatch) {
        this.expectMatch = expectMatch;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public ProductSearchQuery() {
        super();
    }

    public void setStart(int start) {
        this.start = start;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getTitle() {
        return Title;
    }

    @Override
    public int getRows() {
        return rows;
    }

    @Override
    public int getStart() {
        return start;
    }

    public List<String> getProducts() {
        return products;
    }

    public void setProducts(List<String> products) {
        this.products = products;
    }

    @Override
    public String getSortFiled() {
        return "lTile";
    }

    @Override
    public ORDER getOrderBy() {
        return ORDER.asc;
    }

    @Override
    public SolrQuery toSolrQuery() {
        return ZuobianSolrQueryConvert.to(this);
    }
}
