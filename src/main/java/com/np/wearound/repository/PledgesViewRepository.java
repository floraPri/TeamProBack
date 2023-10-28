package com.np.wearound.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.np.wearound.entities.PledgesView;

public interface PledgesViewRepository extends JpaRepository<PledgesView, Integer>{

	List<PledgesView> findByUsernoOrderByRegdateDesc(int userno);
}
