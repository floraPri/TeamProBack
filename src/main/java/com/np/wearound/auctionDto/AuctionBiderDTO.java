package com.np.wearound.auctionDto;

import java.sql.Date;
import java.sql.Timestamp;

public class AuctionBiderDTO {
    private int auctionbidderno;
    private int auctionno;
    private int userno;
    private int bidprice;
    private Timestamp auendtime;
    private String auctiontitle;
    private String image;

    public AuctionBiderDTO() {
    }

    public AuctionBiderDTO(int auctionbidderno, int auctionno, int userno, int bidprice, Timestamp auendtime,
			String auctiontitle, String image) {
		super();
		this.auctionbidderno = auctionbidderno;
		this.auctionno = auctionno;
		this.userno = userno;
		this.bidprice = bidprice;
		this.auendtime = auendtime;
		this.auctiontitle = auctiontitle;
		this.image = image;
	}

	public int getAuctionbidderno() {
		return auctionbidderno;
	}

	public void setAuctionbidderno(int auctionbidderno) {
		this.auctionbidderno = auctionbidderno;
	}

	public int getAuctionno() {
		return auctionno;
	}

	public void setAuctionno(int auctionno) {
		this.auctionno = auctionno;
	}

	public int getUserno() {
		return userno;
	}

	public void setUserno(int userno) {
		this.userno = userno;
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

	public String getAuctiontitle() {
		return auctiontitle;
	}

	public void setAuctiontitle(String auctiontitle) {
		this.auctiontitle = auctiontitle;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "AuctionBiderDTO [auctionbidderno=" + auctionbidderno + ", auctionno=" + auctionno + ", userno=" + userno
				+ ", bidprice=" + bidprice + ", auendtime=" + auendtime + ", auctiontitle=" + auctiontitle + ", image="
				+ image + "]";
	}
    
}
