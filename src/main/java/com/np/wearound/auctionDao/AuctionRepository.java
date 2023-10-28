package com.np.wearound.auctionDao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.np.wearound.auctionEntity.AuctionEntity;

public interface AuctionRepository extends JpaRepository<AuctionEntity, Integer> {

	List<AuctionEntity> findByStatus(int status);
	
	AuctionEntity findByAuctionno(int auctionno);
}
