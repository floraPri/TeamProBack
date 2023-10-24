package com.np.wearound.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.np.wearound.dto.FundingDTO;
import com.np.wearound.entities.Funding;
import com.np.wearound.entities.FundingRewards;
import com.np.wearound.service.FundingServiceImpl;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor   //생성자에 멤버변수를 주입
@RestController
@RequestMapping(value="/funding")
public class FundingController {
   
   private static final Logger logger = LoggerFactory.getLogger(FundingController.class);
   
//	집
//	private final String uploadDirectory = "C:\\Users\\FloraPrincess\\Desktop\\DeV\\TeamProImage";
//	
//	학원
//	private final String uploadDirectory = "C:\\Users\\ICT02-14\\Desktop\\Dev01\\TeamProImage";
	
//   private final String uploadDirectory = "C:\\Dev01\\TeamProImage";
	
   @Autowired
   private FundingServiceImpl service;
   
   
   // 전체 리스트 (main)
   @GetMapping("/funding")
   public List<Funding> fundinglist(){
	   logger.info("funding - fundinglist");

	   return service.fundinglist();
   }
   
   
   @GetMapping("/fundingDetail")
   public Optional<Funding> fundingDetail(@RequestParam("fundingcode") int fundingcode) {
	   logger.info("funding - detail");
	   
	   
	   return service.FundingDetail(fundingcode);
   }

   @GetMapping("/rewardsList")
   public List<FundingRewards> rewardslist(@RequestParam("fundingcode") int fundingcode) {
	   logger.info("funding - rewardslist");
	   
	   
	   return service.Rewardslist(fundingcode);
   }   

   // fundingadd
   @PostMapping(value="/fundingAdd", consumes="multipart/form-data")
   public ResponseEntity<Funding> fundingAdd(
		   @RequestParam("category") String category,
		   @RequestParam("title") String title,
		   @RequestParam("subtitle") String subtitle,
		   @RequestParam("image") MultipartFile image,
		   @RequestParam("subcontent") String subcontent,
		   @RequestParam("content") String content,
		   @RequestParam("startdate") Date startdate,
		   @RequestParam("enddate") Date enddate,
		   @RequestParam("goalamount") int goalamount,
		   @RequestParam("userno") int userno,
		   HttpServletRequest req
		   ) throws ServletException, IOException {
	   logger.info("funding - fundingAdd");
	   
	   Funding ent = new Funding();
	   ent.setCategory(category);
	   ent.setTitle(title);
	   ent.setSubtitle(subtitle);
//	   ent.setImage(image);
	   ent.setContent(content);
	   ent.setSubcontent(subcontent);
	   ent.setStartdate(startdate);
	   ent.setEnddate(enddate);
	   ent.setGoalamount(goalamount);
	   ent.setUserno(userno);
	   
	   System.out.println("ett" + ent);
	   
	   String uploadDirectory = req.getSession().getServletContext().getRealPath("/images");
		//String uploadDirectory = "src/main/resources/images";
		if (!image.isEmpty()) {
			String fileName = image.getOriginalFilename();
			logger.info("fileName fullPath={}", fileName);
			// 저장할 파일 경로
			
			File uploadedFile = new File(fileName);

			String fullPath = uploadDirectory + File.separator + uploadedFile;
			image.transferTo(new File(fullPath));
			String filePath = "http://localhost:8081/images/"+uploadedFile+"/";
			
			ent.setImage(filePath);
			}
		
		System.out.println("add "+ ent);
		
		Funding funding =  service.FundingAdd(ent);
	   
	   return ResponseEntity.ok(funding);
   }

   @PostMapping("/rewardAdd")
   public String rewardAdd(@RequestBody
		   FundingRewards ent
		   )throws ServletException, IOException{
	   		logger.info("funding - rewardAdd");
	   		

	   		
	   		System.out.println("entity" + ent);
	   		
	   		service.RewardAdd(ent);

	   return "rewardAdd";
   }
   
   
//   @GetMapping("/fundingEdit")
//   public FundingDTO fundingEdit(@RequestParam("fundingcode") int fundingcode)
//   		throws ServletException, IOException{
//	   
//	   
//	   return service.;

}