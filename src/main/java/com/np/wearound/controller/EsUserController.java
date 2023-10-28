package com.np.wearound.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.np.wearound.document.EsAuction;
import com.np.wearound.document.EsUser;
import com.np.wearound.service.EsUserService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor	//생성자에 멤버변수를 주입
@RestController
@RequestMapping(value="/search")
public class EsUserController {
	
	private static final Logger logger = LoggerFactory.getLogger(EsUserController.class);
	
	private final EsUserService esUserService;
	
	//경매검색
	@GetMapping("/auctionsearch1")
	public ResponseEntity<SearchHits<EsAuction>> auctionsearch1 (@RequestBody String search) {
		System.out.println("<<< EsUserController - aa() >>>");
		return ResponseEntity.ok(esUserService.searchByAuctionInfo(search));	//새로운 jwt를 반환
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
