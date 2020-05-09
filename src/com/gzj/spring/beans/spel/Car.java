package com.gzj.spring.beans.spel;

public class Car {

		private String brand;
		private double price;
		//ÂÖÌ¥µÄÖÜ³¤
		private double tyrePrimter;
		
		public double getTyrePrimter() {
			return tyrePrimter;
		}
		public void setTyrePrimter(double tyrePrimter) {
			this.tyrePrimter = tyrePrimter;
		}
		public String getBrand() {
			return brand;
		}
		public void setBrand(String brand) {
			this.brand = brand;
		}
		public double getPrice() {
			return price;
		}
		public void setPrice(double price) {
			this.price = price;
		}
		@Override
		public String toString() {
			return "Car [brand=" + brand + ", price=" + price + ", tyrePrimter=" + tyrePrimter + "]";
		}
		
		
}
