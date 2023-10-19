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
@Table(name="date_user_login_view")
@Builder
@Data
public class LoginCount {
	
	@Id
	private Date login_date;
	private int login_count;
}
