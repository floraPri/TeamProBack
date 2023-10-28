package com.np.wearound.entities;

import java.sql.Date;
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
		sequenceName = "comm_seq",
		allocationSize = 1
)
@Entity
@DynamicInsert
@Table(name="comment_tbl")
@Builder
@Data
public class FeedComment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="SEQ_GENERATOR")
    private int commentno;				
    
	@ManyToOne
	@JoinColumn(name = "feedcode")
	private Feed feed;
	//private int feedcode;
    
	private String writer;
    private String comment_content;
    
    @ManyToOne
    @JoinColumn(name = "userno")
    private User user;
    //private int userno;
    private Date regdate;
}
