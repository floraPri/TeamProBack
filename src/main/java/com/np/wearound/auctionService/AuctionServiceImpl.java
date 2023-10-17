package com.np.wearound.auctionService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.np.wearound.auctionDao.AuctionDao;
import com.np.wearound.auctionDao.AuctionRepository;
import com.np.wearound.auctionDto.AuctionAddDTO;
import com.np.wearound.auctionDto.AuctionBiderDTO;
import com.np.wearound.auctionDto.AuctionBidingDTO;
import com.np.wearound.auctionDto.AuctionHostDTO;
import com.np.wearound.auctionDto.AuctionListDTO;
import com.np.wearound.auctionEntity.AuctionEntity;
import com.np.wearound.controller.LoginController;

@Service
public class AuctionServiceImpl implements AuctionService {

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private AuctionDao dao;
	
	@Autowired
	private AuctionRepository Repo;
	
	// 경매 추가
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
	
	// 경매 수정
	@Override
	public void AuctionEdit(AuctionAddDTO dto) 
			throws ServletException, IOException {
		logger.info("<<< Serivce AuctionEdit Start! >>>");
		
		AuctionEntity ent = new AuctionEntity();
	
	    ent.setUserno(dto.getUserno());
	    ent.setAuctiontitle(dto.getAuctiontitle());
	    ent.setImage(dto.getImage());
	    ent.setAuctioncontent(dto.getAuctioncontent());
	    ent.setBuynow(dto.getBuynow());
	    ent.setStartprice(dto.getStartprice());
	    ent.setMinbid(dto.getMinBid());
	    
	    dao.AuctionEdit(ent);
	}
	
	@Override
	public List<AuctionListDTO> AuctionList() 
			throws ServletException, IOException {
		logger.info("<<< Serivce AuctionList Start! >>>");
        List<AuctionEntity> listEnt = Repo.findAll();
        List<AuctionListDTO> list = new ArrayList<>();

		for (AuctionEntity entity : listEnt) {
			AuctionListDTO dto = new AuctionListDTO();
            dto.setAuctionno(entity.getAuctionno());
            dto.setAuctiontitle(entity.getAuctiontitle());
            dto.setImage(entity.getImage());
            dto.setStartprice(entity.getStartprice());
            dto.setLasttime(entity.getLasttime());
            dto.setCham(entity.getCham());
            list.add(dto);
		}
//		List<AuctionListDTO> list = Repo.findAll();
		return list;
	}
	
	// 경매 수정

	@Override
	public List<AuctionHostDTO> AuctionHost(int userno) 
			throws ServletException, IOException {
		logger.info("<<< Serivce AuctionHost Start! >>>");
		
		return dao.AuctionHost(userno);
	}

	@Override
	public List<AuctionBidingDTO> AuctionBiding(String name) 
			throws ServletException, IOException {
		logger.info("<<< Serivce AuctionBiding Start! >>>");
		
		return dao.AuctionBiding(name);
	}

	@Override
	public List<AuctionBiderDTO> AuctionBider(int userno) 
			throws ServletException, IOException {
		logger.info("<<< Serivce AuctionBider Start! >>>");
		
		
		return dao.AuctionBider(userno);
	}

}
