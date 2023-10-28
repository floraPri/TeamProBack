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
public class FundingPledgesDTO {
	
	private int pledgesnum;
 	private int fundingcode; 
 	private int rewardscode; 
	private int userno;
	private int quantity;
	private String address;
	private Date regdate;
	
}
