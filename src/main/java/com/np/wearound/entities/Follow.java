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


@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(
        name = "SEQ_GENERATOR",
        sequenceName = "follow_seq",
        allocationSize = 1
)
@Entity
@DynamicInsert
@Table(name="follow_tbl")
@Builder
@Data
public class Follow {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GENERATOR")
	private int follownum;
	private String following;
	private String follower;
	
}
