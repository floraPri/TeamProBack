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
public class FundingViewDTO {

	private int userno; 
	
	private int fundingcode; 
	
	private String category; 
	private String title; 
//	private String subtitle; 
	private String image; 
	private String content; 
	private String precontent; 
	private Date startdate; 
	private Date enddate;
	private int nowamount; 
	private int goalamount;
	
	private int rewardscode;
	
	private int price;
	private String rewardtitle;
	private String rewardcontent;
	private Date delivery;
}
