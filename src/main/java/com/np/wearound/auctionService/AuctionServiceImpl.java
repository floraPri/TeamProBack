package com.np.wearound.auctionService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.ServletException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.np.wearound.auctionDao.AuctionBiderRepository;
import com.np.wearound.auctionDao.AuctionDao;
import com.np.wearound.auctionDao.AuctionRepository;
import com.np.wearound.auctionDto.AuctionAddDTO;
import com.np.wearound.auctionDto.AuctionBiderDTO;
import com.np.wearound.auctionDto.AuctionBidingDTO;
import com.np.wearound.auctionDto.AuctionDTO;
import com.np.wearound.auctionDto.AuctionDetailDTO;
import com.np.wearound.auctionDto.AuctionHostDTO;
import com.np.wearound.auctionDto.AuctionListDTO;
import com.np.wearound.auctionEntity.AuctionBidderEntity;
import com.np.wearound.auctionEntity.AuctionBidingEntity;
import com.np.wearound.auctionEntity.AuctionEntity;

@Service
public class AuctionServiceImpl implements AuctionService {

	private static final Logger logger = LoggerFactory.getLogger(AuctionServiceImpl.class);
	
	@Autowired
	private AuctionDao dao;
	
	@Autowired
	private AuctionRepository Repo;
	
	@Autowired
	private AuctionBiderRepository BiRepo;
	
	// 경매 추가
	@Override
	public void AuctionAdd(AuctionAddDTO dto) 
			throws ServletException, IOException {
		logger.info("<<< Serivce AuctionAdd Start! >>>");
	    
	    AuctionEntity ent = new AuctionEntity();
	    System.out.println(dto.getUserno());
	    ent.setUserno(dto.getUserno());
	    ent.setAuctiontitle(dto.getAuctiontitle());
	    ent.setImage(dto.getImage());
	    ent.setAuctioncontent(dto.getAuctioncontent());
	    ent.setBuynow(dto.getBuynow());
	    ent.setStartprice(dto.getStartprice());
	    ent.setMinbid(dto.getMinBid());
		
	    dao.AuctionAdd(ent);
	}
	
	// 수정 위한 상세페이지
	@Override
	public AuctionDTO AuctionDetail(int auctionno)
			throws ServletException, IOException {
		logger.info("<<< Serivce AuctionEdit Start! >>>");
		
		AuctionDTO dto = new AuctionDTO(); 
		Optional<AuctionEntity> entOp = Repo.findById(auctionno);
		AuctionEntity ent = entOp.get();
		
		dto.setAuctionno(ent.getAuctionno());
		dto.setUserno(ent.getUserno());
		dto.setAuctiontitle(ent.getAuctiontitle());
		dto.setImage(ent.getAuctioncontent());
		dto.setAuctioncontent(ent.getAuctioncontent());
		dto.setBuynow(ent.getBuynow());
		dto.setStartprice(ent.getStartprice());
		dto.setMinbid(ent.getMinbid());
		
		return dto;
	}
	
	// 경매 수정
	@Override
	public void AuctionEdit(AuctionAddDTO dto) 
			throws ServletException, IOException {
		logger.info("<<< Serivce AuctionEdit Start! >>>");
		
		AuctionEntity ent = new AuctionEntity();
	
	    String test = dto.getAuctiontitle();
	    ent.setAuctiontitle(dto.getAuctiontitle());
	    ent.setImage(dto.getImage());
	    ent.setAuctioncontent(dto.getAuctioncontent());
	    ent.setBuynow(dto.getBuynow());
	    ent.setStartprice(dto.getStartprice());
	    ent.setMinbid(dto.getMinBid());
	    ent.setAuctionno(dto.getAuctionno());
	    
	    int updateCnet = dao.AuctionEdit(ent);
	    System.out.println("업데이트 확인 "+updateCnet);
	}
	
	// 경매 리스트
	@Override
	public List<AuctionListDTO> AuctionList() 
			throws ServletException, IOException {
		logger.info("<<< Serivce AuctionList Start! >>>");
        List<AuctionEntity> listEnt = Repo.findByStatus(1);
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
		return list;
	}
	
	
	// 경매 HOST
	@Override
	public List<AuctionHostDTO> AuctionHost(int userno) 
			throws ServletException, IOException {
		logger.info("<<< Serivce AuctionHost Start! >>>");
		
		return dao.AuctionHost(userno);
	}

	// 입찰중
	@Override
	public List<AuctionBidingDTO> AuctionBiding(String name) 
			throws ServletException, IOException {
		logger.info("<<< Serivce AuctionBiding Start! >>>");
		
		return dao.AuctionBiding(name);
	}

	// 낙찰완료
	@Override
	public List<AuctionBiderDTO> AuctionBider(String name) 
			throws ServletException, IOException {
		logger.info("<<< Serivce AuctionBider Start! >>>");
		List<AuctionBiderDTO> list = dao.AuctionBider(name);
		System.out.println("리스트 : " + list);
		return dao.AuctionBider(name);
	}

	// 경매 상세 - (진행페이지)
	@Override
	public AuctionDetailDTO Auction (int auctionno)
			throws ServletException, IOException {
		logger.info("<<< Serivce auction Start! >>>");
		
		AuctionEntity ent = Repo.findByAuctionno(auctionno);
		AuctionDetailDTO dto = new AuctionDetailDTO();
		
        dto.setAuctionno(ent.getAuctionno());
        dto.setUserno(ent.getUserno());
        dto.setAuctiontitle(ent.getAuctiontitle());
        dto.setImage(ent.getImage());
        dto.setAuctioncontent(ent.getAuctioncontent());
        dto.setBuynow(ent.getBuynow());
        dto.setStartprice(ent.getStartprice());
        dto.setLastprice(ent.getLastprice());
        dto.setMinbid(ent.getMinbid());
        dto.setAustarttime(ent.getAustarttime());
        dto.setLasttime(ent.getLasttime());
        dto.setCham(ent.getCham());
        dto.setAddress(ent.getAddress());
        dto.setName(ent.getName());
        dto.setHostname(ent.getHostname());
        
		return dto;
	}
	
	// 경매 상세 - 입찰 시작
	@Override
	public int AuctionStart (AuctionBidingDTO dto)
			throws ServletException, IOException {
		logger.info("<<< Serivce AuctionStart Start! >>>");
		
		AuctionBidingEntity ent = new AuctionBidingEntity();
		
		ent.setAuctionno(dto.getAuctionno());
		ent.setName(dto.getName());
		
		int insertCnt = 0;
		
		insertCnt = dao.AuctionStart(ent);
		
		return insertCnt;
	}
	
	// 참여자 갱신
	@Override
	public int AuctionChamUpdate (AuctionBidingDTO dto)
			throws ServletException, IOException {
		logger.info("<<< Serivce AuctionChamUpdate Start! >>>");
		AuctionEntity ent = new AuctionEntity();
		ent.setAuctionno(dto.getAuctionno());
		
		int updateCnt = dao.AuctionChamUpdate(dto);
		return updateCnt;
	}
	
	//경매  상세 - 최종가 업데이트
	@Override
	public int AuctionPriceUpdate (AuctionBidingDTO dto)
			throws ServletException, IOException {
		logger.info("<<< Serivce AuctionStart Start! >>>");
		
		AuctionEntity ent = new AuctionEntity();
		
		ent.setAuctionno(dto.getAuctionno());
		ent.setLastprice(dto.getLastprice());
		ent.setName(dto.getName());
		
		int updateCnt = dao.AuctionPriceUpdate(ent);
		return updateCnt;
	}
	
	//경매중 중복 찾기
	@Override
	public int AuctionBidfind (Map<String, Object> map)
			throws ServletException, IOException {
		logger.info("<<< Serivce AuctionBidfind Start! >>>");
		
		int selectCnt = 0;
		
		selectCnt = dao.AuctionBidfind(map);
		
		return selectCnt;
	}
	
	// 낙찰자 업데이트
	@Override
	public void AuctionBiderAdd (AuctionBiderDTO dto)
			throws ServletException, IOException {
		logger.info("<<< Serivce AuctionBiderAdd Start! >>>");
		AuctionBidderEntity ent = new AuctionBidderEntity();
		int a = dto.getAuctionno();
		System.out.println("번호 테스트 : "+ a);
		ent.setAuctionbidderno(dto.getAuctionbidderno());
		ent.setAuctionno(dto.getAuctionno());
		ent.setBidprice(dto.getBidprice());
		ent.setName(dto.getName());
		
		dao.AuctionBiderAdd(ent);
	}
	
	// 종료시간 설정
	@Override
	public void AuctionSetEndTime (AuctionDTO dto)
			throws ServletException, IOException {
		logger.info("<<< Serivce AuctionSetEndTime Start! >>>");
		AuctionEntity ent = new AuctionEntity();
		
		ent.setAuctionno(dto.getAuctionno());
		ent.setName(dto.getName());
		
		dao.AuctionSetEndTime(ent);
		
	}
	
	// 경매 1대1 채팅 정보
	@Override
	public AuctionDTO hostAndGuestChatInfo (int auctionno)
			throws ServletException, IOException {
		logger.info("<<< Serivce hostAndGuestChatInfo Start! >>>");
		AuctionEntity ent = Repo.findByAuctionno(auctionno);
		AuctionDTO dto = new AuctionDTO();
		
		dto.setAuctionno(auctionno);
		dto.setName(ent.getName());
		dto.setLastprice(ent.getLastprice());
		dto.setAuctiontitle(ent.getAuctiontitle());
		
		return dto;
	}
	
	// 경매 상세 - 낙찰자 중복 체크
	@Override
	public int AuctionbiderCheck (Map<String, Object> map)
			throws ServletException, IOException {
		logger.info("<<< Serivce AuctionbiderCheck Start! >>>");
		
		int selectCnt = 0;
		
		selectCnt = dao.AuctionbiderCheck(map);
				
		return selectCnt;
	}
}