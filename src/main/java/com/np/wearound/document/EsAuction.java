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
@Document(indexName = "index_auction_tbl")
@Builder
@Data
public class EsAuction {
	
    @Id
    private int auctionno;
    private int userno;
    private String auctiontitle;
    private String image;
    private String auctioncontent;
    private int buynow;
    private int startprice;
    private int lastprice;
    private int minbid;
    @Field(type = FieldType.Date, format = DateFormat.date_optional_time)
    private Date austarttime;
    @Field(type = FieldType.Date, format = DateFormat.date_optional_time)
    private Date lasttime;
    private int cham;
    private String address;
    private String name;
    private int status;
}
