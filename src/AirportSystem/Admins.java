package berk;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class Admins extends Person{

	public void searchFlight(Airport a) {	
		
		try {
			
			File f = new File(a.getName()+"AirportsFlights.txt");
			
			if(!f.exists() || f.length() == 0) {
				System.out.println("\nThere is no flights !");
				return;
			}
			
			FileInputStream fileInStreamObj = new FileInputStream(f);
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
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void createFlight(Airport a1,Airport a2,int d,int m,int y) throws IOException {
		
		Flight flight = new Flight(a1,a2,d,m,y);
		a1.flights.add(flight);
		a2.flights.add(flight);
		
		File f = new File(flight.getStartingAirport().getName()+"AirportsFlights.txt");
		File f2 = new File(flight.getArrivalAirport().getName()+"AirportsFlights.txt");
		FileWriter fw = new FileWriter(f,true);
		FileWriter fw2 = new FileWriter(f2,true);
		
		if(!f.exists()) f.createNewFile();
		if(!f2.exists()) f.createNewFile();

		try{			
			if(f.length() != 0) fw.write(System.getProperty("line.separator"));
			if(f2.length() != 0) fw2.write(System.getProperty("line.separator"));
			
			fw.write(a1.flights.toString());
			fw2.write(a2.flights.toString());
			
			fw.close();
			fw2.close();
        }
        catch (Exception e){
        	e.printStackTrace();
        }
	}
	
	public void createFlight(Flight flight) throws IOException {
		
		flight.getStartingAirport().flights.add(flight);
		flight.getArrivalAirport().flights.add(flight);
		
		File f = new File(flight.getStartingAirport().getName()+"AirportsFlights.txt");
		File f2 = new File(flight.getArrivalAirport().getName()+"AirportsFlights.txt");
		FileWriter fw = new FileWriter(f,true);
		FileWriter fw2 = new FileWriter(f2,true);
		
		if(!f.exists()) f.createNewFile();
		if(!f2.exists()) f.createNewFile();

		try{			
			if(f.length() != 0) fw.write(System.getProperty("line.separator"));
			if(f2.length() != 0) fw2.write(System.getProperty("line.separator"));
			
			fw.write(flight.toString());
			fw2.write(flight.toString());
			
			fw.close();
			fw2.close();
        }
        catch (Exception e){
        	e.printStackTrace();
        }
	}
	
	public Admins(String name, String surname) {
		super(name, surname);
		// TODO Auto-generated constructor stub
	}
}
