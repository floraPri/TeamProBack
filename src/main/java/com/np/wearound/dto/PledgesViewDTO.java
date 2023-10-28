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
public class PledgesViewDTO {

//	p.pledgesnum, p.userno,	p.quantity, p.address, p.regdate
	private int userno;
	private int pledgesnum;
	private int quantity;
	private String address;
	private Date regdate;
	
//	f.fundingcode, f.category, f.title, f.precontent, f.enddate, f.nowamount, f.goalamount,	
	private int fundingcode; 
	private String category; 
	private String title; 
	private String image; 
	private String precontent; 
	private Date enddate;
	private int nowamount; 
	private int goalamount;
	
//	r.rewardscode, r.price, r.title as rewardtitle, r.content as rewardcontent , r.delivery,
	private int rewardscode;
	private int price;
	private String rewardtitle;
	private String rewardcontent;
	private Date delivery;

	
}
