package com.np.wearound.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.np.wearound.dto.CsCenterDTO;
import com.np.wearound.entities.CsCenter;
import com.np.wearound.entities.JoinCount;
import com.np.wearound.entities.LoginCount;
import com.np.wearound.entities.User;
import com.np.wearound.repository.CsRepository;
import com.np.wearound.repository.JoinCountRepository;
import com.np.wearound.repository.LoginCountRepository;
import com.np.wearound.repository.UserRepository;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	private UserRepository userDao;
	
	@Autowired
	private CsRepository csDao;
	
	@Autowired
	private JoinCountRepository joinDao;
	
	@Autowired
	private LoginCountRepository LoginDao;
	
	// join chart
	@Override
	public List<JoinCount> joinCountList() {
		System.out.println("AdminServiceImpl - joinCountList");
		// joinDao.findAll()로 데이터를 가져옵니다.
	    List<JoinCount> joinCounts = joinDao.findAll();
	    
	    // null을 제거하기 위한 새로운 리스트를 생성합니다.
	    List<JoinCount> filteredJoinCounts = new ArrayList<>();
	    
	    // null이 아닌 요소만 새 리스트에 추가합니다.
	    for (JoinCount joinCount : joinCounts) {
	        if (joinCount != null) {
	            filteredJoinCounts.add(joinCount);
	        }
	    }
	    
	    System.out.println(filteredJoinCounts);
	    
	    return filteredJoinCounts;
	}

	// login chart
	@Override
	public List<LoginCount> loginCountList() {
		System.out.println("AdminServiceImpl - loginCountList");
		System.out.println(LoginDao.findAll());
		return LoginDao.findAll();
	}
	
	// user 검색
	@Override
	public User searchUser(int userno) {
		System.out.println("AdminServiceImpl - searchUser");
		System.out.println(userDao.findById(userno));
		return userDao.findById(userno).orElse(null);
	}

	// user ban
	@Override
	public void userBan(int userno, String enabled) {
		System.out.println("AdminServiceImpl - userBan");
		User user = userDao.findByUserno(userno);
        if (user != null) {
            user.setEnabled(enabled);
            userDao.save(user);
        }
	}
	
	// user release
	@Override
	public void userRelease(int userno, String enabled) {
		System.out.println("AdminServiceImpl - UserRelease");
		User user = userDao.findByUserno(userno);
        if (user != null) {
            user.setEnabled(enabled);
            userDao.save(user);
        }
	}
	
	// cs 리스트
	@Override
	public List<CsCenter> csListAll() {
		System.out.println("AdminServiceImpl - csListAll");
		System.out.println(csDao.findAll());
		return csDao.findAll();
	}

	// cs 추가
	@Override
	public void csAdd(CsCenter dto) {
		System.out.println("AdminServiceImpl - csAdd");
		System.out.println(dto);
		csDao.save(dto);
	}

}
