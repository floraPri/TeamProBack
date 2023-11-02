package com.np.wearound.dto;
/**
 * 피드 게시물에 대한 DTO
 */
import java.sql.Timestamp;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class FeedDTO {
	private int feedcode;        		//NUMBER(10) PRIMARY KEY,
	private String feedtitle;       	//   VARCHAR2(100) NOT NULL,
	private String feedcontent;     	//CLOB NOT NULL,
	private String feedimg;         	//VARCHAR2(100) NOT NULL,
	private Timestamp feedregdate;		//TIMESTAMP DEFAULT sysdate,
	private int userno;          		//NUMBER(10),               ---- 작성자 userno
	private String username;				// 닉네임
	private int comment_cnt;
	private int good_count;				//   NUMBER(10) DEFAULT 0,
	private String show;            	//  CHAR(3) DEFAULT 'Y' NOT NULL,
	private String userid;				// 유저 아이디
	
}


