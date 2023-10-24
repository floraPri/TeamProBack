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
public class FundingDTO {

//	fundingcode NUMBER PRIMARY KEY, -- 펀딩번호
//	category VARCHAR2(30) NOT NULL, -- 펀딩카테고리
//	title VARCHAR2(50) NOT NULL, -- 타이틀
//	image VARCHAR2(100) NOT NULL, -- 첨부 이미지
//	content CLOB NOT NULL, -- 펀딩 내용
//	userno NUMBER NOT NULL, -- 펀딩 진행하는 user
//	startdate DATE DEFAULT SYSDATE NOT NULL, -- 등록일(시작일)
//	enddate DATE NOT NULL, -- 마감일
//	nowamount NUMBER DEFAULT 0 NOT NULL, -- 모인 금액 
//	goalamount NUMBER NOT NULL, -- 목표금액	
	
	private int fundingcode; 
	private String category; 
	private String title; 
	private String subtitle; 
	private String image; 
	private String content; 
	private String subcontent; 
	private int userno; 
	private Date startdate; 
	private Date enddate;
	private int nowamount; 
	private int goalamount;
	
			
	
}
