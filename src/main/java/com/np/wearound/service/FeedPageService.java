package com.np.wearound.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.np.wearound.dto.FeedDTO;
import com.np.wearound.entities.FeedComment;
import com.np.wearound.entities.Follow;
import com.np.wearound.entities.Good;

public interface FeedPageService {
	//피드목록 출력
	public List<FeedDTO> feedList() 
			throws ServletException, IOException;
	
	//아이디별피드목록 출력
	public List<FeedDTO> feedListById(String userid)
			throws ServletException, IOException;
	
	//피드 댓글목록 출력
	public List<FeedComment> commentList(int feedcode);
	
	//피드 댓글입력
	public void insertComment(FeedComment feedComment);
	
	//피드 댓글 삭제
	public void deleteCommnet(int commentno);
	
	//좋아요 처리 (isnert)
	public void insertGood(Good good) 
	         throws ServletException, IOException;
	
	//좋아요 체크 사용자 일치여부
	public int goodByUserChk(Map<String,Object> mapChk) 
	         throws ServletException, IOException;
	
	//좋아요 해지 (delete)
	public void deleteGood(int userno, int feedcode)
			 throws ServletException, IOException;
	
	//팔로우 확인
	public Follow isFollow(String following, String follower)
			throws ServletException, IOException;
	
	//팔로우 하기
	public void doFollow(Follow follow)
			throws ServletException, IOException;
	
	//팔로우 취소
	public void quitFollow(int follownum)
			throws ServletException, IOException;
	
	//게시물 갯수
	public int feedByIdCnt(String username)
			throws ServletException, IOException;
	
	//팔로우 갯수
	public int followerByIdCnt(String follower)
			throws ServletException, IOException;
	
	//팔로잉 갯수
	public int followingByIdCnt(String following)
			throws ServletException, IOException;
	

}
