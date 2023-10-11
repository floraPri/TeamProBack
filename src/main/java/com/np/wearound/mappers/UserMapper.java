package com.np.wearound.mappers;

import org.apache.ibatis.annotations.Mapper;

import com.np.wearound.dto.SignUpDTO;
import com.np.wearound.dto.UserDTO;
import com.np.wearound.entities.User;


@Mapper
public interface UserMapper {

	UserDTO toUserDTO(User user);
	
	User signUpToUser(SignUpDTO userDTO);
}
