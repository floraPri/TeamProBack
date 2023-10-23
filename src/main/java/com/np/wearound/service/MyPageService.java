package com.np.wearound.service;

import java.util.List;

import com.np.wearound.dto.BuyDTO;
import com.np.wearound.entities.Feed;

public interface MyPageService {
	
	//회원 구매리스트
	public List<BuyDTO> orderListAll(int userno);
	
	//마이페이지 피드목록
	public List<Feed> feedList(int userno);
}
