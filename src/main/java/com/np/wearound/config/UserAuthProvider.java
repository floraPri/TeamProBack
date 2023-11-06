package com.np.wearound.config;

import java.util.ArrayList;
import java.util.Base64;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;	//경로주의(롬복 아님)
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.np.wearound.dto.UserDTO;
import com.np.wearound.service.UserService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class UserAuthProvider {
	//JWT를 생성하고 검증하기 위해 pom.xml에 java-jwt 라이브러리 추가
	
	@Value("${security.jwt.token.secret-key:secret-value}")
	private String secretKey;
	
	private final UserService userService;
	
	@PostConstruct
	protected void init() {
		//일단 텍스트로 된 비밀키를 피하기위해 base64로 인코딩
		secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
	}
	
	public String createToken(String id) {
		
		System.out.println("<<<UserAuthProvider - createToken>>>>");
		
		Date now = new Date();
		Date validity = new Date(now.getTime() + 36000000);	//토큰 유효시간 1시간
		UserDTO dto = userService.findById(id);
		//JWT를 사용하려면 pom.xml에 java-jwt 추가
		if(dto.getAuthority().equals("ROLE_ADMIN")) {//어드민 아이디를 받을경우 토큰내 권한을 다르게 설정
			System.out.println("ROLE_ADMIN");
			return JWT.create()
					.withIssuer(id)
					.withIssuedAt(now)
					.withExpiresAt(validity)
					.withClaim("roles", "ROLE_ADMIN")
					.sign(Algorithm.HMAC256(secretKey));
		}
		else {
			System.out.println("ROLE_USER");
			return JWT.create()
					.withIssuer(id)
					.withIssuedAt(now)
					.withExpiresAt(validity)
					.withClaim("roles", "ROLE_USER")
					.sign(Algorithm.HMAC256(secretKey));
		}
	}
	
	public Authentication validateToken(String token) {	//org.springframework.security.core.Authentication
		System.out.println("<<<UserAuthProvider - validateToken()>>>");
		System.out.println("UserAuthProvider - token()" + token);
		
		JWTVerifier verifier = JWT.require(Algorithm.HMAC256(secretKey))
				.build();
		
		System.out.println("<<<UserAuthProvider - validateToken 1>>>");
		
		//JWT를 확인하기 위해 먼저 디코딩한다. 유효기간을 초과하면 예외가 발생한다.
		DecodedJWT decoded = verifier.verify(token);	
		System.out.println("토큰 사용자 이메일 : " + decoded.getIssuer());
		System.out.println("<<<UserAuthProvider - validateToken 2>>>");
		UserDTO user = userService.findById(decoded.getIssuer());
		System.out.println("!!!");
		String role = decoded.getClaim("roles").asString();
		System.out.println("토큰 클레임 내 권한 정보 : " + role);
		List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority(role));
		//사용자가 내 데이터베이스에 존재하는지 확인
		return new UsernamePasswordAuthenticationToken(user, null, authorities);
	}
}
