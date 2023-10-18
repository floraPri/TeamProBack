package com.np.wearound.entities;
//상품 엔티티

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(
		name = "SEQ_GENERATOR",
		sequenceName = "productNo_seq",
		allocationSize = 1
)
@Entity
@Table(name="product_tbl")
@Builder
@Data
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="SEQ_GENERATOR")
    private int product_code;        //NUMBER(10) PRIMARY KEY,
    private String product_name;       //VARCHAR2(100) NOT NULL,
    private String product_brand;       //VARCHAR2(100) NOT NULL,
    private String product_img;          //VARCHAR2(100) NOT NULL,
    private String product_content;     //CLOB NOT NULL,
    private int product_price;        //NUMBER(10) NOT NULL,
    private int product_stock;       //NUMBER(10),
    private String product_state;       //VARCHAR2(50) NOT NULL,
    private String product_category;    //VARCHAR2(100) NOT NULL,
    private Date product_update;    //DATE DEFAULT sysdate,
    private String show;                  //CHAR(3) DEFAULT 'Y' NOT NULL,
    private int userno;                 //NUMBER(10)
}
