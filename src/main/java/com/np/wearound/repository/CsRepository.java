package com.np.wearound.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.np.wearound.dto.CsCenterDTO;
import com.np.wearound.entities.CsCenter;


public interface CsRepository extends JpaRepository<CsCenter, Integer>{

	void save(CsCenterDTO dto);

}
