package com.np.wearound.dto;
/*
 * 구매DTO --- buy_tbl과 연관
 */

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class BuyDTO {
	private int product_buycode;      	//NUMBER(10) PRIMARY KEY,
    private int product_code;         	//NUMBER(10),
    private int buyer;                  //NUMBER(10),  -- 구매자 userno 
	private int amount;			        //NUMBER(10),	-- 구매수량	
	private int product_price;	        //NUMBER(10),	-- 상품단가	
	private int pay_price;		        //NUMBER(10),	-- 결제금액	
	private Date buy_date;		        //DATE DEFAULT sysdate
	private String product_name;		// 상품명
	private String product_brand;		// 상품 브랜드명
	private String product_img;			// 상품 이미지
	private String product_buyer_id;    ///구매자 id
	
	
	
	
}
