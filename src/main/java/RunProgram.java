import java.util.List;
import java.util.Scanner;

import controller.RentalHelper;
import model.Rental;


public class RunProgram {
	static Scanner input = new Scanner(System.in);
	static RentalHelper lih = new RentalHelper();
	private static void addAnItem() {
		// TODO Auto-generated method stub
		System.out.print("Enter MAKE of car: ");
		String make = input.nextLine();
		System.out.print("Enter MODEL of car: ");
		String model = input.nextLine();
		System.out.print("Enter YEAR of car: ");
		int year = input.nextInt();
		Rental toAdd = new Rental(make, model, year);
		lih.insertItem(toAdd);

	}

	private static void deleteAnItem() {
		// TODO Auto-generated method stub
		System.out.print("Enter the MAKE of car to delete: ");
		String make = input.nextLine();
		System.out.print("Enter the MODEL of car to delete: ");
		String model = input.nextLine();
		System.out.print("Enter the YEAR of car to delete: ");
		int year = input.nextInt();
		Rental toDelete = new Rental(make, model, year);
		lih.deleteItem(toDelete);

	}
	
	private static void viewTheList() {
		List<Rental> allItems = lih.showAllItems();
		for(Rental singleItem: allItems) {
			System.out.println(singleItem.rentalDetails());
		}

	}


	
	
	public static void runMenu() {
		boolean goAgain = true;
		System.out.println("--- Welcome to our awesome shopping list! ---");
		while (goAgain) {
			System.out.println("*  Select an item:");
			System.out.println("*  1 -- Add an car");
			System.out.println("*  2 -- Delete a car");
			System.out.println("*  3 -- View the current rental cars");
			System.out.println("*  4 -- Exit the program");
			System.out.print("*  Your selection: ");
			int selection = input.nextInt();
			input.nextLine();

			if (selection == 1) {
				addAnItem();
			} else if (selection == 2) {
				deleteAnItem();
			} else if (selection == 3) {
				viewTheList();
			} else {
				lih.cleanUp();
				System.out.println("   Goodbye!   ");
				goAgain = false;
			}

		}
	}
	
	public static void main(String[] args) {
		
		runMenu();

	}
}
