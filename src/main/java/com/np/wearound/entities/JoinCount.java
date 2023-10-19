package com.np.wearound.entities;

import java.util.Date;

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
@DynamicInsert
@Table(name="date_user_join_view")
@Builder
@Data
public class JoinCount {
	
	@Id
	private Date join_date;
	private int join_count;
}
