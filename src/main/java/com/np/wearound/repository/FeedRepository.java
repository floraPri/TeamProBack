package com.np.wearound.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.np.wearound.entities.Feed;

public interface FeedRepository extends JpaRepository<Feed,Integer> {
	List<Feed> findAllByUserno(int userno);
}
