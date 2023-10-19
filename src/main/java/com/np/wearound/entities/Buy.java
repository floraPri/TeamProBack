package com.np.wearound.entities;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
		sequenceName = "buyCode_seq",
		allocationSize = 1
)
@Entity
@DynamicInsert
@Table(name="buy_tbl")
@Builder
@Data
public class Buy {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="SEQ_GENERATOR")
	private int product_buycode;         //NUMBER(10) PRIMARY KEY,	
	private int product_code;              //NUMBER(10),
	private int buyer;                       //NUMBER(10),                   -- 구매자 userno 
	private int amount;				        //NUMBER(10),	                -- 구매수량	
	private int product_price;		        //NUMBER(10),		            -- 상품단가	
	private int pay_price;			        //NUMBER(10),			        -- 결제금액	
	private Date buy_date;			        //DATE DEFAULT sysdate,				--결제일

	
	
}
