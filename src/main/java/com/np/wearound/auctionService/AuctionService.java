package com.np.wearound.auctionService;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;

import com.np.wearound.auctionDto.AuctionAddDTO;
import com.np.wearound.auctionDto.AuctionListDTO;
import com.np.wearound.auctionEntity.AuctionEntity;

public interface AuctionService {

	public void AuctionAdd(AuctionAddDTO dto)
			throws ServletException, IOException;
	
	public List<AuctionEntity> AuctionList() 
			throws ServletException, IOException;
}
