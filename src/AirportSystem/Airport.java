package berk;

import java.util.ArrayList;

public class Airport {

	private String name;
	public ArrayList<Flight> flights = new ArrayList<Flight>();
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Airport(String name) {
		super();
		this.name = name;
	}
}
