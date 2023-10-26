package com.np.wearound.service;



import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.np.wearound.dto.BuyDTO;
import com.np.wearound.dto.FeedAddDTO;
import com.np.wearound.dto.FeedDTO;
import com.np.wearound.entities.Feed;
import com.np.wearound.repository.FeedRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MyPageServiceImpl implements MyPageService {

	@Autowired
	private FeedRepository dao;
	
	@Autowired
	private SqlSession sqlSession;
	
	//구매목록 List (사용안함)
	@Override
	public List<BuyDTO> orderListAll(int userno) {
		System.out.println("MyPageServiceImpl - orderListAll()");
		
		List<BuyDTO> buyList = sqlSession.selectList("com.np.wearound.mappers.BuyMapper.buyList",userno);
		
		System.out.println(buyList);
		
		return buyList;
	}

	//내가 등록한 피드목록 불러오기..
	@Override
	public List<Feed> feedList(int userno) {
		System.out.println("MyPageServiceImpl - feedList()");
		
		List<Feed> feedList = dao.findAllByUserno(userno);
		
		System.out.println("MyPageServiceImpl - "+ feedList);
		
		return feedList;
	}

	@Override
	public void saveFeed(FeedAddDTO feedDTO) 
			throws ServletException, IOException {
		System.out.println("<<< MyPageServiceImpl - saveFeed() >>>");
		
		Feed feed = new Feed();
		feed.setFeedtitle(feedDTO.getTitle());
		feed.setFeedcontent(feedDTO.getContent());
		feed.setUserno(feedDTO.getUserno());
		feed.setFeedimg(feedDTO.getImage());
		
		dao.save(feed);	
	}

	//수정 버튼 눌렀을 때 나오는 편집화면(1건 select)
	@Override
	public Feed findById(int feedcode) 
			throws ServletException, IOException {
		System.out.println("<<< MyPageServiceImpl - findById() >>>");
		Feed feed = dao.findById(feedcode).get();
		return feed;
	}

	//피드 삭제
	@Override
	public void delete(int feedcode) 
			throws ServletException, IOException {
		System.out.println("MyPageServiceImpl - (서비스) 피드삭제");
		
		dao.deleteById(feedcode);
	}

	//피드 수정
	@Override
	public void updateFeed(FeedAddDTO feedDTO) 
			throws ServletException, IOException {
		System.out.println("MyPageServiceImpl - (서비스) 피드수정");
		
		Feed feed = findById(feedDTO.getFeedcode());
		feed.setFeedcode(feedDTO.getFeedcode());
		feed.setFeedtitle(feedDTO.getTitle());
		feed.setFeedcontent(feedDTO.getContent());
		feed.setUserno(feedDTO.getUserno());
		feed.setFeedimg(feedDTO.getImage());
		
		dao.save(feed);
	}
	
	
	
	

	
}
