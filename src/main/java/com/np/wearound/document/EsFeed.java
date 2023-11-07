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
@Document(indexName = "index_feed_tbl")
@Builder
@Data
public class EsFeed {

   @Id
   private int feedcode; 
   private String feedtitle; 
   private String feedcontent; 
   private String feedimg; 
   @Field(type = FieldType.Date, format = DateFormat.date_optional_time)
   private Date feedregdate; 
   private int userno; 
   private int comment_cnt;
   private String show; 
   
}