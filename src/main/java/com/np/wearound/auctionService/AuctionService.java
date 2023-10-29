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

	public void AuctionAdd(AuctionAddDTO dto)
			throws ServletException, IOException;
	
	public void AuctionEdit(AuctionAddDTO dto)
			throws ServletException, IOException;	
	
	public AuctionDTO AuctionDetail(int auctionno)
			throws ServletException, IOException;
	
	public List<AuctionListDTO> AuctionList() 
			throws ServletException, IOException;
	
	public List<AuctionHostDTO> AuctionHost(int userno)
			throws ServletException, IOException;
	
	public List<AuctionBidingDTO> AuctionBiding(String name)
			throws ServletException, IOException;
	
	public List<AuctionBiderDTO> AuctionBider(String name)
			throws ServletException, IOException;
	
	public AuctionDetailDTO Auction (int auctionno)
			throws ServletException, IOException;
	
	public int AuctionStart (AuctionBidingDTO dto)
			throws ServletException, IOException;
	
	public int AuctionChamUpdate (AuctionBidingDTO dto)
			throws ServletException, IOException;
	
	public int AuctionPriceUpdate (AuctionBidingDTO dto)
			throws ServletException, IOException;
	
	public int AuctionBidfind (Map<String, Object> map)
			throws ServletException, IOException;
	
	public void AuctionBiderAdd (AuctionBiderDTO dto)
			throws ServletException, IOException;
	
	public void AuctionSetEndTime (AuctionDTO dto)
			throws ServletException, IOException;
	
	public AuctionDTO hostAndGuestChatInfo (int auctionno)
			throws ServletException, IOException;
}