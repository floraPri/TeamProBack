package com.np.wearound.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.np.wearound.entities.FundingRewards;

public interface FundingRewardsRepository extends JpaRepository<FundingRewards, Integer>{
	
	Optional<FundingRewards> findByRewardscodeAndFundingcode(int rewardscode, int fundingcode);
	// rewards와 일치하는 funding 찾기
	List<FundingRewards> findByFundingcodeOrderByRewardscodeAsc(int fundingcode);

}	
