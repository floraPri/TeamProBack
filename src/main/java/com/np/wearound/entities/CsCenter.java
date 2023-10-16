package com.np.wearound.entities;

import java.util.Date;

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

@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(
        name = "SEQ_GENERATOR",
        sequenceName = "questionnum_seq",
        allocationSize = 1
)
@Entity	//누락주의
@DynamicInsert
@Table(name="cscenter")
@Builder
@Data
public class CsCenter {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GENERATOR")
	private int questionnum;
	private String title;
	private String content;
	private Date createdate;
	private String show;
}
