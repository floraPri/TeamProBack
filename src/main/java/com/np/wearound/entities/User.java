package com.np.wearound.entities;

import java.sql.Date;

import javax.persistence.Column;
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
        sequenceName = "USER_SEQ",
        allocationSize = 1
)
@Entity	//누락주의
@DynamicInsert
@Table(name="user_tbl")
@Builder
@Data
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GENERATOR")
	private int userno;//유저번호
	private String email;//이메일
	private String password;//비밀번호
    private int phone;//전화번호
    private String name;//별명
    private String img;//프로필사진
    private Date joindate;//회원가입 날짜
    private String key;//회원가입시 이메일 key 추가
    private String authority;//권한 : ROLE_USER:customer, ROLE_ADMIN:관리자
    private String enabled;//계정사용 가능여부(1:사용가능, 0:사용불가) : 이메일인증시 1로 update
    private String token;  

}