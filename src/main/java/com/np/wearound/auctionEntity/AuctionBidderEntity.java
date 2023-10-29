package com.np.wearound.auctionEntity;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Data
@Builder
@Table(name="auctionbidder")
@Setter
@Getter
public class AuctionBidderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int auctionbidderno;

    private int auctionno;
    private String name;
    private int bidprice;
    private Timestamp auendtime;
    
    public AuctionBidderEntity() {}
    
	public AuctionBidderEntity(int auctionbidderno, int auctionno, String name, int bidprice, Timestamp auendtime) {
		super();
		this.auctionbidderno = auctionbidderno;
		this.auctionno = auctionno;
		this.name = name;
		this.bidprice = bidprice;
		this.auendtime = auendtime;
	}

    
}