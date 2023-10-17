package com.np.wearound.auctionEntity;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

// 경매 테이블 Entity
@Entity
@Data
@Builder
@Table(name="Auction")
@Setter
@Getter
public class AuctionEntity {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int auctionno;

    private int userno;
    private String auctiontitle;
    private String image;
    @Lob
    private String auctioncontent;
    private int buynow;
    private int startprice;
    private int lastprice;
    private int minbid;
    private Date austarttime;
    private Timestamp lasttime;
    private int cham;
    private String address;
    private String name;
    
    public AuctionEntity() {}

    public AuctionEntity(int auctionno, int userno, String auctiontitle, String image, String auctioncontent, int buynow,
            int startprice, int lastprice, int minbid, Date austarttime, Timestamp lasttime, int cham, String address, String name) {
        super();
        this.auctionno = auctionno;
        this.userno = userno;
        this.auctiontitle = auctiontitle;
        this.image = image;
        this.auctioncontent = auctioncontent;
        this.buynow = buynow;
        this.startprice = startprice;
        this.lastprice = lastprice;
        this.minbid = minbid;
        this.austarttime = austarttime;
        this.lasttime = lasttime;
        this.cham = cham;
        this.address = address;
        this.name = name;
    }
}
