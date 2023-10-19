package com.np.wearound.auctionDto;

public class AuctionHostDTO {
    private int auctionno;
    private int userno;
    private String auctiontitle;
    private String image;
    private int lastprice;
    private String lasttime;
    private String name;

    public AuctionHostDTO() {}

    // 매개변수 생성자
    public AuctionHostDTO(int auctionno, int userno, String auctiontitle, String image, int lastprice, String lasttime, String name) {
        this.auctionno = auctionno;
        this.userno = userno;
        this.auctiontitle = auctiontitle;
        this.image = image;
        this.lastprice = lastprice;
        this.lasttime = lasttime;
        this.name = name;
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

    public int getLastprice() {
        return lastprice;
    }

    public void setLastprice(int lastprice) {
        this.lastprice = lastprice;
    }

    public String getLasttime() {
        return lasttime;
    }

    public void setLasttime(String lasttime) {
        this.lasttime = lasttime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
