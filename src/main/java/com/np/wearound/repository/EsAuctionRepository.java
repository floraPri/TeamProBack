package com.np.wearound.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.np.wearound.document.EsAuction;

public interface EsAuctionRepository extends ElasticsearchRepository<EsAuction,Integer> {

}
