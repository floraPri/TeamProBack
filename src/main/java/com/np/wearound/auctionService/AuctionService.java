package com.np.wearound.auctionService;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;

import com.np.wearound.auctionDto.AuctionAddDTO;
import com.np.wearound.auctionDto.AuctionBiderDTO;
import com.np.wearound.auctionDto.AuctionBidingDTO;
import com.np.wearound.auctionDto.AuctionDTO;
import com.np.wearound.auctionDto.AuctionHostDTO;
import com.np.wearound.auctionDto.AuctionListDTO;
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
	
	public List<AuctionBiderDTO> AuctionBider(int userno)
			throws ServletException, IOException;
}
