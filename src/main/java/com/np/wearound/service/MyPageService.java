package com.np.wearound.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;

import com.np.wearound.dto.BuyDTO;
import com.np.wearound.dto.FeedAddDTO;
import com.np.wearound.dto.FeedDTO;
import com.np.wearound.entities.Feed;

public interface MyPageService {
	
	//회원 구매리스트
	public List<BuyDTO> orderListAll(int userno) ;
	
	//마이페이지 피드목록
	public List<Feed> feedList(int userno);
	
	//피드 등록
	public void saveFeed(FeedAddDTO feedDTO) 
			throws ServletException, IOException;
	
	//피드 1건 select
	public FeedDTO get(int feedcode)
			throws ServletException, IOException;
	
	//피드 삭제
	public void delete(int feedcode)
			throws ServletException, IOException;
}	
