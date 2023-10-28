package com.np.wearound.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.np.wearound.entities.FundingView;

public interface FundingViewRepository extends JpaRepository<FundingView, Integer>{
	
	List<FundingView> findByUserno(int userno);
	Optional<FundingView> findByFundingcodeAndRewardscode(int fundingcode, int rewardscode);
}
