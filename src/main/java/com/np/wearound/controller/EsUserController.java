package com.np.wearound.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.elasticsearch.core.AggregationsContainer;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.np.wearound.document.EsAuction;
import com.np.wearound.document.EsFeed;
import com.np.wearound.document.EsFunding;
import com.np.wearound.document.EsSearchRank;
import com.np.wearound.document.EsUser;
import com.np.wearound.dto.RankAgg;
import com.np.wearound.dto.SearchDTO;
import com.np.wearound.entities.Search;
import com.np.wearound.service.EsUserService;
import com.np.wearound.service.SearchService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor	//생성자에 멤버변수를 주입
@RestController
@RequestMapping(value="/search")
public class EsUserController {
	
	private static final Logger logger = LoggerFactory.getLogger(EsUserController.class);
	
	private final EsUserService esUserService;
	private final SearchService searchService;
	
	//검색기록
	@GetMapping("/searchrank")
	public void searchrank () {//수정중
	}
	
	//검색기록
	@PostMapping("/searchhistory")
	public void searchhistory (@RequestBody SearchDTO dto) {
		System.out.println("<<< EsUserController - searchhistory() >>>");
		System.out.println("검색기록 : "+dto);
		searchService.searchHistoryAdd(dto);
		return ;	
	}
	
	//펀딩검색
	@GetMapping("/fundingsearch")
	public ResponseEntity<SearchHits<EsFunding>> fundingsearch (@RequestParam String search) {
		System.out.println("<<< EsUserController - fundingsearch() >>>");
		System.out.println("펀딩 입력된 검색어 : " + search);
		return ResponseEntity.ok(esUserService.searchByFundingInfo(search));	
	}
	
	//경매검색
	@GetMapping("/auctionsearch")
	public ResponseEntity<SearchHits<EsAuction>> auctionsearch (@RequestParam String search) {
		System.out.println("<<< EsUserController - auctionsearch() >>>");
		System.out.println("경매 입력된 검색어 : " + search);
		return ResponseEntity.ok(esUserService.searchByAuctionInfo(search));	
	}
	
	//피드검색
	@GetMapping("/feedsearch")
	public ResponseEntity<SearchHits<EsFeed>> feedsearch (@RequestParam String search) {
		System.out.println("<<< EsUserController - feedsearch() >>>");
		System.out.println("피드 입력된 검색어 : " + search);
		return ResponseEntity.ok(esUserService.searchByFeedInfo(search));	
	}
	
	//유저검색
	@GetMapping("/usersearch")
	public ResponseEntity<SearchHits<EsUser>> usersearch (@RequestParam String search) {
		System.out.println("<<< EsUserController - usersearch() >>>");
		System.out.println("입력된 검색어 : " + search);
		return ResponseEntity.ok(esUserService.searchByUserInfo(search));	
	}
	
//	//test - user 목록 전부 출력
//	@GetMapping("/test1")
//	public ResponseEntity<Iterable<EsUser>> aa () {
//		System.out.println("<<< EsUserController - aa() >>>");
//		
//		return ResponseEntity.ok(esUserService.findUserById());	//새로운 jwt를 반환
//	}
//	
//	//test - 경매전부리스트 띄우기
//	@GetMapping("/test2")
//	public ResponseEntity<Iterable<EsAuction>> auctions () {
//		System.out.println("<<< EsUserController - aa() >>>");
//		
//		return ResponseEntity.ok(esUserService.findAuctionAll());	//새로운 jwt를 반환
//	}
//	
//	//test - 경매검색(단일필드 검색)
//	@GetMapping("/test3")
//	public ResponseEntity<SearchHits<EsAuction>> auctionsearch (@RequestBody String search) {
//		System.out.println("<<< EsUserController - aa() >>>");
//		return ResponseEntity.ok(esUserService.searchByAuctionTitle(search));	//새로운 jwt를 반환
//	}
	

	
	
}
