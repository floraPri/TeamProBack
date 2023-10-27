package com.np.wearound.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.np.wearound.entities.FundingView;

public interface FundingViewRepository extends JpaRepository<FundingView, Integer>{

	Optional<FundingView> findByFundingcodeAndRewardscode(int fundingcode, int rewardscode);
}
