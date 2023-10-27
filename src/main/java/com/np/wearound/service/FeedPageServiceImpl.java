package com.np.wearound.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.np.wearound.dto.FeedDTO;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class FeedPageServiceImpl implements FeedPageService {

	@Autowired
	private SqlSession sqlSession;
	
	//전체 피드 리스트 출력
	@Override
	public List<FeedDTO> feedList() 
			throws ServletException, IOException {
		System.out.println("피드 리스트 출력");
		
		List<FeedDTO> feedList = sqlSession.selectList("com.np.wearound.mappers.FeedMapper.feedList");
		System.out.println("피드 데이터 전송성공");
		return feedList;
	}

	//아이디별 피드리스트 출력
	@Override
	public List<FeedDTO> feedListById(String userid)
			throws ServletException, IOException {
		
		List<FeedDTO> feedListById = sqlSession.selectList("com.np.wearound.mappers.FeedMapper.feedListById",userid);
		System.out.println(userid+"의 피드 데이터 전송성공");
		return feedListById;
	}

}
