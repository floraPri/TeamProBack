package com.np.wearound.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.np.wearound.entities.User;


public interface UserRepository extends JpaRepository<User, Integer>{
	
//	Optional<User> findByLogin(String login);
	Optional<User> findByEmail(String email);
	User findByUserno(int userno);

}
