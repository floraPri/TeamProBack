package com.np.wearound.config;

import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;	//경로주의(롬복 아님)
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.np.wearound.dto.UserDTO;
import com.np.wearound.service.UserService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class UserAuthProvider {
	
	@Value("${security.jwt.token.secret-key:secret-value}")
	private String secretKey;
	
	private final UserService userService;
	
	@PostConstruct
	protected void init() {
		secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
	}
	
	//토큰생성
	public String createToken(String id) {
		
		Date now = new Date();
		Date validity = new Date(now.getTime() + 36000000);
		UserDTO dto = userService.findById(id);
		if(dto.getAuthority().equals("ROLE_ADMIN")) {
			return JWT.create()
					.withIssuer(id)
					.withIssuedAt(now)
					.withExpiresAt(validity)
					.withClaim("roles", "ROLE_ADMIN")
					.sign(Algorithm.HMAC256(secretKey));
		}
		else {
			return JWT.create()
					.withIssuer(id)
					.withIssuedAt(now)
					.withExpiresAt(validity)
					.withClaim("roles", "ROLE_USER")
					.sign(Algorithm.HMAC256(secretKey));
		}
	}
	
	//토큰디코딩
	public Authentication validateToken(String token) {
		JWTVerifier verifier = JWT.require(Algorithm.HMAC256(secretKey)).build();
		DecodedJWT decoded = verifier.verify(token);//토큰 검증
		UserDTO user = userService.findById(decoded.getIssuer());
		String role = decoded.getClaim("roles").asString();
		List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority(role));
		return new UsernamePasswordAuthenticationToken(user, null, authorities);
	}
}
