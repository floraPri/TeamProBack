package com.np.wearound.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.np.wearound.dto.FundingDTO;
import com.np.wearound.entities.Funding;
import com.np.wearound.service.FundingServiceImpl;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor   //생성자에 멤버변수를 주입
@RestController
@RequestMapping(value="/funding")
public class FundingController {
   
   private static final Logger logger = LoggerFactory.getLogger(FundingController.class);
   
   @Autowired
   private FundingServiceImpl service;
   
   private final String uploadDirectory = "\\TeamProImage";
   
   // 전체 리스트 (main)
   @GetMapping("/funding")
   public List<Funding> fundinglist(){
	   logger.info("funding - fundinglist");
//	   List<Funding> aa = service.fundinglist();
//	   System.out.println(" 대답" + aa);
	   return service.fundinglist();
   }
   
   
   @GetMapping("/fundingDetail")
   public Optional<Funding> fundingDetail(@RequestParam("fundingcode") int fundingcode) {
	   logger.info("funding - detail");
	   
	   
	   Funding dto = new Funding();
	   dto.getFundingcode();
	   
	   return service.FundingDetail(fundingcode);
   }

   // fundingadd
   @PostMapping(value="/fundingAdd"
//		   , consumes="multipart/form-data"
		   )
   public String fundingAdd(
		   @RequestParam("category") String category,
		   @RequestParam("title") String title,
		   @RequestParam("image") String image,
		   @RequestParam("content") String content,
		   @RequestParam("startdate") Date startdate,
		   @RequestParam("enddate") Date enddate,
		   @RequestParam("goalamount") int goalamount,
		   @RequestParam("userno") int userno
		   ) throws ServletException, IOException {
	   logger.info("funding - fundingAdd");
	   
	   Funding dto = new Funding();
	   dto.setCategory(category);
	   dto.setTitle(title);
	   dto.setImage(image);
	   dto.setContent(content);
	   dto.setStartdate(startdate);
	   dto.setEnddate(enddate);
	   dto.setGoalamount(goalamount);
	   dto.setUserno(userno);
	   
	   System.out.println("dto" + dto);
//		if (!image.isEmpty()) {
//			String fileName = image.getOriginalFilename();
//			logger.info("fileName fullPath={}", fileName);
//			// 저장할 파일 경로
//			
//			File uploadedFile = new File(fileName);
//
//			String fullPath = uploadDirectory + File.separator + uploadedFile;
//			image.transferTo(new File(fullPath));
//			dto.setImage(fullPath);
//			}
		
		System.out.println("add "+dto);
		
	   service.FundingAdd(dto);
	   
	   return "fundingAdd";
   }
//   // fundingadd
//   @PostMapping(value="/fundingAdd", consumes="multipart/form-data")
//   public String fundingAdd(
//		   @RequestParam("fundingcode") int fundingcode,
//		   @RequestParam("title") String title,
//		   @RequestParam("image") MultipartFile image,
//		   @RequestParam("content") String content,
//		   @RequestParam("startdate") Date startdate,
//		   @RequestParam("enddate") Date enddate,
//		   @RequestParam("goalamount") int goalamount
//		   ) throws ServletException, IOException {
//	   logger.info("funding - fundingAdd");
//	   
//	   FundingDTO dto = new FundingDTO();
//	   
//	   if (!image.isEmpty()) {
//		   String fileName = image.getOriginalFilename();
//		   logger.info("fileName fullPath={}", fileName);
//		   // 저장할 파일 경로
//		   
//		   File uploadedFile = new File(fileName);
//		   
//		   String fullPath = uploadDirectory + File.separator + uploadedFile;
//		   image.transferTo(new File(fullPath));
//		   dto.setImage(fullPath);
//	   }
//	   System.out.println(dto);
//	   service.FundingAdd(dto);
//	   
//	   return "fundingAdd";
//   }
   
//   @GetMapping("/fundingEdit")
//   public FundingDTO fundingEdit(@RequestParam("fundingcode") int fundingcode)
//   		throws ServletException, IOException{
//	   
//	   
//	   return service.;

}