package com.np.wearound.auctionDao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.np.wearound.auctionEntity.AuctionBidderEntity;

public interface AuctionBiderRepository extends JpaRepository<AuctionBidderEntity, Integer> {

}