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
        sequenceName = "rewardscode_seq",
        allocationSize = 1
)
@Entity	//누락주의
@DynamicInsert
@Table(name="fundingrewards_tbl")
@Builder
@Data
public class FundingRewards {

	
	/*
		rewardscode NUMBER PRIMARY KEY, -- 리워드 번호
		fundingcode NUMBER NOT NULL, -- 펀딩번호 FK
		userno NUMBER NOT NULL, -- 펀딩한 유저(reward 반영)
		quantity NUMBER NOT NULL, -- 수량
		price NUMBER NOT NULL, -- reward 가격
		title VARCHAR2(50) NOT NULL, -- title
		subtitle VARCHAR2(100) NOT NULL, -- 부제목
		content VARCHAR2(300) NOT NULL, -- 내용
		address DATE NOT NULL, -- 주소
		delivery DATE NOT NULL, -- 배송예정일
	
	 */
	
	private int fundingcode;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GENERATOR")
	private int rewardscode;
	private int price;
	private String title;
	private String content;
	private Date delivery;
	
	
}
