package com.np.wearound.auctionDao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.np.wearound.auctionDto.AuctionBiderDTO;
import com.np.wearound.auctionDto.AuctionBidingDTO;
import com.np.wearound.auctionDto.AuctionHostDTO;
import com.np.wearound.auctionEntity.AuctionEntity;

@Mapper
public interface AuctionDao {

	public int AuctionAdd(AuctionEntity ent);
	
	public int AuctionEdit(AuctionEntity ent);
	
	public List<AuctionHostDTO> AuctionHost(int userno);
	
	public List<AuctionBidingDTO> AuctionBiding(String name);
	
	public List<AuctionBiderDTO> AuctionBider(int userno);
}
