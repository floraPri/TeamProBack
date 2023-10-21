package com.np.wearound.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.np.wearound.entities.Funding;

@Repository
public interface FundingRepository extends JpaRepository<Funding, Integer>{

}
