package berk;

public class Flight {

	private Airport startingAirport;
	private Airport arrivalAirport;
	private int month;
	private int year;
	private int day;
	
	public Airport getStartingAirport() {
		return startingAirport;
	}
	public void setStartingAirport(Airport startingAirport) {
		this.startingAirport = startingAirport;
	}
	public Airport getArrivalAirport() {
		return arrivalAirport;
	}
	public void setArrivalAirport(Airport arrivalAirport) {
		this.arrivalAirport = arrivalAirport;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}	
	
	@Override
	public String toString() {	
		return "From: "+startingAirport.getName()+" to: "+arrivalAirport.getName()
					+" Day: "+day+" Month: "+month+" Year: "+year+"\n";
	}

	public Flight(Airport startingAirport, Airport arrivalAirport, int day, int month, int year) {
		super();
		this.startingAirport = startingAirport;
		this.arrivalAirport = arrivalAirport;
		this.month = month;
		this.year = year;
		this.day = day;
	}
}
