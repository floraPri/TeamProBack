package com.np.wearound.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.np.wearound.entities.FundingPledges;

@Repository
public interface FundingPledgesRepository extends JpaRepository<FundingPledges, Integer>{

	
}
