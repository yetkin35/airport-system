package berk;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Customer extends Person {

	public ArrayList<Flight> reservedFlights = new ArrayList<Flight>();
	
	public void searchFlight(Airport a1,Airport a2) throws IOException {	
		
		File f = new File(this.getName()+this.getSurname()+"ReservedFlights.txt");
		FileWriter fw = new FileWriter(f,true);
		
		if(!f.exists()) {
			f.createNewFile();
		}
		
		int j = 1;
		for (int i = 0; i < a1.flights.size(); i++) {
			
			if(a1.flights.get(i).getArrivalAirport().equals(a2)) {
				
				System.out.printf("%d) ",j);
				System.out.println(a1.flights.get(i));
				j++;
			}
		}
		
		if(j == 1) {
			
			System.out.println("There is no such a flight from selected airports.");
			fw.close();
			return;
		}	
		Scanner input = new Scanner(System.in);
		int selection;
		System.out.println("Please select the flight that you want to reserve.");
		selection = input.nextInt();
		
		j = 1;
		for (int i = 0; i < a1.flights.size(); i++) {
			
			if(a1.flights.get(i).getArrivalAirport().equals(a2)) {
				
				if(j == selection) {
					try{					
						if(f.length() != 0) {
							fw.write(System.getProperty("line.separator"));
						}
						fw.write(a1.flights.get(i).toString());
						
						fw.close();
			        }
			        catch (Exception e){
			        	e.printStackTrace();
			        }
				}	
				j++;
			}	
		}

		System.out.println("Succesfuly reserved.");
	}
	
	public void cancelReserve() {
		
		try {
			
			File inputFile = new File(this.getName()+this.getSurname()+"ReservedFlights.txt");
			File tempFile = new File(this.getName()+this.getSurname()+"ReservedFlightsTemp.txt");
			
			if(!inputFile.exists() || inputFile.length() == 0) {
				System.out.println("\nThere is no reservations !");
				return;
			}
			
			FileInputStream fileInStreamObj = new FileInputStream(inputFile);
			FileWriter fw = new FileWriter(tempFile,true);
			InputStream inStreamObject = (InputStream) fileInStreamObj;
			Scanner sc = new Scanner(inStreamObject);
			String input;
			ArrayList<String> tempFlights = new ArrayList<String>();
			int i = 1;
			while((input = sc.nextLine()) != null) {
				if(input.length() == 0)continue;
				System.out.println(i+") "+input);
				i++;
				tempFlights.add(input);
				
				if(!sc.hasNext())break;
			}
			sc.close();
			
			Scanner girdi = new Scanner(System.in);
			int selection;
			System.out.println("\nPlease select the reservation that you want to cancel: ");
			selection = girdi.nextInt();
			
			for (int j = 0; j < tempFlights.size(); j++) {
				if((j+1) != selection) {
					if(j != 0) {
						fw.write(System.getProperty("line.separator"));
					}
					fw.write(tempFlights.get(j).toString());
				}			
			}
		
			fw.close();
			System.out.println("\nReservation cancelled !");
			boolean d = inputFile.delete();
			boolean r = tempFile.renameTo(inputFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void seeReservations() {		
		
		try {
				
				File inputFile = new File(this.getName()+this.getSurname()+"ReservedFlights.txt");
			
				if(!inputFile.exists() || inputFile.length() == 0) {
					System.out.println("\nThere is no reservations !");
					return;
				}
				
				FileInputStream fileInStreamObj = new FileInputStream(inputFile);
				InputStream inStreamObject = (InputStream) fileInStreamObj;
				Scanner sc = new Scanner(inStreamObject);
				String input;
				int i = 1;
				
				while((input = sc.nextLine()) != null) {
					if(input.length() == 0)continue;
					System.out.println(i+") "+input);
					i++;	
					
					if(!sc.hasNext())break;
				}
				sc.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	public Customer(String name, String surname) {
		super(name, surname);
		// TODO Auto-generated constructor stub
	}
}
