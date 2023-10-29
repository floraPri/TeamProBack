package com.np.wearound.auctionDto;

import java.sql.Timestamp;

public class AuctionBidingDTO {
    private int auctionbidderno;
    private int auctionno;
    private String name;
    private String auctiontitle;
    private String image;
    private int lastprice;
    private Timestamp lasttime;

    public AuctionBidingDTO() {}

    public AuctionBidingDTO(int auctionbidderno, int auctionno, String name, String auctiontitle, String image, int lastprice, Timestamp lasttime) {
        this.auctionbidderno = auctionbidderno;
        this.auctionno = auctionno;
        this.name = name;
        this.auctiontitle = auctiontitle;
        this.image = image;
        this.lastprice = lastprice;
        this.lasttime = lasttime;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getLastprice() {
        return lastprice;
    }

    public void setLastprice(int lastprice) {
        this.lastprice = lastprice;
    }

    public Timestamp getLasttime() {
        return lasttime;
    }

    public void setLasttime(Timestamp lasttime) {
        this.lasttime = lasttime;
    }
}