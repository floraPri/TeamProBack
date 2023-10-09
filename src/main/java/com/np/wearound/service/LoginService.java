package com.np.wearound.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

public interface LoginService {
	
	public int idCheck()
			throws ServletException, IOException;

}
