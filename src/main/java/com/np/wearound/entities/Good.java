package com.np.wearound.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * 좋아요 엔티ㅣ
 * 2023-10-30 생성
 * @author 김명진
 *
 */

@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(
		name="SEQ_GENERATOR",
		sequenceName="good_seq",
		allocationSize = 1
)
@Entity
@DynamicInsert
@Table(name="good_tbl")
@Builder
@Data
public class Good {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="SEQ_GENERATOR")
	private int goodcode;			//NUMBER(10) PRIMARY KEY,
	
	private int userno;				//
	private int feedcode;			//
	private String ischecked;		//DEFAULT 'Y',
}
