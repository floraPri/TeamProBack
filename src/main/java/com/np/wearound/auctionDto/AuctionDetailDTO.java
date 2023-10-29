package com.np.wearound.auctionDto;
import java.sql.Date;
import java.sql.Timestamp;

public class AuctionDetailDTO {
    private int auctionno;
    private int userno;
    private String auctiontitle;
    private String image;
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
    private String hostname;

    public AuctionDetailDTO() {
    }

    public AuctionDetailDTO(int auctionno, int userno, String auctiontitle, String image, String auctioncontent, int buynow, int startprice, int lastprice, int minbid, Date austarttime, Timestamp lasttime, int cham, String address, String name, String hostname) {
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
        this.hostname = hostname;
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

    public String getAuctioncontent() {
        return auctioncontent;
    }

    public void setAuctioncontent(String auctioncontent) {
        this.auctioncontent = auctioncontent;
    }

    public int getBuynow() {
        return buynow;
    }

    public void setBuynow(int buynow) {
        this.buynow = buynow;
    }

    public int getStartprice() {
        return startprice;
    }

    public void setStartprice(int startprice) {
        this.startprice = startprice;
    }

    public int getLastprice() {
        return lastprice;
    }

    public void setLastprice(int lastprice) {
        this.lastprice = lastprice;
    }

    public int getMinbid() {
        return minbid;
    }

    public void setMinbid(int minbid) {
        this.minbid = minbid;
    }

    public Date getAustarttime() {
        return austarttime;
    }

    public void setAustarttime(Date austarttime) {
        this.austarttime = austarttime;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getHostname() {
    	return hostname;
    }
    
    public void setHostname(String hostname) {
    	this.hostname = hostname;
    }
}

