package com.np.wearound.service;

import java.util.List;

import com.np.wearound.dto.CsCenterDTO;
import com.np.wearound.dto.UserDTO;
import com.np.wearound.entities.CsCenter;
import com.np.wearound.entities.User;

public interface AdminService {

	// user 검색
	public User searchUser(int userno);
	
	// cs 리스트
	public List<CsCenter> csListAll();
	
	// cs 추가
	public void csAdd(CsCenter dto);
	

}
