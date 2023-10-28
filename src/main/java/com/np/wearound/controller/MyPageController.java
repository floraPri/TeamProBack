package com.np.wearound.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.np.wearound.dto.BuyDTO;
import com.np.wearound.service.MyPageServiceImpl;

import lombok.RequiredArgsConstructor;
/**
 * 사용하지 않는 컨트롤러(작성자: 김명진)
 * @author ict02-22
 *
 */

@RestController
@RequestMapping(value="/myPage")
public class MyPageController {
	private static final Logger logger = LoggerFactory.getLogger(MyPageController.class);
	
	@Autowired
	private MyPageServiceImpl service;
	
	
	//http://localhost:8081/myPage/myp/
	//마이페이지 메인
	
	
	//구매목록 페이지
	@GetMapping("/order")
	public List<BuyDTO> orderList(@RequestParam int userno)
			throws ServletException, IOException {
		logger.info("<<< MyPageController -  orderList(구매목록페이지)>>>");
		System.out.println("고객 아이디: "+userno);
		
		List<BuyDTO> order_list = service.orderListAll(userno);
		
		return order_list;
	}
}
