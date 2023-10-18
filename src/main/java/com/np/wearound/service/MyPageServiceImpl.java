package com.np.wearound.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.np.wearound.dto.BuyDTO;
import com.np.wearound.entities.Buy;
import com.np.wearound.repository.OrderRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MyPageServiceImpl implements MyPageService {

	@Autowired
	private OrderRepository dao;
	
	
	//구매목록 List
	@Override
	public List<Buy> orderListAll() {
		System.out.println(" MyPageServiceImpl - orderListAll");
		System.out.println(dao.findAll());
		
		return dao.findAll();
	}

}
