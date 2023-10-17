package com.np.wearound.auctionDto;

import java.sql.Date;

public class AuctionBiderDTO {
    private int auctionbidderno;
    private int auctionno;
    private int userno;
    private int bidprice;
    private Date auendtime;

    public AuctionBiderDTO() {
    }

    public AuctionBiderDTO(int auctionbidderno, int auctionno, int userno, int bidprice, Date auendtime) {
        this.auctionbidderno = auctionbidderno;
        this.auctionno = auctionno;
        this.userno = userno;
        this.bidprice = bidprice;
        this.auendtime = auendtime;
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

    public Date getauendtime() {
        return auendtime;
    }

    public void setauendtime(Date auendtime) {
        this.auendtime = auendtime;
    }
}
