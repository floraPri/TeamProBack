package com.np.wearound.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.np.wearound.dto.FeedDTO;
import com.np.wearound.entities.FeedComment;
import com.np.wearound.entities.Follow;
import com.np.wearound.entities.Good;
import com.np.wearound.service.FeedPageServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(value="/feed")
public class FeedController {
	private static final Logger logger = LoggerFactory.getLogger(FeedController.class);

	//http://localhost:8081/feed/
	
	@Autowired
	private FeedPageServiceImpl service;
	
	//피드목록 페이지
	@GetMapping("/feedPage")
	public List<FeedDTO> feedList() 
			throws ServletException, IOException{
		logger.info("<<<< FeedController -  feedList(피드목록 출력)>>>>");
		System.out.println("컨트롤러 - 피드목록 출력");
		
		List<FeedDTO> feed_list = service.feedList();
		System.out.println("컨트롤러 - 피드 데이터 전송성공");
		return feed_list;
	}
	
	//피드목록 페이지 무한스크롤
	@GetMapping("/feedPageScroll")
	public List<FeedDTO> feedListScroll(@RequestParam int page) 
			throws ServletException, IOException{
		logger.info("<<<< FeedController -  feedListScroll(피드목록 출력)>>>>");
		System.out.println("page: " + page);
		
		List<FeedDTO> feed_list = service.feedListScroll(page);
		System.out.println("feed_list : " + feed_list);
		return feed_list;
	}
	
	//등록회원별 목록 페이지
	@GetMapping("/feedListByIdPage")
	public List<FeedDTO> feedListByUserid(@RequestParam String userid) 
			throws ServletException, IOException {
		logger.info("<<<< FeedController -  feedList(아이디별 등록피드리스트 출력)>>>>");
		System.out.println("컨트롤러 - 피드목록 출력");
		
		List<FeedDTO> feed = service.feedListById(userid);
		
		System.out.println("컨트롤러 - 아이디별 피드데이터 전송성공");
		System.out.println("컨트롤러 - feed"+feed);
		return feed;
	}
	
	//피드 댓글 목록 출력
	@GetMapping("/commentList")
	public List<FeedComment> feedCommentList(@RequestParam int feedcode) 
			throws ServletException, IOException {
		logger.info("<<<< FeedController -  feedList(피드댓글 목록 출력)  >>>>");	
		List<FeedComment> comment_list = service.commentList(feedcode);
		return comment_list;
	}

	//피드 댓글 입력
	@PostMapping("/commentAdd")
	public String commentAdd(@RequestBody Map<String,String> map)
		throws ServletException, IOException {
		logger.info("<<<< FeedController -  commentAdd(피드댓글 목록 출력)  >>>>");
		
		FeedComment fcmt = new FeedComment();
		
		fcmt.setComment_content(map.get("comment_content"));
		fcmt.setWriter(map.get("writer"));
		fcmt.setUserno(Integer.parseInt(map.get("userno")));
		fcmt.setFeedcode(Integer.parseInt(map.get("feedcode")));
		
		System.out.println(fcmt);
		service.insertComment(fcmt);
		
		return "feedPage";
	}
	
	//좋아요 선택 시 체크확인하여 두 가지 동작 작동 //(좋아요 체크, 해지가 체크여부에 따라 동시에 일어남)
	@PostMapping("/goodcheck")
	public int goodCheck(@RequestBody Map<String, String> map) 
			throws ServletException, IOException {
		logger.info("<<<< FeedController -  goodcheck(좋아요 성공)  >>>>");
		int feedcode = Integer.parseInt(map.get("feedcode"));
		int userno = Integer.parseInt(map.get("userno"));
		
		Map<String,Object> chkMap = new HashMap<String,Object>();
		chkMap.put("feedcode",feedcode);
		chkMap.put("userno",userno);
		
		//좋아요 체크 여부 확인
		int resultCnt = service.goodByUserChk(chkMap);
		System.out.println("resultCnt : "+ resultCnt);
		if(resultCnt != 0) {
			// checkedCnt == 1 이면 이미 체크 상태 -> 그러면 삭제!
			System.out.println("unchecked");
			service.deleteGood(userno,feedcode);
			return 0;
		} else {
			// checkedCnt == 0은 unchecked 상태 -> 체크하기...insert
			System.out.println("checked");
			Good good = new Good();
			good.setFeedcode(feedcode);
			good.setUserno(userno);
			service.insertGood(good);
			return 1;
		}
	}
	
	//좋아요 체크여부 결과
	@GetMapping("/goodcheck")
	public int goodChkResult(
			@RequestParam("feedcode") int feedcode,
			@RequestParam("userno") int userno) throws ServletException, IOException {
		logger.info("<<<< FeedController -  goodChkResult(체크여부 결과)  >>>>");
	
		Map<String,Object> chkResult = new HashMap<String,Object>();
		
		chkResult.put("feedcode",feedcode);
		chkResult.put("userno",userno);
		
		int resultCnt = service.goodByUserChk(chkResult);
		
		if(resultCnt != 0) {
			System.out.println("check상태:: true---"+resultCnt);
			return 1;
		} else {
			// checkedCnt == 0은 unchecked 상태 -> 체크하기...insert			
			System.out.println("check상태:: false---"+resultCnt);
			return 0;
		}
	}
		
	// 구독 확인
	@GetMapping("/isFollow")
	public Follow isfollow(@RequestParam String following, @RequestParam String follower)
		throws ServletException, IOException {
		logger.info("<<< FeedController - isfollow >>>");
		Follow dto = service.isFollow(following, follower);
		return dto;
	}
	
	// 구독하기
	@PostMapping("/doFollow")
	public void doFollow(@RequestBody Follow follow) 
			throws ServletException, IOException {
		logger.info("<<< FeedController - doFollow >>>");
		service.doFollow(follow);
	}
	
	// 구독 취소하기
	@DeleteMapping("/quitFollow")
	public void quitFollow(@RequestParam int follownum) 
			throws ServletException, IOException {
		logger.info("<<< FeedController - quitFollow >>>");
		service.quitFollow(follownum);
    
	}
	
	// 게시물 카운트
	@GetMapping("/feedByIdCnt")
	public int feedByIdCnt(@RequestParam String username)
			throws ServletException, IOException{
		logger.info("<<< FeedController - feedByIdCnt >>>");
		return service.feedByIdCnt(username);
	}
	
	// 팔로워 카운트
	@GetMapping("/followerByIdCnt")
	public int followerByIdCnt(@RequestParam String follower) 
			throws ServletException, IOException {
		logger.info("<<< FeedController - followerByIdCnt >>>");
		return service.followerByIdCnt(follower);
	}
	
	// 팔로잉 카운트
	@GetMapping("/followingByIdCnt")
	public int followingByIdCnt(@RequestParam String following) 
			throws ServletException, IOException{
		logger.info("<<< FeedController - followingByIdCnt >>>");
		return service.followingByIdCnt(following);
	}
	
}
