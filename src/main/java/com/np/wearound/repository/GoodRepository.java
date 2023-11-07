package com.np.wearound.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.np.wearound.entities.Good;


public interface GoodRepository extends JpaRepository<Good,Integer> {
	
	//좋아요 체크여부
	//public Integer getCountByUsernoAndFeedcode(int userno, int feedcode);
	// userNo와 goodCode를 사용한 삭제 쿼리
    @Modifying
    @Transactional
    @Query("DELETE FROM Good g WHERE g.userno = ?1 AND g.feedcode = ?2")
    void deleteByUsernoAndFeedcode(int userno, int feedcode);
}
