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

	// 경매 추가
	public int AuctionAdd(AuctionEntity ent);
	
	// 경매 수정
	public int AuctionEdit(AuctionEntity ent);
	
	// 경매 HOST
	public List<AuctionHostDTO> AuctionHost(int userno);
	
	// 경매 GUEST
	public List<AuctionBidingDTO> AuctionBiding(String name);
	
	// 경매 낙찰자
	public List<AuctionBiderDTO> AuctionBider(String name);
	
	// 경매 상세 - 입찰
	public int AuctionStart(AuctionBidingEntity ent);
	
	// 경매 상세 - 참여자 갱신
	public int AuctionChamUpdate(AuctionBidingDTO dto);
	
	// 경매 상세 - 고가 갱신
	public int AuctionPriceUpdate(AuctionEntity ent);
	
	// 경매 상세 - [경매중] 중복 찾기
	public int AuctionBidfind(Map<String, Object> map);
	
	// 경매 상세 - 낙찰차 추가
	public void AuctionBiderAdd(AuctionBidderEntity ent);
	
	// 경매 상세 - 종료시간 설정
	public void AuctionSetEndTime(AuctionEntity ent);
	
	// 경매 상세 - [낙찰자] 중복 찾기
	public int AuctionbiderCheck(Map<String, Object> map);
}
