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
@Document(indexName = "index_funding_tbl")
@Builder
@Data
public class EsFunding {

   @Id
   private int fundingcode; 
   private String category; 
   private String title; 
   private String subtitle; 
   private String image; 
   private String content; 
   private String subcontent; 
   private int userno; 
   @Field(type = FieldType.Date, format = DateFormat.date_optional_time)
   private Date startdate; 
   @Field(type = FieldType.Date, format = DateFormat.date_optional_time)
   private Date enddate;
   private int nowamount; 
   private int goalamount;
   
}