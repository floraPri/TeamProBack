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
@Table(name="pledges_view")
@Builder
@Data
public class PledgesView {
	
//	p.pledgesnum, p.userno,	p.quantity, p.address, p.regdate
	@Id
	private int pledgesnum;
	private int userno;
	private int quantity;
	private String address;
	private Date regdate;
	
//	f.fundingcode, f.category, f.title, f.image, f.precontent, f.enddate, f.nowamount, f.goalamount,	
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
