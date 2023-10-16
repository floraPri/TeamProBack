package com.np.wearound.controller;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.np.wearound.config.UserAuthProvider;
import com.np.wearound.entities.CsCenter;
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
	@GetMapping("/adminHome")
	public String adminHome(Model model) {
		logger.info("<<< AdminController - adminHome >>>");
		
		// 차트 넣어야함
		return "adminHome";
	}
	
	// 검색하기
	@GetMapping("/adminSearchUser")
	public ResponseEntity<User> userSearchAction(@RequestParam int userno) {
		logger.info("<<< AdminController - userSearchAction >>>");
		
	    User user = service.searchUser(userno);
	    if (user != null) {
	        return new ResponseEntity<>(user, HttpStatus.OK); // 검색 결과가 있을 때 OK 응답 반환
	    } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND); // 검색 결과가 없을 때 NOT_FOUND 응답 반환
	    }
	}
	
	// 질문등록 페이지
	@GetMapping("/addCs")
	public List<CsCenter> csCenterForm(Model model) {
		logger.info("<<< AdminController - csCenterForm >>>");
		System.out.println("컨트롤러:" + service.csListAll());
		return service.csListAll();

	}
	
	// 질문등록
	@PostMapping("/add")
	public String addCs(@RequestBody CsCenter dto) {
		logger.info("<<< AdminController - addCs >>>");
		
		service.csAdd(dto);
		return "redirect:/addCs";
	}
	
}
