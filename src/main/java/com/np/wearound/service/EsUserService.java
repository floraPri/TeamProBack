package com.np.wearound.service;

import java.util.ArrayList;
import java.util.List;

import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.bucket.terms.Terms;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.AggregationsContainer;
import org.springframework.data.elasticsearch.core.ElasticsearchAggregations;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;

import com.np.wearound.document.EsAuction;
import com.np.wearound.document.EsFeed;
import com.np.wearound.document.EsFunding;
import com.np.wearound.document.EsSearchRank;
import com.np.wearound.document.EsUser;
import com.np.wearound.dto.RankAgg;
import com.np.wearound.entities.Search;
import com.np.wearound.repository.EsAuctionRepository;
import com.np.wearound.repository.EsUserRepository;

@Service
public class EsUserService {

    @Autowired
    private EsUserRepository esUserRepository;
    
    @Autowired
    private EsAuctionRepository esAuctionRepository;
    
    @Autowired
    private ElasticsearchRestTemplate elasticsearchRestTemplate;
    
    public void searchByRank() {//수정중
        
    }
    
    public SearchHits<EsFunding> searchByFundingInfo (String search) {
    	return elasticsearchRestTemplate.search(
	        new NativeSearchQueryBuilder()
	            .withQuery(QueryBuilders.multiMatchQuery(search, "title", "subcontent","category"))
	            .build(),
	            EsFunding.class
        );
    }
    
    public SearchHits<EsAuction> searchByAuctionInfo(String search) {
    	return elasticsearchRestTemplate.search(
	        new NativeSearchQueryBuilder()
	            .withQuery(QueryBuilders.multiMatchQuery(search, "auctiontitle", "auctioncontent"))
	            .build(),
	        EsAuction.class
        );
    }
    
    public SearchHits<EsFeed> searchByFeedInfo(String search) {
    	return elasticsearchRestTemplate.search(
	        new NativeSearchQueryBuilder()
	            .withQuery(QueryBuilders.multiMatchQuery(search, "feedtitle", "feedcontent"))
	            .build(),
	            EsFeed.class
        );
    }
    
    public SearchHits<EsUser> searchByUserInfo (String search) {
    	System.out.println("<<< EsUserService - searchByUserInfo() >>>");
    	return elasticsearchRestTemplate.search(
	        new NativeSearchQueryBuilder()
	            .withQuery(QueryBuilders.multiMatchQuery(search, "email", "name"))
	            .build(),
	            EsUser.class
        );
    }
    
//    //모든필드 검색
//    public SearchHits<EsAuction> searchAcrossAllFields(String search) {
//        return elasticsearchRestTemplate.search(
//            new NativeSearchQueryBuilder()
//                .withQuery(QueryBuilders.queryStringQuery(search))
//                .build(),
//            EsAuction.class
//        );
//    }
    
//  //test - user 목록 전부 출력
//    public Iterable<EsUser> findUserById() {
//    	System.out.println(" <<<EsUserService - findUserById>>> ");
//        return esUserRepository.findAll();
//    }
//    
//  //test - 경매전부리스트 띄우기
//    public Iterable<EsAuction> findAuctionAll() {
//    	System.out.println(" <<<EsUserService - findAuctionAll>>> ");
//        return esAuctionRepository.findAll();
//    }
//    
//  //test - 경매검색(단일필드 검색)
//    public SearchHits<EsAuction> searchByAuctionTitle(String search) {//EsAuction에서 search값을 받아 auctiontitle을 검색한다.
//        return elasticsearchRestTemplate.search(
//            new NativeSearchQueryBuilder()
//                .withQuery(QueryBuilders.matchQuery("auctiontitle", search))
//                .build(),
//            EsAuction.class
//        );
//    }
}