package berk;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class mainDemo {
	
	public static void main(String args[]) throws IOException {
		
		Admins admin1 = new Admins("Fatih","Terim");
		Admins admin2 = new Admins("Yuto","Nagatomo");
		
		Airport a1 = new Airport("izmir");
		Airport a2 = new Airport("istanbul");
		Airport a3 = new Airport("londra");
		Airport a4 = new Airport("amerika");
		Airport a5 = new Airport("almanya");
		
		Flight f1 = new Flight(a1,a2,7,5,2018);
		Flight f2 = new Flight(a2,a1,17,5,2018);
		Flight f3 = new Flight(a2,a4,7,5,2018);
		Flight f4 = new Flight(a3,a1,17,5,2018);
		Flight f5 = new Flight(a2,a3,17,5,2018);
		Flight f6 = new Flight(a2,a3,27,6,2018);
		
		
		admin1.createFlight(f1);
		admin2.createFlight(f2);
		admin2.createFlight(f3);
		admin2.createFlight(f4);
		admin2.createFlight(f5);
		admin2.createFlight(f6);
		
		ArrayList<Airport> airportList = new ArrayList<Airport>();
		airportList.add(a1);
		airportList.add(a2);
		airportList.add(a3);
		airportList.add(a4);
		airportList.add(a5);
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Please select whether you 'customer' or 'admin': (use lower-case)");
		String selection = input.nextLine();
		
		System.out.println("Enter your name: ");
		String name = input.nextLine();
		System.out.println("Enter your surname: ");
		String surname = input.nextLine();
		
		while(true) {		

			if(selection.equals("customer")) {
								
				Customer c = new Customer(name,surname);
				
				System.out.println("\nWelcome, "+name+" "+surname);
				System.out.println("\n\t\t\t----- CUSTOMER MENU -----\n\n1) Search and reserve flight(s)."
						+ "\n2) Cancel reservation(s).\n3) See all reservations."
						+ "\n4) Exit.");
				
				int selectionInt = input.nextInt();
				
				if(selectionInt == 1) {
					int sSelect,aSelect;
					System.out.println("Select starting airport: ");
					for (int i = 0; i < airportList.size(); i++) {
						System.out.println((i+1)+") "+airportList.get(i).getName());
					}
					sSelect = input.nextInt();
					
					System.out.println("Select arrival airport: ");
					for (int i = 0; i < airportList.size(); i++) {
						System.out.println((i+1)+") "+airportList.get(i).getName());
					}
					aSelect = input.nextInt();
					
					c.searchFlight(airportList.get(sSelect-1), airportList.get(aSelect-1));
					
					System.out.println("\n1) Back to main menu.\n2) Exit.");
					int newSelection = input.nextInt();
					
					if(newSelection == 1)continue;
					else if(newSelection == 2) {
						System.out.println("\nThank you for selecting us !");
						break;
					}
					else {
						System.out.println("Please enter valid choice.");
					}
				}else if(selectionInt == 2) {
					
					c.cancelReserve();
					
					System.out.println("\n1) Back to main menu.\n2) Exit.");
					int newSelection = input.nextInt();
					
					if(newSelection == 1)continue;
					else if(newSelection == 2) {
						System.out.println("\nThank you for selecting us !");
						break;
					}
					else {
						System.out.println("Please enter valid choice.");
					}
				}else if(selectionInt == 3) {
					
					c.seeReservations();

					System.out.println("\n1) Back to main menu.\n2) Exit.");
					int newSelection = input.nextInt();
					
					if(newSelection == 1)continue;
					else if(newSelection == 2) {
						System.out.println("\nThank you for selecting us !");
						break;
					}
					else {
						System.out.println("Please enter valid choice.");
					}
				}else if(selectionInt == 4){
					System.out.println("\nThank you for selecting us !");
					break;
				}else {
					System.out.println("Please make valid selection.");
				}
				
			}else if(selection.equals("admin")) {
				
				Admins admin = new Admins(name,surname);
				
				System.out.println("\nWelcome, "+name+" "+surname);
				
				System.out.println("\n\t\t\t----- ADMIN MENU -----\n\n1) Search flight(s)."
						+ "\n2) Create flight(s).\n3) Exit.");
				
				int selectionInt = input.nextInt();
				
				if(selectionInt == 1) {
					
					System.out.println("Which airport you want to see ?");
					for (int i = 0; i < airportList.size(); i++) {
						System.out.printf("%d) ",i+1);
						System.out.println(airportList.get(i).getName());
					}
					int s = input.nextInt();

					admin.searchFlight(airportList.get(s-1));
					
					System.out.println("\n1) Back to main menu.\n2) Exit.");
					int newSelection = input.nextInt();
					
					if(newSelection == 1)continue;
					else if(newSelection == 2) {
						System.out.println("\nThank you for selecting us !");
						break;
					}
					else {
						System.out.println("Please enter valid choice.");
					}
				}else if(selectionInt == 2) {
					
					int start = -1, arrive = -1;
					System.out.println("Enter starting airport: (use lower-case)");
					String a = input.next();
					System.out.println("Enter arrival airport: ");
					String b = input.next();
					
					for (int i = 0; i < airportList.size(); i++) {
						if(airportList.get(i).getName().equals(a)) {
							start = i;
						}
						if(airportList.get(i).getName().equals(b)) {
							arrive = i;
						}
					}				
					System.out.println("Enter day: ");
					int d = input.nextInt();
					System.out.println("Enter month: ");
					int m = input.nextInt();
					System.out.println("Enter year: ");
					int y = input.nextInt();
					
					if(start == -1 || arrive == -1) {
						System.out.println("Operation failed.");
					}else {
						admin.createFlight(airportList.get(start),airportList.get(arrive), d, m, y);
						System.out.println("Flight successfuly created.");
					}
					
					System.out.println("\n1) Back to main menu.\n2) Exit.");
					int newSelection = input.nextInt();
					
					if(newSelection == 1)continue;
					else if(newSelection == 2) {
						System.out.println("\nThank you for selecting us !");
						break;
					}
					else {
						System.out.println("Please enter valid choice.");
					}
				}else if(selectionInt == 3) {
					System.out.println("\nThank you for selecting us !");
					break;
				}else {
					System.out.println("Please make valid selection.");
				}
			}else {
				System.out.println("Please enter valid choice.");
				break;
			}
		}
	}
}
