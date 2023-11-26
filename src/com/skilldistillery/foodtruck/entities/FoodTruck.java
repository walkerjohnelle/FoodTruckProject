package com.skilldistillery.foodtruck.entities;

public class FoodTruck {
// fields
	private String foodTruckName;
	private String foodType;
	private int rating;

// ctors
	public FoodTruck() {

	}

	public FoodTruck(String foodTruckName, String foodType, int rating) {
		this.foodTruckName = foodTruckName;
		this.foodType = foodType;
		this.rating = rating;
	}

// getters & setters
	public String getFoodTruckName() {
		return foodTruckName;
	}

	public void setFoodTruckName(String foodTruckName) {
		this.foodTruckName = foodTruckName;
	}

	public String getFoodType() {
		return foodType;
	}

	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

//	toString
	public String toString() {
		return "\nFood Truck Name: " + foodTruckName + "\nFood Type: " + foodType + "\nRating: " + rating;
	}

}
