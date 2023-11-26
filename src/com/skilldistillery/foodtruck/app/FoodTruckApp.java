package com.skilldistillery.foodtruck.app;

import com.skilldistillery.foodtruck.entities.*;

import java.util.Scanner;

public class FoodTruckApp {
	Scanner sc = new Scanner(System.in);

	private FoodTruck[] fleet = new FoodTruck[5];
	int truckCount = 0;

	public static void main(String[] args) {
		FoodTruckApp app = new FoodTruckApp();
		app.run();

	}

	public void run() {
		while (truckCount < 5) {
			if (truckCount > 0) {
				System.out.println("You can type 'quit' to return to the main menu.");
				System.out.println("Or...");
			}
			System.out.print("Please enter the name of a food truck: ");
			String truckName = sc.nextLine();
			
			
			if ("quit".equalsIgnoreCase(truckName)) {
				break;
			}

			if (truckCount > 0) {
				System.out.println("You can type 'quit' to return to the main menu. Your entry to this point will not be saved.");
				System.out.println("Or...");
			}
			System.out.print("Please enter the type of food: ");
			String foodType = sc.nextLine();

			if ("quit".equalsIgnoreCase(foodType)) {
				break;
			}

			System.out.print("Please enter a rating (1 - 5): ");
			
			int rating = sc.nextInt();
			sc.nextLine();

			if (rating < 1 || rating > 5) {
				System.out.println("Invalid entry. Please re-enter food truck data and include a rating number (1 - 5): ");
				continue;
			} 
			
			fleet[truckCount++] = new FoodTruck(truckName, foodType, rating);
		}

		while (true) {
			System.out.println("\nMENU:");
			System.out.println("1. List all exisiting food trucks: ");
			System.out.println("2. See the average rating of food trucks: ");
			System.out.println("3. Display the highest-rated food truck: ");
			System.out.println("4. Quit: ");

			System.out.println("Please make a selection by choosing a number (1 - 4): ");
			int choice = sc.nextInt();
			sc.nextLine();

			switch (choice) {
			case 1:
				listFoodTrucks(fleet, truckCount);
				break;
			case 2:
				showAverageRating(fleet, truckCount);
				break;
			case 3:
				displayHighestRated(fleet, truckCount);
				break;
			case 4:
				System.out.println("Goodbye!");
				sc.close();
				System.exit(0);
			default:
				System.out.println("Invalid entry! make a selection by choosing a number (1 - 4): ");
			}
		}
	}

	public void listFoodTrucks(FoodTruck[] fleet, int count) {
		if (count == 0) {
			System.out.println("No food trucks available to list.");
			return;
		}

		for (int i = 0; i < count; i++) {
			System.out.println(fleet[i]);
		}
	}

	public void showAverageRating(FoodTruck[] fleet, int count) {
		if (count == 0) {
			System.out.println("No food trucks available to list.");
			return;
		}
		double totalRating = 0.0;
		for (int i = 0; i < count; i++) {
			totalRating += fleet[i].getRating();
		}
		double averageRating = totalRating / count;
		System.out.println(averageRating);
	}

	public void displayHighestRated(FoodTruck[] fleet, int count) {
		if (count == 0) {
			System.out.println("No food trucks available to list.");
			return;
		}
		FoodTruck highestRated = fleet[0];
		for (int i = 0; i < count; i++) {
			if (fleet[i].getRating() > highestRated.getRating()) {
				highestRated = fleet[i];
			}
		}
		System.out.println("The highest rated food truck: ");
		System.out.println(highestRated);
	}
}