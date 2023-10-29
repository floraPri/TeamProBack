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

// 경매 테이블 Entity
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "index_search_tbl")
@Builder
@Data
public class EsSearchRank {
	
    @Id
    private int searchno;//검색번호
    private String searchcontent;//검색내용
    private int userno;//검색자
    @Field(type = FieldType.Date, format = DateFormat.date_optional_time)
    private Date searchdate;//검색날짜
}
