package com.np.wearound.auctionService;

import java.io.IOException;

import javax.servlet.ServletException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.np.wearound.auctionDao.AuctionDao;
import com.np.wearound.auctionDto.AuctionAddDTO;
import com.np.wearound.auctionEntity.AuctionEntity;
import com.np.wearound.controller.LoginController;

@Service
public class AuctionServiceImpl implements AuctionService {

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private AuctionDao dao;
	
	@Override
	public void AuctionAdd(AuctionAddDTO dto) 
			throws ServletException, IOException {
		logger.info("<<< Serivce AuctionAdd Start! >>>");
	    
	    AuctionEntity ent = new AuctionEntity();
	    
	    ent.setUserno(dto.getUserno());
	    ent.setAuctiontitle(dto.getAuctiontitle());
	    ent.setImage(dto.getImage());
	    ent.setAuctioncontent(dto.getAuctioncontent());
	    ent.setBuynow(dto.getBuynow());
	    ent.setStartprice(dto.getStartprice());
	    ent.setMinbid(dto.getMinBid());
		
	    dao.AuctionAdd(ent);
	}

}
