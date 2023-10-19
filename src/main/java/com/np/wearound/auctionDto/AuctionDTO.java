package com.np.wearound.auctionDto;

public class AuctionDTO {
    private int auctionno;
    private int userno;
    private String auctiontitle;
    private String image;
    private String auctioncontent;
    private int buynow;
    private int startprice;
    private int minbid;

    // 기본 생성자
    public AuctionDTO() {
    }

    // 매개변수 생성자
    public AuctionDTO(int auctionno, int userno, String auctiontitle, String image, String auctioncontent, int buynow, int startprice, int minbid) {
        this.auctionno = auctionno;
        this.userno = userno;
        this.auctiontitle = auctiontitle;
        this.image = image;
        this.auctioncontent = auctioncontent;
        this.buynow = buynow;
        this.startprice = startprice;
        this.minbid = minbid;
    }

    // Getter 및 Setter 메서드
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

    public int getMinbid() {
        return minbid;
    }

    public void setMinbid(int minbid) {
        this.minbid = minbid;
    }
}

