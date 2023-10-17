package com.np.wearound.entities;

import java.sql.Date;

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
        sequenceName = "LOGIN_SEQ",
        allocationSize = 1
)
@Entity	//누락주의
@DynamicInsert
@Table(name="login_tbl")
@Builder
@Data
public class Login {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GENERATOR")
	private int loginno;//로그인번호
	private int userno;//유저번호
	private Date joindate;//로그인 날짜
}
