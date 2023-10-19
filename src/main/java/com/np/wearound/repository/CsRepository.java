package com.np.wearound.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.np.wearound.entities.CsCenter;


public interface CsRepository extends JpaRepository<CsCenter, Integer>{
	List<CsCenter> findAllByOrderByQuestionnum();
	
	CsCenter findByQuestionnum(int questionnum);
}
