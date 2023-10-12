package com.np.wearound.controller;

import java.net.URI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.np.wearound.config.UserAuthProvider;
import com.np.wearound.dto.CredentialsDTO;
import com.np.wearound.dto.SignUpDTO;
import com.np.wearound.entities.User;
import com.np.wearound.service.TokenBlacklistService;
import com.np.wearound.service.UserService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor	//생성자에 멤버변수를 주입
@RestController
public class AuthController {
	
	private static final Logger logger = LoggerFactory.getLogger(AuthController.class);
	
	private final UserService userService;
	private final TokenBlacklistService blacklistService;
	private final UserAuthProvider userAuthProvider;
	
	
	@PostMapping("/login")
	public ResponseEntity<User> login(@RequestBody CredentialsDTO credentialsDTO) {
		System.out.println("<<< AuthController - login() >>>");
		User user = userService.login(credentialsDTO);
		
		System.out.println("token:" + userAuthProvider.createToken(user.getEmail()));
		user.setToken(userAuthProvider.createToken(user.getEmail()));
		
		return ResponseEntity.ok(user);	//새로운 jwt를 반환
	}
	
	@PostMapping("/register")
	public ResponseEntity<User> register(@RequestBody SignUpDTO signUpDTO) {
		System.out.println("<<< AuthController - register() >>>");
		User user = new User();
		//엔티티를 생성할 때 새 엔티티를 찾을 수 있는 URL과 함께 201 HTTP 코드를 변환하는 것이 가장 좋다.
//		signUpDTO.setToken(userAuthProvider.createToken(user.getEmail()));
		user = userService.register(signUpDTO);
		
		return ResponseEntity.created(URI.create("/users/" + user.getEmail()))
				.body(user);//새로운 jwt를 반환
	}
	
	 @PostMapping("/logout")
	    public void logout(@RequestHeader("Authorization") String token) {
		 System.out.println("logout");
	        // Extract and blacklist the token
	        String authToken = token.replace("Bearer ", "");
	        blacklistService.blacklistToken(authToken);
	    }
}
