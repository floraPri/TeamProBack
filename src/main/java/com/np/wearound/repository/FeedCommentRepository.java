package com.np.wearound.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.np.wearound.entities.FeedComment;

public interface FeedCommentRepository extends JpaRepository<FeedComment,Integer> {
	List<FeedComment> findAllByFeedcode(int feedcode);
	
	List<FeedComment> findAllByFeedcodeOrderByRegdateDesc(int feedcode);
}
