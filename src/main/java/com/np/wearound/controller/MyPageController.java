package com.np.wearound.controller;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.np.wearound.dto.BuyDTO;
import com.np.wearound.entities.Buy;
import com.np.wearound.service.MyPageServiceImpl;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/myPage")
public class MyPageController {
	private static final Logger logger = org.slf4j.LoggerFactory.getLogger(MyPageController.class);
	
	@Autowired
	private MyPageServiceImpl service;
	
	//마이페이지 메인
	@GetMapping("/myp")
	public String myPageMain(Model model) {
		logger.info("<<< MyPageController - MyPageMain >>>");
		
		return "myp";
	}
	
	
	//구매목록 페이지
	@GetMapping("/orderListPage")
	public List<BuyDTO> orderList(Model model) {
		logger.info("<<< MyPageController -  orderList(구매목록페이지)>>>");
		
		List<BuyDTO> order_list = service.orderListAll();
		
		return order_list;
	}
}
