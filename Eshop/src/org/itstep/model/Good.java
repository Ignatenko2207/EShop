package org.itstep.model;

public class Good {

	private String ArtNo;
	private String Name;
	private int Price;

	public String getArtNo() {
		return ArtNo;
	}

	public void setArtNo(String artNo) {
		ArtNo = artNo;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public int getPrice() {
		return Price;
	}

	public void setPrice(int price) {
		Price = price;
	}
	
	public Good(String artNo, String name, int prise) {
		this.ArtNo = artNo;
		this.Name = name;
		this.Price = prise;
	
	}
}
