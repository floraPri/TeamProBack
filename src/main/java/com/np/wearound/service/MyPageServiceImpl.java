package com.np.wearound.service;



import java.util.List;
import java.util.stream.Collectors;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.np.wearound.dto.BuyDTO;
import com.np.wearound.repository.BuyRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MyPageServiceImpl implements MyPageService {

	@Autowired
	private BuyRepository dao;
	
	@Autowired
	private SqlSession sqlSession;
	
	//구매목록 List
	@Override
	public List<BuyDTO> orderListAll(int userno) {
		System.out.println("MyPageServiceImpl - orderListAll()");
		
		List<BuyDTO> buyList = sqlSession.selectList("com.np.wearound.mappers.BuyMapper.buyList",userno);
		
		System.out.println(buyList);
		
		return buyList;
	}
	

	
}
