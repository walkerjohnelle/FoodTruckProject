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
			System.out.print("Please enter the name of the food truck: ");
			String truckName = sc.nextLine();

			if ("quit".equalsIgnoreCase(truckName)) {
				break;
			}
			System.out.print("Please enter the food type: ");
			String foodType = sc.nextLine();

			if ("quit".equalsIgnoreCase(foodType)) {
				break;
			}

			System.out.print("Please enter the rating (1 - 5): ");
			int rating = sc.nextInt();
			sc.nextLine();

			if ("quit".equals(rating)) {
				break;
			}
			fleet[truckCount++] = new FoodTruck(truckName, foodType, rating);

		}

		while (true) {
			System.out.println("MENU:");
			System.out.println("1. List all existing food trucks");
			System.out.println("2. See the averge rating of food trucks");
			System.out.println("3. Display the highest-rated food truck");
			System.out.println("4. Quit");

			System.out.print("Please make a menu selection by entering a number (1 - 4): ");
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
				System.out.println("Invalid entry. Please enter a number between (1 - 4): ");
			}
		}
	}

	public void listFoodTrucks(FoodTruck[] fleet, int count) {
		if (count == 0) {
			System.out.println("No trucks available to list");
			return;
		}
		for (int i = 0; i < count; i++) {
			System.out.println(fleet[i]);
		}
	}

	public void showAverageRating(FoodTruck[] fleet, int count) {
		if (count == 0) {
			System.out.println("No trucks available to list");
			return;
		}
		double totalRating = 0.0;
		for (int i = 0; i < count; i++) {
			totalRating += fleet[i].getRating();
		}
		double averageRating = totalRating / count;
		System.out.printf("\nAverage rating: %.2f\n", averageRating);
	}

	public void displayHighestRated(FoodTruck[] fleet, int count) {
		if (count == 0) {
			System.out.println("No trucks available to list");
			return;
		}
		FoodTruck highestRated = fleet[0];
		for(int i = 0; i < count; i ++) {
			if (fleet[i].getRating() > highestRated.getRating()) {
				highestRated = fleet[i];
			}
		}
		System.out.println("The highest rated food truck: ");
		System.out.println(highestRated);
	}

}