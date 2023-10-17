package com.np.wearound.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class LoginDTO {
	
	private int loginno;//로그인번호
	private int userno;//유저번호
	private Date joindate;//로그인 날짜

}
