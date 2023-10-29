package com.np.wearound.auctionDto;

import java.sql.Date;
import java.sql.Timestamp;

public class AuctionBiderDTO {
    private int auctionbidderno;
    private String auctiontitle;
    private int auctionno;
    private String name;
    private int bidprice;
    private Timestamp auendtime;
    private String image;

    public AuctionBiderDTO() {
    }

    public AuctionBiderDTO(int auctionbidderno, String auctiontitle, int auctionno, String name, int bidprice, Timestamp auendtime, String image) {
		super();
		this.auctionbidderno = auctionbidderno;
		this.auctiontitle = auctiontitle;
		this.auctionno = auctionno;
		this.name = name;
		this.bidprice = bidprice;
		this.auendtime = auendtime;
	}

	public int getAuctionbidderno() {
		return auctionbidderno;
	}

	public void setAuctionbidderno(int auctionbidderno) {
		this.auctionbidderno = auctionbidderno;
	}

	
	
	public String getAuctiontitle() {
		return auctiontitle;
	}

	public void setAuctiontitle(String auctiontitle) {
		this.auctiontitle = auctiontitle;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAuctionno() {
		return auctionno;
	}

	public void setAuctionno(int auctionno) {
		this.auctionno = auctionno;
	}

	public int getBidprice() {
		return bidprice;
	}

	public void setBidprice(int bidprice) {
		this.bidprice = bidprice;
	}

	public Timestamp getAuendtime() {
		return auendtime;
	}

	public void setAuendtime(Timestamp auendtime) {
		this.auendtime = auendtime;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "AuctionBiderDTO [auctionbidderno=" + auctionbidderno + ", auctionno=" + auctionno + ", name=" + name
				+ ", bidprice=" + bidprice + ", auendtime=" + auendtime + "]";
	}
    
}