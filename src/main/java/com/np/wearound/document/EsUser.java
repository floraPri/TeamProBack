package com.np.wearound.document;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "index_user_tbl")
@Builder
@Data
public class EsUser {
	
	@Id
	private int userno;//유저번호
	private String email;//이메일
	private String password;//비밀번호
    private int phone;//전화번호
    private String name;//별명
    private String img;//프로필사진
    @Field(type = FieldType.Date, format = DateFormat.date_optional_time)
    private Date joindate;//회원가입 날짜
    private String key;//회원가입시 이메일 key 추가
    private String authority;//권한 : ROLE_USER:customer, ROLE_ADMIN:관리자
    private String enabled;//계정사용 가능여부(1:사용가능, 0:사용불가) : 이메일인증시 1로 update
    private String token;
    
}