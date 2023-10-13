package com.np.wearound.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.np.wearound.dto.CsCenterDTO;
import com.np.wearound.entities.CsCenter;
import com.np.wearound.entities.User;
import com.np.wearound.repository.CsRepository;
import com.np.wearound.repository.UserRepository;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	private UserRepository userDao;
	
	@Autowired
	private CsRepository csDao;
	
	// user 검색
	@Override
	public User searchUser(int userno) {
		System.out.println("AdminServiceImpl - searchUser");
		System.out.println(userDao.findById(userno));
		return userDao.findById(userno).orElse(null);
	}

	// cs 리스트
	@Override
	public List<CsCenter> csListAll() {
		System.out.println("AdminServiceImpl - csListAll");
		
		return csDao.findAll();
	}

	// cs 추가
	@Override
	public void csAdd(CsCenter dto) {
		csDao.save(dto);
	}

}
