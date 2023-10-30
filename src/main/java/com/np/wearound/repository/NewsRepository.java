package com.np.wearound.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.np.wearound.entities.News;

@Repository
public interface NewsRepository extends JpaRepository<News, Integer>{

	Page<News> findAllByOrderByNewsnoDesc(Pageable pageable);

}
