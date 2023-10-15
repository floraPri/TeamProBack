package com.np.wearound.auctionService;

import java.io.IOException;

import javax.servlet.ServletException;

import com.np.wearound.auctionDto.AuctionAddDTO;

public interface AuctionService {

	public void AuctionAdd(AuctionAddDTO dto)
			throws ServletException, IOException;
}
