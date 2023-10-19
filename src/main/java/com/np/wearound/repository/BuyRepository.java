package com.np.wearound.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.np.wearound.entities.Buy;


public interface OrderRepository extends JpaRepository<Buy,Integer> {

}
