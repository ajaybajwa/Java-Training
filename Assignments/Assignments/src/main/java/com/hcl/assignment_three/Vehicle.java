package com.hcl.assignment_three;

public class Vehicle {
	int vehicleNo;
	String model;
	String manufacturer;
	String color;
	
	public static void main(String[] args) {
		
	}
}

class Truck extends Vehicle{
	int loadingCapacityTons;
	
	public Truck() {
		// TODO Auto-generated constructor stub
	}
	
	public Truck(int vehicleNo, String model, String manufacturer,String color, int loadingCapacityTons) {
		this.vehicleNo = vehicleNo;
		this.model = model;
		this.manufacturer = manufacturer;
		this.color = color;
		this.loadingCapacityTons = loadingCapacityTons;
		System.out.println("Vehicle No: " +vehicleNo+"\nModel: "+model+"\nManufacturer: "+manufacturer+"\nColor: "+color+"\nLoading Capacity: "+loadingCapacityTons+" tons");
	}
	
	void changeAttributes(String newColor, int loadingCapacityTons) {
		this.color = newColor;
		this.loadingCapacityTons = loadingCapacityTons;
		System.out.println("\nVehicle No: " +vehicleNo+"\nModel: "+model+"\nManufacturer: "+manufacturer+"\ncolor: "+color+"\nLoading Capacity: "+loadingCapacityTons+" tons");
	}
	
	public static void main(String[] args) {
		Truck t1 = new Truck(1,"V600", "Volvo", "Red", 150);
		
		Truck t2 = new Truck();
		t2.vehicleNo = 2;
		t2.model = "T700";
		t2.manufacturer = "Kenworth";
		t2.color = "White";
		t2.loadingCapacityTons = 100;
		
		t2.changeAttributes("Yellow", 200);
		
	}
}
