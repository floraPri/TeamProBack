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
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.np.wearound.dto.FundingDTO;
import com.np.wearound.entities.Funding;
import com.np.wearound.entities.FundingRewards;
import com.np.wearound.entities.FundingView;
import com.np.wearound.entities.PledgesView;
import com.np.wearound.entities.FundingPledges;
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
   
   
//   // 전체 리스트 (main)
//   @GetMapping("/funding")
//   public String fundinglist(@RequestParam(name = "category", required = false) String category, Model model) {
//	    logger.info("funding - fundinglist");
//
//	    if (category != null) {
//	        List<Funding> selectedFundingList = service.SelectFundingList(category);
//	        model.addAttribute("fundingList", selectedFundingList);
//	    } else {
//	        List<Funding> allFundingList = service.Fundinglist();
//	        model.addAttribute("fundingList", allFundingList);
//	    }
//
//	    return "funding";
//   	}
   
   // 전체 리스트 (main)
   @GetMapping("/funding")
   public List<Funding> fundinglist(){
	   logger.info("funding - fundinglist");
			   
	   
	   return service.Fundinglist();
   }
   
   // 펀딩 상세 page
   @GetMapping("/fundingDetail")
   public Optional<Funding> fundingDetail(@RequestParam("fundingcode") int fundingcode) {
	   logger.info("funding - detail");
	   
	   
	   return service.FundingDetail(fundingcode);
   }
   // 상세 page 속 rewards
   @GetMapping("/rewardsList")
   public List<FundingRewards> rewardslist(@RequestParam("fundingcode") int fundingcode) {
	   logger.info("funding - rewardslist");
	   
	   
	   return service.Rewardslist(fundingcode);
   }   

   
   // 후원하기 상세
   @GetMapping("/fundingPledge")
   public Optional<FundingView> fundingPledge(@RequestParam("rewardscode") int rewardscode, @RequestParam("fundingcode") int fundingcode){
	   logger.info(" controller - fundingPledge ");
	   
	   
	   return service.FundingInfo(fundingcode, rewardscode);
   }
   
   // 후원하기 v
   @PostMapping("/contributeFunding")
   public ResponseEntity<Object> contributeFunding(@RequestBody Map<String, String> map)
		   throws ServletException, IOException{
  		logger.info(" controller - ContributeFunding ");
  		FundingPledges ent = new FundingPledges();
  		int fundingcode = Integer.parseInt(map.get("fundingcode"));
  		
  		ent.setFundingcode(fundingcode);
  		ent.setRewardscode(Integer.parseInt(map.get("rewardscode")));
  		ent.setUserno(Integer.parseInt(map.get("userno")));
  		ent.setQuantity(Integer.parseInt(map.get("quantity")));
  		ent.setAddress(map.get("address"));
  		
  		int nowamount = Integer.parseInt(map.get("nowamount"));
  		System.out.println(nowamount);
  		
  		System.out.println(ent);
  		
  		FundingPledges plg = service.ContributeFunding(ent);
  		service.UpdateNowAmount(fundingcode, nowamount);
  		return ResponseEntity.ok().build();
   }
   
   @GetMapping("/myOrganizeList")
   public List<Funding> myOrganizeList(@RequestParam("userno") int userno){
	   logger.info(" controller - organizeList ");
	   
	   return service.MyOrganizeList(userno);
   }
   
   
   @GetMapping("/myPledges")
   public List<PledgesView> myPledges(@RequestParam("userno") int userno){
	   logger.info(" controller - myPledges ");
	   
	   return service.MyPledgedList(userno);
   }
   
   
 
   // fundingadd
   @PostMapping(value="/fundingAdd", consumes="multipart/form-data")
   public ResponseEntity<Funding> fundingAdd(
		   @RequestParam("category") String category,
		   @RequestParam("title") String title,
		   @RequestParam("image") MultipartFile image,
		   @RequestParam("precontent") String precontent,
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
	   ent.setContent(content);
	   ent.setPrecontent(precontent);
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
		
		Funding add =  service.FundingAdd(ent);
	   
	   return ResponseEntity.ok(add);
   }
   // edit상세
   @GetMapping("/fundingEdit")
   public Optional<Funding> fundingEditDetail(@RequestParam("fundingcode") int fundingcode) {
	   logger.info("controller - fundingEdit");
	   
	   return service.FundingDetail(fundingcode);
   }
   
   
   // update
   @PostMapping(value="/fundingEdit", consumes="multipart/form-data")
   public ResponseEntity<Funding> fundingEdit(
		   @RequestParam("fundingcode") int fundingcode,
		   @RequestParam("category") String category,
		   @RequestParam("title") String title,
		   @RequestParam("image") MultipartFile image,
		   @RequestParam("precontent") String precontent,
		   @RequestParam("content") String content,
		   @RequestParam("startdate") Date startdate,
		   @RequestParam("enddate") Date enddate,
		   @RequestParam("nowamount") int nowamount,
		   @RequestParam("goalamount") int goalamount,
		   @RequestParam("userno") int userno,
		   HttpServletRequest req
		   ) throws ServletException, IOException {
	   logger.info("funding - fundingEdit");
	   
	   Funding ent = new Funding();
	   ent.setFundingcode(fundingcode);
	   ent.setCategory(category);
	   ent.setTitle(title);
	   ent.setContent(content);
	   ent.setPrecontent(precontent);
	   ent.setStartdate(startdate);
	   ent.setEnddate(enddate);
	   ent.setNowAmount(nowamount);
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
	   
	   Funding edit =  service.FundingEdit(ent);
	   
	   return ResponseEntity.ok(edit);
   }

   @PostMapping("/rewardAdd")
   public String rewardAdd(@RequestBody FundingRewards ent)
		   throws ServletException, IOException{
   		logger.info("funding - rewardAdd");
	
		System.out.println("entity" + ent);
		service.RewardAdd(ent);

	   return "rewardAdd";
   }
   
   // edit상세
   @GetMapping("/rewardEdit")
   public Optional<FundingRewards> rewardEditDetail(@RequestParam("rewardscode") int rewardscode, @RequestParam("fundingcode") int fundingcode) {
	   logger.info("controller - rewardEditDetail");
	   
	   return service.RewardsDetail(rewardscode);
   }
   
   @PostMapping("/rewardEdit")
   public String rewardEdit(@RequestBody FundingRewards edit)
		   throws ServletException, IOException{
	   logger.info("funding - rewardEdit");
	   
	   System.out.println("entity" + edit);
	   service.RewardEdit(edit);
	   
	   return "rewardEdit";
   }

}