package com.np.wearound.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.np.wearound.dto.FeedDTO;
import com.np.wearound.entities.FeedComment;
import com.np.wearound.entities.Like;
import com.np.wearound.repository.FeedCommentRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class FeedPageServiceImpl implements FeedPageService {

	@Autowired
	private SqlSession sqlSession;
	
	@Autowired
	private FeedCommentRepository commentDAO;
	
	//전체 피드 리스트 출력
	@Override
	public List<FeedDTO> feedList() 
			throws ServletException, IOException {
		System.out.println("피드 리스트 출력");
		
		List<FeedDTO> feedList = sqlSession.selectList("com.np.wearound.mappers.FeedMapper.feedList");
		System.out.println("피드 데이터 전송성공");
		return feedList;
	}
	
	//무한스크롤 피드 리스트 출력
	public List<FeedDTO> feedListScroll(int page) 
			throws ServletException, IOException {
		System.out.println("FeedPageServiceImpl feedListScroll");
		int start = ((page * 5)+1);
		int end = ((page * 5)+5);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("start", start);
		map.put("end", end);
		System.out.println("start---" + start + "end---" + end);
		List<FeedDTO> feedList = sqlSession.selectList("com.np.wearound.mappers.FeedMapper.feedListScroll",map);
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

	//피드게시물 별 피드댓글 리스트 출력
	@Override
	public List<FeedComment> commentList(int feedcode) {
		System.out.println("FeedPageServiceImpl - commentList(댓글 리스트 출력)");
		//List<FeedComment> commentList = commentDAO.findAllByFeedcode(feedcode);
		List<FeedComment> commentList = commentDAO.findAllByFeedcodeOrderByRegdateDesc(feedcode);
		return commentList;
	}

	//피드댓글 입력
	@Override
	public void insertComment(FeedComment feedComment) {
		System.out.println("FeedPageServiceImpl - insertComment(댓글 등록)");
		System.out.println(feedComment);
		commentDAO.save(feedComment);
	}

	//피드댓글 삭제
	@Override
	public void deleteCommnet(int commentno) {
		System.out.println("FeedPageServiceImpl - deleteCommnet(댓글 삭제)");
		commentDAO.deleteById(commentno);
	}

	//좋아요 체크
	@Override
	public void insertLike(Like like)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	//좋아요 체크 여부
	@Override
	public int likeByUserChk(Map<String, Object> map)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		return 0;
	}

	//좋아요 체크해제
	@Override
	public void deleteLike()
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
