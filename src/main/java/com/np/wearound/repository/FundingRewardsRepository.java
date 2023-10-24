package com.np.wearound.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.np.wearound.entities.FundingRewards;

public interface FundingRewardsRepository extends JpaRepository<FundingRewards, Integer>{

	 List<FundingRewards> findByFundingcode(int fundingcode);
}
