package com.np.wearound.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.ServletException;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.np.wearound.dto.FeedDTO;
import com.np.wearound.dto.FeedUserInfoDTO;
import com.np.wearound.entities.FeedComment;
import com.np.wearound.entities.Follow;
import com.np.wearound.entities.Good;
import com.np.wearound.repository.FeedCommentRepository;
import com.np.wearound.repository.FollowRepository;
import com.np.wearound.repository.GoodRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class FeedPageServiceImpl implements FeedPageService {

	@Autowired
	private SqlSession sqlSession;
	
	@Autowired
	private FeedCommentRepository commentDAO;
	
	@Autowired
	private GoodRepository goodDAO;
	
	@Autowired
	private FollowRepository followDAO;
	
	
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
		List<FeedComment> commentList = commentDAO.findAllByFeedcodeOrderByRegdateDesc(feedcode);
		return commentList;
	}

	//피드댓글 입력
	@Override
	public void insertComment(FeedComment feedComment) {
		System.out.println("FeedPageServiceImpl - insertComment(댓글 등록)");
		commentDAO.save(feedComment);
	}

	//피드댓글 삭제
	@Override
	public void deleteCommnet(int commentno) {
		System.out.println("FeedPageServiceImpl - deleteCommnet(댓글 삭제)");
		commentDAO.deleteById(commentno);
	}

   /*
    * 좋아요(Good) 기능
    * 
    */
	   	
	//좋아요 선택(insert)
	@Override
	public void insertGood(Good good) 
			throws ServletException, IOException {
		System.out.println("FeedPageServiceImpl - insertGood(좋아요 입력!)");
		
		goodDAO.save(good);
		System.out.println("!!@@@@" + good);
		System.out.println("FeedPageServiceImpl - 하트 체크 성공!");
	}

	//좋아요 체크여부 확인(1: checked / 0:unchecked)
	@Override
	public int goodByUserChk(Map<String,Object> mapChk) 
			throws ServletException, IOException {
		System.out.println("FeedPageServiceImpl - goodByUserChk(좋아요 체크여부 판단)");
		int chkResultCnt = sqlSession.selectOne("com.np.wearound.mappers.FeedMapper.goodChk",mapChk);
		return chkResultCnt;
	}

	//좋아요 해지(삭제)
	@Override
	public void deleteGood(int userno, int feedcode)
			throws ServletException, IOException {
		System.out.println("FeedPageServiceImpl - deleteGood(좋아요 체크해제 성공)");
		goodDAO.deleteByUsernoAndFeedcode(userno,feedcode);
	}

	/**
	 * 팔로잉 기능
	 */

	//팔로우 여부 확인
	@Override
	public Follow isFollow(String following, String follower)
			throws ServletException, IOException {
		System.out.println("FeedPageServiceImpl - isFollow(팔로잉 여부 체크)");
		Map<String, String> map = new HashMap<>();
		map.put("following",following);
		map.put("follower",follower);
		
		Follow follow = sqlSession.selectOne("isFollow",map);
		
		return follow;
	}

	//팔로우 하기
	@Override
	public void doFollow(Follow follow)
			throws ServletException, IOException {
		System.out.println("FeedPageServiceImpl - doFollow(팔로우하기)");
		
		followDAO.save(follow);
	}

	//팔로우 취소하기
	@Override
	public void quitFollow(int follownum)
			throws ServletException, IOException {
		System.out.println("FeedPageServiceImpl - quitFollow(팔로우 취소)");
	
		followDAO.deleteById(follownum);
	}

	//아이디별 피드 등록갯수
	@Override
	public int feedByIdCnt(String username)
			throws ServletException, IOException {
		System.out.println("FeedPageServiceImpl - feedByIdCnt(등록피드 수)");
		return sqlSession.selectOne("feedByIdCnt",username);
	}

	//팔로우 수
	@Override
	public int followerByIdCnt(String follower)
			throws ServletException, IOException {
		System.out.println("FeedPageServiceImpl - followByIdCnt(팔로우 수)");
		return sqlSession.selectOne("followerByIdCnt",follower);
	}

	//팔로잉 수
	@Override
	public int followingByIdCnt(String following)
			throws ServletException, IOException {
		System.out.println("FeedPageServiceImpl - followingByIdCnt(팔로잉 수)");
		return sqlSession.selectOne("followingByIdCnt",following);
	}

	// 개별피드페이지 정보
	@Override
	public FeedUserInfoDTO countInfo(String userid) 
			throws ServletException, IOException {
		System.out.println("FeedPageServiceImpl - countInfo(계정 정보 출력)");
		return sqlSession.selectOne("com.np.wearound.mappers.FeedMapper.userInfo",userid);
	}

	

}
