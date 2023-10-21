package com.np.wearound.entities;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(
        name = "SEQ_GENERATOR",
        sequenceName = "fundingcode_seq",
        allocationSize = 1
)
@Entity	//누락주의
@DynamicInsert
@Table(name="funding_tbl")
@Builder
@Data
public class Funding {

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
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GENERATOR")
	private int fundingcode; 
	private String category; 
	private String title; 
	private String image; 
	private String content; 
	private int userno; 
	private Date startdate; 
	private Date enddate;
	private int nowamount; 
	private int goalamount;
	
}
