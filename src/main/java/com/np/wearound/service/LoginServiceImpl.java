package com.np.wearound.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.np.wearound.mappers.LoginMapper;

@Service
public class LoginServiceImpl implements LoginService{
	
	@Autowired
	private LoginMapper dao;

	@Override
	public int idCheck() throws ServletException, IOException {
		System.out.println(" service - idCheck ");
		
		return dao.idCheck();
	}
	

}
