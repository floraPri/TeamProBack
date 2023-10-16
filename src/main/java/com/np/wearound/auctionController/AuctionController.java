package com.np.wearound.auctionController;

import java.util.List;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.np.wearound.auctionDto.AuctionAddDTO;
import com.np.wearound.auctionEntity.AuctionEntity;
import com.np.wearound.auctionService.AuctionService;
import com.np.wearound.controller.LoginController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(value="/auction")
public class AuctionController {

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private AuctionService service;
	
	// 집
	//private final String uploadDirectory = "C:\\Users\\FloraPrincess\\Desktop\\DeV\\TeamProImage";
	
	// 학원
	private final String uploadDirectory = "C:\\Users\\ICT02-14\\Desktop\\Dev\\TeamProImage";
	
	// 경매 추가
	@PostMapping(value="/auctionAdd", consumes="multipart/form-data")
	public String auctionAdd(
		    @RequestParam("auctiontitle") String auctiontitle, 
		    @RequestParam("auctioncontent") String auctioncontent,
			@RequestParam("image") MultipartFile image,
			@RequestParam("buynow") int buynow,
			@RequestParam("startprice") int startprice,
			@RequestParam("minbid") int minbid
//		    ,AuctionAddDTO dto <- 에러의 온상 기억해두자
			)
	    throws ServletException, IOException {
		logger.info("<<< Controller AuctionAdd Start! >>>");
		
		AuctionAddDTO dto = new AuctionAddDTO();

		if (!image.isEmpty()) {
			String fileName = image.getOriginalFilename();
			logger.info("fileName fullPath={}", fileName);
			// 저장할 파일 경로
			
			File uploadedFile = new File(fileName);

			String fullPath = uploadDirectory + File.separator + uploadedFile;
			image.transferTo(new File(fullPath));
			dto.setImage(fullPath);
			}
		
		dto.setUserno(1); // 일단 하드 코딩
		dto.setAuctiontitle(auctiontitle);
		dto.setAuctioncontent(auctioncontent);
		dto.setBuynow(buynow);
		dto.setStartprice(startprice);
		dto.setMinBid(minbid);
		
		service.AuctionAdd(dto);
		
		logger.info(">>> Controller AuctionAdd End! <<<");
		
		return "auctionAdd";
	}
	
	@GetMapping(value="/auction")
	public List<AuctionEntity> auctionList() 
			throws ServletException, IOException {
		
		List<AuctionEntity> list = service.AuctionList();
		return list;
	}
	
}
