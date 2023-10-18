package com.np.wearound.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.np.wearound.dto.CsCenterDTO;
import com.np.wearound.entities.CsCenter;
import com.np.wearound.entities.JoinCount;


public interface JoinCountRepository extends JpaRepository<JoinCount, Integer>{

}
