package com.app.EfficientSS.beans;

public class Price {

	private double price;
	
	private double distance;
	
	private double price_per_km;

	public Price(double price, double distance, double price_per_km) {
		super();
		this.price = price;
		this.distance = distance;
		this.price_per_km = price_per_km;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public double getPrice_per_km() {
		return price_per_km;
	}

	public void setPrice_per_km(double price_per_km) {
		this.price_per_km = price_per_km;
	}

	@Override
	public String toString() {
		return "Price [price=" + price + ", distance=" + distance + ", price_per_km=" + price_per_km + "]";
	}

	public Price() {
		super();
	}
	 
}