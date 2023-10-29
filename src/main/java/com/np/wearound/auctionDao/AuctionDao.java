package com.np.wearound.auctionDao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.np.wearound.auctionDto.AuctionBiderDTO;
import com.np.wearound.auctionDto.AuctionBidingDTO;
import com.np.wearound.auctionDto.AuctionHostDTO;
import com.np.wearound.auctionEntity.AuctionBidderEntity;
import com.np.wearound.auctionEntity.AuctionBidingEntity;
import com.np.wearound.auctionEntity.AuctionEntity;

@Mapper
public interface AuctionDao {

	public int AuctionAdd(AuctionEntity ent);
	
	public int AuctionEdit(AuctionEntity ent);
	
	public List<AuctionHostDTO> AuctionHost(int userno);
	
	public List<AuctionBidingDTO> AuctionBiding(String name);
	
	public List<AuctionBiderDTO> AuctionBider(String name);
	
	public int AuctionStart(AuctionBidingEntity ent);
	
	public int AuctionChamUpdate(AuctionBidingDTO dto);
	
	public int AuctionPriceUpdate(AuctionEntity ent);
	
	public int AuctionBidfind(Map<String, Object> map);
	
	public void AuctionBiderAdd(AuctionBidderEntity ent);
	
	public void AuctionSetEndTime(AuctionEntity ent);
}
