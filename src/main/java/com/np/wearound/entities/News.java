package com.np.wearound.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity	//누락주의
@Table(name="news_tbl")
@Builder
@Data
public class News {
	
	/*
		newsno NUMBER PRIMARY KEY,
		newssection NUMBER NOT NULL,
	    title VARCHAR2(1000) NOT NULL,
	    main CLOB NOT NULL,
	    regdate VARCHAR2(50) NOT NULL,
	    url VARCHAR2(1000) NOT NULL
	 */
	
	@Id
	private int newsno;
	private int newssection;
	private String title;
	private String main;
	private String regdate;
	private String url;

}
