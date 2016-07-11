package domain;

import enumeration.TicketClass;

public abstract class Customer {

	private int id;
	private String name;
	private TicketClass ticketClass;
	
	
	public Customer(int id, String name, TicketClass ticketClass) {
		this.id = id;
		this.name = name;
		this.ticketClass = ticketClass;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public TicketClass getTicketClass() {
		return ticketClass;
	}


	public void setTicketClass(TicketClass ticketClass) {
		this.ticketClass = ticketClass;
	}
	

	

	
	
	
	
	
}
