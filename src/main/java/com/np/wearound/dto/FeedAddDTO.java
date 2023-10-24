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
public class FeedAddDTO {
	private String title;       	//   VARCHAR2(100) NOT NULL,
	private String content;     	//CLOB NOT NULL,
	private String image;         	//VARCHAR2(100) NOT NULL,
	private int userno;          		//NUMBER(10),               ---- 작성자 userno	
}


