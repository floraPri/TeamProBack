package com.np.wearound.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.np.wearound.document.EsUser;

public interface EsUserRepository extends ElasticsearchRepository<EsUser, Integer>{
}
