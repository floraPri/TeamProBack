package com.np.wearound.auctionController;

import java.util.List;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.socket.config.annotation.EnableWebSocket;

import com.np.wearound.auctionDto.AuctionAddDTO;
import com.np.wearound.auctionDto.AuctionBiderDTO;
import com.np.wearound.auctionDto.AuctionBidingDTO;
import com.np.wearound.auctionDto.AuctionDTO;
import com.np.wearound.auctionDto.AuctionDetailDTO;
import com.np.wearound.auctionDto.AuctionHostDTO;
import com.np.wearound.auctionDto.AuctionListDTO;
import com.np.wearound.auctionEntity.AuctionEntity;
import com.np.wearound.auctionService.AuctionService;
import lombok.RequiredArgsConstructor;


@RestController
@RequiredArgsConstructor
@RequestMapping(value="/auction")
public class AuctionController {

	private static final Logger logger = LoggerFactory.getLogger(AuctionController.class);
	
	@Autowired
	private AuctionService service;
	

	private SimpMessagingTemplate messagingTemplate;
    
	// 경매 추가
	@PostMapping(value="/auctionAdd", consumes="multipart/form-data")
	public String auctionAdd(
			@RequestParam("userno") int userno,
		    @RequestParam("auctiontitle") String auctiontitle, 
		    @RequestParam("auctioncontent") String auctioncontent,
			@RequestParam("image") MultipartFile image,
			@RequestParam("buynow") int buynow,
			@RequestParam("startprice") int startprice,
			@RequestParam("minbid") int minbid,
			HttpServletRequest req
//		    ,AuctionAddDTO dto <- 에러의 온상 기억해두자
			)
	    throws ServletException, IOException {
		logger.info("<<< Controller AuctionAdd Start! >>>");
		
		AuctionAddDTO dto = new AuctionAddDTO();

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
			System.out.println(filePath);
			dto.setImage(filePath);
			
			}
		
		dto.setUserno(userno);
		dto.setAuctiontitle(auctiontitle);
		dto.setAuctioncontent(auctioncontent);
		dto.setBuynow(buynow);
		dto.setStartprice(startprice);
		dto.setMinBid(minbid);
		
		service.AuctionAdd(dto);
		
		logger.info(">>> Controller AuctionAdd End! <<<");
		
		return "auctionAdd";
	}
	
	// 수정 위한 상세페이지
	@GetMapping(value="/auctionEdit")
	public AuctionDTO auctionEdit(@RequestParam("auctionno")int auctionno)
			throws ServletException, IOException {
		logger.info(">>> Controller auctionDetail Start! <<<");
		return service.AuctionDetail(auctionno);
	}
	
	// 경매 수정
	@PostMapping(value="/auctionEdit", consumes="multipart/form-data")
	public String auctionEdit(
		    @RequestParam("auctiontitle") String auctiontitle, 
		    @RequestParam("auctioncontent") String auctioncontent,
			@RequestParam("image") MultipartFile image,
			@RequestParam("buynow") int buynow,
			@RequestParam("startprice") int startprice,
			@RequestParam("minbid") int minbid,
			@RequestParam("auctionno") int auctionno,
			HttpServletRequest req
//		    ,AuctionAddDTO dto <- 에러의 온상 기억해두자
			)			
		   throws ServletException, IOException {
		logger.info("<<< Controller auctionEdit Start! >>>");
		
		String uploadDirectory = req.getSession().getServletContext().getRealPath("/images");
		
		AuctionAddDTO dto = new AuctionAddDTO();
		
		if (!image.isEmpty()) {
			String fileName = image.getOriginalFilename();
			logger.info("fileName fullPath={}", fileName);
			// 저장할 파일 경로
			
			File uploadedFile = new File(fileName);

			String fullPath = uploadDirectory + File.separator + uploadedFile;
			image.transferTo(new File(fullPath));
			String filePath = "http://localhost:8081/images/"+uploadedFile+"/";
			
			dto.setImage(filePath);
			}
		
		dto.setAuctionno(auctionno);
		dto.setAuctiontitle(auctiontitle);
		dto.setAuctioncontent(auctioncontent);
		dto.setBuynow(buynow);
		dto.setStartprice(startprice);
		dto.setMinBid(minbid);
		
		service.AuctionEdit(dto);
		
		logger.info(">>> Controller auctionEdit End! <<<");
		
		return "auctionEdit";
	}
	
	// 경매 리스트
	@GetMapping(value="/auction")
	public List<AuctionListDTO> auctionList() 
			throws ServletException, IOException {
		logger.info("<<< Controller auctionList Start! >>>");
		
		List<AuctionListDTO> list = service.AuctionList();
		return list;
	}
	
	// 경매 호스트
	@GetMapping(value="/auctionHost")
	public List<AuctionHostDTO> auctionHost(@RequestParam("userno")int userno)
			throws ServletException, IOException {
		logger.info("<<< Controller auctionHost Start! >>>");
		
		List<AuctionHostDTO> list = service.AuctionHost(userno);
		return list;
	}
	
	// 경매 게스트 - 경매중
	@GetMapping(value="/auctionGuest")
	public List<AuctionBidingDTO> auctionBiding(@RequestParam("name")String name)
			throws ServletException, IOException {
		logger.info("<<< Controller auctionBiding Start! >>>");
		
		return service.AuctionBiding(name);
	}
	
	// 경매 게스트 - 낙찰자
	@GetMapping(value="/auctionGuest_1")
	public List<AuctionBiderDTO> auctionBider(@RequestParam("name")String name)
			throws ServletException, IOException {
		logger.info("<<< Controller auctionBider Start! >>>");
		
		return service.AuctionBider(name);
	}
	
	@Autowired
    public AuctionController(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }
	
	// 경매 상세페이지 (진행 페이지)
	@MessageMapping("/send/bid/{auctionno}")
	@SendTo("/topic/receive/bid/{auctionno}")
	@GetMapping(value="auctionDetail")
	public AuctionDetailDTO auctionDetail(@DestinationVariable int auctionno, @Payload AuctionDetailDTO message)
			throws ServletException, IOException {
		logger.info("<<< Controller auctionBider Start! >>>");
		String topic = "/topic/bid/message/" + auctionno;
		
        // 여기에서 message를 처리
        messagingTemplate.convertAndSend(topic, message);
        System.out.println("메세지 수신: " + message);
		return service.Auction(auctionno);
	}
	
	@PostMapping(value="auctionStart")
	public String auctionStart(@RequestBody Map<String, String> data)
			throws ServletException, IOException {
		logger.info("<<< Controller auctionStart Start! >>>");
		
		int auctionno = Integer.parseInt(data.get("auctionno"));
		String name = (String) data.get("name");
		int lastprice = Integer.parseInt((String) data.get("lastprice"));

		AuctionBidingDTO dto = new AuctionBidingDTO();
		dto.setAuctionno(auctionno);
		dto.setName(name);
		dto.setLastprice(lastprice);
		
		Map<String, Object> map = new HashMap<>();
		map.put("auctionno", auctionno);
		map.put("name", name);
		
		int selectCnt = service.AuctionBidfind(map);
		
		if(selectCnt == 0) { //경매 중 상태 추가
			service.AuctionStart(dto);
			service.AuctionChamUpdate(dto);
			service.AuctionPriceUpdate(dto);
			System.out.println("입찰가 업데이트!");
		}
		else { // 이미 참여 중인 경우, 업데이트만
			service.AuctionPriceUpdate(dto);
			System.out.println("입찰가 업데이트!");
		}

		return "auctionStart";
	}
	
	@PostMapping(value = "auctionBiderAdd")
	public String auctionBiderAdd(@RequestBody Map<String, Object> data) 
	        throws ServletException, IOException, ParseException {
	    logger.info("<<< Controller auctionBiderAdd Start! >>>");
	    int auctionno = Integer.parseInt(String.valueOf(data.get("auctionno")));
	    System.out.println("auctionno : " + auctionno);
	    String name = (String) data.get("name");
	    int bidprice = Integer.parseInt(String.valueOf(data.get("bidprice")));
	    
	    if (auctionno != 0) {
	    	System.err.println("낙찰자 시스템 시작");
		    String auendtimeStr = (String) data.get("auendtime");
		    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
		    Date parsedDate = dateFormat.parse(auendtimeStr);
		    Timestamp auendtime = new Timestamp(parsedDate.getTime());
		    
		    AuctionBiderDTO dto = new AuctionBiderDTO();
		    dto.setAuctionbidderno(auctionno);
		    dto.setAuctionno(auctionno);
		    dto.setName(name);
		    dto.setBidprice(bidprice);
		    dto.setAuendtime(auendtime);
		    
		    service.AuctionBiderAdd(dto);	
		    
		    AuctionDTO Audto = new AuctionDTO();
		    
		    Audto.setAuctionno(auctionno);
		    Audto.setName(name);
		    
		    service.AuctionSetEndTime(Audto);
		    
		    return "auctionBiderAdd";
	    } else {
	    	System.err.println("낙찰자 시스템 오류!");
	    	return "auctionBiderAdd";
	    }
	}
	
	@GetMapping(value = "hostAndGuestChatInfo")
	public AuctionDTO hostAndGuestChatInfo(@RequestParam("auctionno")int auctionno)
			throws ServletException, IOException {
		logger.info("<<< Controller hostAndGuestChatInfo Start! >>>");

		return service.hostAndGuestChatInfo(auctionno);
	}

}
