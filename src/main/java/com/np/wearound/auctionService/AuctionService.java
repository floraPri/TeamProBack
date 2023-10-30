package com.np.wearound.auctionService;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;

import com.np.wearound.auctionDto.AuctionAddDTO;
import com.np.wearound.auctionDto.AuctionBiderDTO;
import com.np.wearound.auctionDto.AuctionBidingDTO;
import com.np.wearound.auctionDto.AuctionDTO;
import com.np.wearound.auctionDto.AuctionDetailDTO;
import com.np.wearound.auctionDto.AuctionHostDTO;
import com.np.wearound.auctionDto.AuctionListDTO;
import com.np.wearound.auctionEntity.AuctionBidingEntity;
import com.np.wearound.auctionEntity.AuctionEntity;

public interface AuctionService {

	// 경매 추가
	public void AuctionAdd(AuctionAddDTO dto)
			throws ServletException, IOException;
	
	// 수정 위한 상세페이지
	public void AuctionEdit(AuctionAddDTO dto)
			throws ServletException, IOException;	
	
	// 경매 수정
	public AuctionDTO AuctionDetail(int auctionno)
			throws ServletException, IOException;
	
	// 경매 리스트
	public List<AuctionListDTO> AuctionList() 
			throws ServletException, IOException;
	
	// 경매 HOST
	public List<AuctionHostDTO> AuctionHost(int userno)
			throws ServletException, IOException;
	
	// 입찰중
	public List<AuctionBidingDTO> AuctionBiding(String name)
			throws ServletException, IOException;
	
	// 낙찰완료
	public List<AuctionBiderDTO> AuctionBider(String name)
			throws ServletException, IOException;
	
	// 경매 상세 - 진행페이지
	public AuctionDetailDTO Auction (int auctionno)
			throws ServletException, IOException;
	
	// 경매 상세 - 입찰 시작
	public int AuctionStart (AuctionBidingDTO dto)
			throws ServletException, IOException;
	
	// 경매 상세 - 참여자 갱신
	public int AuctionChamUpdate (AuctionBidingDTO dto)
			throws ServletException, IOException;
	
	//경매  상세 - 최종가 업데이트
	public int AuctionPriceUpdate (AuctionBidingDTO dto)
			throws ServletException, IOException;
	
	//경매중 중복 찾기
	public int AuctionBidfind (Map<String, Object> map)
			throws ServletException, IOException;
	
	// 낙찰자 업데이트
	public void AuctionBiderAdd (AuctionBiderDTO dto)
			throws ServletException, IOException;
	
	// 종료시간 설정
	public void AuctionSetEndTime (AuctionDTO dto)
			throws ServletException, IOException;
	
	// 경매 1대1 채팅 정보
	public AuctionDTO hostAndGuestChatInfo (int auctionno)
			throws ServletException, IOException;
	
	// 경매 상세 - 낙찰자 중복 체크
	public int AuctionbiderCheck (Map<String, Object> map)
			throws ServletException, IOException;
	
	
}