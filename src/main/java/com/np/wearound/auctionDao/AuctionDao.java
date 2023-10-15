package com.np.wearound.auctionDao;

import org.apache.ibatis.annotations.Mapper;

import com.np.wearound.auctionEntity.AuctionEntity;

@Mapper
public interface AuctionDao {

	public int AuctionAdd(AuctionEntity ent);
}
