package com.np.wearound.controller;

import java.net.URI;
import java.util.Base64;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.np.wearound.config.UserAuthProvider;
import com.np.wearound.dto.CredentialsDTO;
import com.np.wearound.dto.SignUpDTO;
import com.np.wearound.dto.UserDTO;
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
	
	@Value("${security.jwt.token.secret-key:secret-value}")
	private String secretKey;
	
	//로그인
	@PostMapping("/login")
	public ResponseEntity<User> login(@RequestBody CredentialsDTO credentialsDTO) {
		System.out.println("<<< AuthController - login() >>>");
		User user = userService.login(credentialsDTO);
		user.setToken(userAuthProvider.createToken(user.getEmail()));
		System.out.println("token:" + user.getToken());
		
		
		return ResponseEntity.ok(user);	//새로운 jwt를 반환
	}
	//회원가입
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
	//로그아웃
	 @PostMapping("/logout")
	    public void logout(@RequestHeader("Authorization") String token) {
			System.out.println("logout");
			System.out.println("token : "+token);
		    // Extract and blacklist the token
		    String authToken = token.replace("Bearer ", "");
		    System.out.println("authToken : "+authToken);
		    blacklistService.blacklistToken(authToken);
		    System.out.println("블랙리스트 존재여부 : " + blacklistService.isTokenBlacklisted(authToken));
		    System.out.println("모든 블랙리스트 토큰: " + blacklistService.getBlacklistedTokens());
	    }
	 //토큰 블랙처리 확인용도
	 @GetMapping("/black")
	 	public UserDTO black(@RequestHeader("Authorization") String token) {
		 	secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
		 	String authToken = token.replace("Bearer ", "");
		 	JWTVerifier verifier = JWT.require(Algorithm.HMAC256(secretKey))
					.build();
		 	DecodedJWT decoded = verifier.verify(authToken);
			System.out.println("logout");
			System.out.println("token : "+authToken);
		    // Extract and blacklist the token
		    System.out.println("authToken : " + authToken);
		    System.out.println("블랙리스트 존재여부 : " + blacklistService.isTokenBlacklisted(authToken));
		    System.out.println("모든 블랙리스트 토큰: " + blacklistService.getBlacklistedTokens());
		    return userService.findById(decoded.getIssuer());
	    }
}
