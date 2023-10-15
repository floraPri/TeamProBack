package com.np.wearound.auctionDto;

// 경매 추가 DTO
public class AuctionAddDTO {

	private int userno;
	private String auctiontitle;
	private String image;
	private String auctioncontent;
	private int buynow;
	private int startprice;
	private int minBid;
	
	public AuctionAddDTO() {}

	public AuctionAddDTO(int userno, String auctiontitle, String image, String auctioncontent, int buynow,
			int startprice, int minBid) {
		super();
		this.userno = userno;
		this.auctiontitle = auctiontitle;
		this.image = image;
		this.auctioncontent = auctioncontent;
		this.buynow = buynow;
		this.startprice = startprice;
		this.minBid = minBid;
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

	public int getMinBid() {
		return minBid;
	}

	public void setMinBid(int minBid) {
		this.minBid = minBid;
	}

	@Override
	public String toString() {
		return "AuctionEntity [userno=" + userno + ", auctiontitle=" + auctiontitle + ", image=" + image
				+ ", auctioncontent=" + auctioncontent + ", buynow=" + buynow + ", startprice=" + startprice
				+ ", minBid=" + minBid + "]";
	}
}
