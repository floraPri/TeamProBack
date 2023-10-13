package com.np.wearound.service;

import java.nio.CharBuffer;
import java.util.Optional;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.np.wearound.dto.CredentialsDTO;
import com.np.wearound.dto.SignUpDTO;
import com.np.wearound.dto.UserDTO;
import com.np.wearound.entities.User;
import com.np.wearound.exception.AppException;
import com.np.wearound.mappers.UserMapper;
import com.np.wearound.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {
	
	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	
	public UserDTO findById(String email) {
		
		System.out.println("<<<UserService - findById()>>>");
		
		User user = userRepository.findByEmail(email)
			.orElseThrow(() -> new AppException("UnKnown user", HttpStatus.NOT_FOUND));
		
	    UserDTO userDTO = new UserDTO();
	    userDTO.setEmail(user.getEmail());
	    userDTO.setPassword(user.getPassword());
	    
	    return userDTO;
		
	}
	
	public User login(CredentialsDTO credentialsDTO) {
		System.out.println("<<<UserService - login()>>>");
		
		User user = userRepository.findByEmail(credentialsDTO.getEmail())
			.orElseThrow(() -> new AppException("UnKnown user", HttpStatus.NOT_FOUND));
		//비밀번호 인코더를 사용하여 비밀번호가 일반 텍스트로 저장되는 것을 방지하지만 해시된 비밀번호는 읽을수 없다.
		//import java.nio.CharBuffer; //주의
		if(passwordEncoder.matches(CharBuffer.wrap(credentialsDTO.getPassword()),user.getPassword())) {
			return user;
		}
		
		throw new AppException("Invalid password", HttpStatus.BAD_REQUEST);
	}
	
	public User register(SignUpDTO userDTO) {
		System.out.println("<<<userService - register>>>");
		System.out.println("id : " + userDTO.getEmail());
		System.out.println("firstName : " + userDTO.getPhone());
		System.out.println("lastName : " + userDTO.getName());
		System.out.println("password : " + userDTO.getPassword());
//		System.out.println("token: " + userDTO.getToken());
		
		Optional<User> optionalUser = userRepository.findByEmail(userDTO.getEmail());
		
		if(optionalUser.isPresent()) {
			throw new AppException("Login already exists",HttpStatus.BAD_REQUEST);
			
		}
		
		User user = new User();
		user.setEmail(userDTO.getEmail());
		user.setPhone(userDTO.getPhone());
		user.setName(userDTO.getName());
//		user.setToken(userDTO.getToken());
		
		//passwordEncoder를 사용하여 암호를 일반텍스로 저장한다.
		user.setPassword(passwordEncoder.encode(CharBuffer.wrap(userDTO.getPassword())));
		
		User saveUser = userRepository.save(user);
		
		return saveUser;
		
	}
}
