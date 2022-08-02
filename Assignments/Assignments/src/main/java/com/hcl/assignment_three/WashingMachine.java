package com.hcl.assignment_three;

public class WashingMachine {

	static void switchON() {
		System.out.println("Machine is ON");
	}
	
	static int acceptClothes(int nClothes) {
		System.out.println("Added " +nClothes +" clothes");
		return nClothes;
	}
	
	static void acceptDetergent() {
		System.out.println("Detergent added");
	}
	
	static void switchOFF() {
		System.out.println("Machine is OFF");
	}
	
	public static void main(String[] args) {
		switchON();
		acceptClothes(5);
		acceptDetergent();
		switchOFF();
	}
}
