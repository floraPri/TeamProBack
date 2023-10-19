package com.np.wearound.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.np.wearound.dto.CsCenterDTO;
import com.np.wearound.entities.CsCenter;
import com.np.wearound.entities.LoginCount;


public interface LoginCountRepository extends JpaRepository<LoginCount, Integer>{


}
