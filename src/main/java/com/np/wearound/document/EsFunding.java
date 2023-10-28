package com.np.wearound.document;

import java.sql.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

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
   private Date startdate; 
   private Date enddate;
   private int nowamount; 
   private int goalamount;
   
   
   public void setNowAmount(int nowamount) {
        this.nowamount = nowamount;
    }
}