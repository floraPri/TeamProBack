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
        sequenceName = "pledgesnum_seq",
        allocationSize = 1
)
@Entity	//누락주의
@DynamicInsert
@Table(name="fundingpledges_tbl")
@Builder
@Data
public class FundingPledges {
	
	/*
	 	pledgesnum NUMBER PRIMARY KEY,
		fundingcode NUMBER NOT NULL,
		rewardscode NUMBER NOT NULL,
		userno NUMBER NOT NULL,
		quantity NUMBER NOT NULL, -- 수량?
		address VARCHAR2(150) NOT NULL,
		regdate DATE DEFAULT SYSDATE NOT NULL,
	  
	 */
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GENERATOR")
	private int pledgesnum;
 	private int fundingcode; 
 	private int rewardscode; 
	private int userno;
	private int quantity;
	private String address;
	private Date regdate;


}
