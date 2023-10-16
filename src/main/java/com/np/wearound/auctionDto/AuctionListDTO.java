package com.np.wearound.auctionDto;

import java.sql.Timestamp;

public class AuctionListDTO {
    private int auctionno;
    private String auctiontitle;
    private String image;
    private int startprice;
    private Timestamp lasttime;
    private int cham;

    public AuctionListDTO() {
    }

    public AuctionListDTO(int auctionno, String auctiontitle, String image, int startprice, Timestamp lasttime, int cham) {
        this.auctionno = auctionno;
        this.auctiontitle = auctiontitle;
        this.image = image;
        this.startprice = startprice;
        this.lasttime = lasttime;
        this.cham = cham;
    }

    public int getAuctionno() {
        return auctionno;
    }

    public void setAuctionno(int auctionno) {
        this.auctionno = auctionno;
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

    public int getStartprice() {
        return startprice;
    }

    public void setStartprice(int startprice) {
        this.startprice = startprice;
    }

    public Timestamp getLasttime() {
        return lasttime;
    }

    public void setLasttime(Timestamp lasttime) {
        this.lasttime = lasttime;
    }

    public int getCham() {
        return cham;
    }

    public void setCham(int cham) {
        this.cham = cham;
    }
}
