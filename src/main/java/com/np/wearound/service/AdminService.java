package com.np.wearound.service;

import java.util.List;
import java.util.Map;

import com.np.wearound.dto.CsCenterDTO;
import com.np.wearound.dto.UserDTO;
import com.np.wearound.entities.CsCenter;
import com.np.wearound.entities.JoinCount;
import com.np.wearound.entities.LoginCount;
import com.np.wearound.entities.User;

public interface AdminService {

	// join chart
	public List<JoinCount> joinCountList();
	
	// login chart
	public List<LoginCount> loginCountList();
	
	// user 검색
	public User searchUser(int userno);
	
	// user ban
	public void userBan(int userno, String enabled);
	
	// user release
	public void userRelease(int userno, String enabled);
	
	// cs 리스트
	public List<CsCenter> csListAll();
	
	// cs 추가
	public void csAdd(CsCenter dto);
	

}
