package com.np.wearound.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.np.wearound.entities.Buy;


public interface BuyRepository extends JpaRepository<Buy,Integer> {
	
	
}
