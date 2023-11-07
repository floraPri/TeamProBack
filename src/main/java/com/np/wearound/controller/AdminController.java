package com.np.wearound.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.np.wearound.config.UserAuthProvider;
import com.np.wearound.entities.CsCenter;
import com.np.wearound.entities.JoinCount;
import com.np.wearound.entities.LoginCount;
import com.np.wearound.entities.User;
import com.np.wearound.service.AdminServiceImpl;
import com.np.wearound.service.TokenBlacklistService;
import com.np.wearound.service.UserService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor	//생성자에 멤버변수를 주입
@RestController
@RequestMapping(value="/admin")
public class AdminController {

	private static final Logger logger = org.slf4j.LoggerFactory.getLogger(AdminController.class);
	
	@Autowired
	private AdminServiceImpl service;
	
	// 어드민 메인
	@GetMapping("/joinChart")
	public List<JoinCount> joinChart() {
		logger.info("<<< AdminController - joinChart >>>");
		
		return service.joinCountList();
	}
	
	// 어드민 메인
	@GetMapping("/loginChart")
	public List<LoginCount> loginChart() {
		logger.info("<<< AdminController - loginChart >>>");
		
		return service.loginCountList();
	}
	
	// 검색하기
	@GetMapping("/{userno}")
	public ResponseEntity<User> userSearchAction(@RequestParam int userno) {
		logger.info("<<< AdminController - userSearchAction >>>");
		
	    User user = service.searchUser(userno);
	    if (user != null) {
	        return new ResponseEntity<>(user, HttpStatus.OK); // 검색 결과가 있을 때 OK 응답 반환
	    } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND); // 검색 결과가 없을 때 NOT_FOUND 응답 반환
	    }
	}
	
	// 유저 밴
	@ PutMapping("/userBan")
	public void userBan(@RequestBody Map<String, String> map) {
		logger.info("<<< AdminController - userBan >>>");
		int userno = Integer.parseInt(map.get("userno"));
	    String enabled = map.get("enabled");
		System.out.println(userno);
		System.out.println(enabled);
		service.userBan(userno, enabled);
	}
	
	// 유저 릴리즈
	@ PutMapping("/userRelease")
	public void userRelease(@RequestBody Map<String, String> map) {
		logger.info("<<< AdminController - userRelease >>>");
		int userno = Integer.parseInt(map.get("userno"));
	    String enabled = map.get("enabled");
		System.out.println(userno);
		System.out.println(enabled);
		service.userBan(userno, enabled);
	}
	
	// 질문등록 페이지
	@GetMapping("/addCs")
	public List<CsCenter> csCenterForm() {
		logger.info("<<< AdminController - csCenterForm >>>");
		System.out.println("컨트롤러:" + service.csListAll());
		return service.csListAll();

	}
	
	// 질문등록, 수정
	@PostMapping("/csAdd")
	public String addCs(@RequestBody CsCenter dto) {
		logger.info("<<< AdminController - addCs >>>");
		service.csAdd(dto);
		return "redirect:/addCs";
	}
	
	// 질문삭제
	@PutMapping("/csDelete")
	public void addCsDelete(@RequestBody Map<String, String> map) {
		logger.info("<<< AdminController - addCsDelete >>>");
		int questionnum = Integer.parseInt(map.get("questionnum"));
	    String show = map.get("show");
		System.out.println(questionnum);
		System.out.println(show);
		service.csDelete(questionnum, show);
	}
	
}
