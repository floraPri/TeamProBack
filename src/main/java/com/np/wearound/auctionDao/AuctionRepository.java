package com.np.wearound.auctionDao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.np.wearound.auctionEntity.AuctionEntity;

public interface AuctionRepository extends JpaRepository<AuctionEntity, Integer> {

}
