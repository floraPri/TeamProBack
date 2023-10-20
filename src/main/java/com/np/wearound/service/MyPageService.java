package com.np.wearound.service;

import java.util.List;

import com.np.wearound.dto.BuyDTO;

public interface MyPageService {
	
	//회원 구매리스트
	public List<BuyDTO> orderListAll(int userno);
	
}
