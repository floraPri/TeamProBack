package com.np.wearound.entities;

import java.sql.Timestamp;

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
		sequenceName = "feedcode_seq",
		allocationSize = 1
)
@Entity
@DynamicInsert
@Table(name="feed_tbl")
@Builder
@Data
public class Feed {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="SEQ_GENERATOR")
	private int feedcode;        //NUMBER(10) PRIMARY KEY,
	private String feedtitle;    //VARCHAR2(100) NOT NULL,
    private String feedcontent;  //     CLOB NOT NULL,
    private String feedimg;      //          VARCHAR2(100) NOT NULL,
    private Timestamp feedregdate;	//     TIMESTAMP DEFAULT sysdate,
    private int userno;					//  NUMBER(10),               ---- 작성자 userno
    private int comment_cnt;        //NUMBER(10) DEFAULT 0,
    private String show;              //CHAR(3) DEFAULT 'Y' NOT NULL
	
}
