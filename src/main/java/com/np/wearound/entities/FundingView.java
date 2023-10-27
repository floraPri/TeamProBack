package com.np.wearound.entities;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Entity	//누락주의
@DynamicInsert
@Table(name="funding_view")
@Builder
@Data
public class FundingView {
	
	@Id
	private int userno; 
	
	private int fundingcode; 
	
	private String category; 
	private String title; 
	private String subtitle; 
	private String image; 
	private String content; 
	private String subcontent; 
	private Date startdate; 
	private Date enddate;
	private int nowamount; 
	private int goalamount;
	
	private int rewardscode;
	
	private int price;
	private String rewardtitle;
	private String rewardsubtitle;
	private String rewardcontent;
	private Date delivery;

}
