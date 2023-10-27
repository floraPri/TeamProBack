package com.np.wearound.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.np.wearound.entities.Funding;

@Repository
public interface FundingRepository extends JpaRepository<Funding, Integer>{
	
	List<Funding> findByCategory(String category);

}
