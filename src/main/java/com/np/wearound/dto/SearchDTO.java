package com.np.wearound.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class SearchDTO {

	private int searchno;//검색번호
	private String searchcontent;//검색내용
    private int userno; //검색자
    private Date searchdate; //검색날짜
}
