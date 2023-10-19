package com.np.wearound.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.np.wearound.dto.BuyDTO;
import com.np.wearound.entities.Buy;

public interface MyPageService {
	
	//회원 구매리스트
	public List<BuyDTO> orderListAll();
	
}
