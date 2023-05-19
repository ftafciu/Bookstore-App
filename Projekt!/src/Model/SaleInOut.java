package Model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

import items.MyDate;

public class SaleInOut implements Serializable{
	
	private ArrayList<Books> books;
	private boolean outgoing;
	private MyDate date;
	
	public SaleInOut(ArrayList<Books> books, LocalDate dt, boolean outgoing) {
		this.books = books;
		this.date = new MyDate(dt.getDayOfMonth(), dt.getMonthValue(), dt.getYear());
		this.outgoing = outgoing;
	}
	
	public boolean isOut() {
		return outgoing;
	}
	
	public MyDate getDate() {
		return date;
	}
	
	public ArrayList<Books> getBooks(){
		return books;
	}

	public double getTotal() {
		double total = 0;
		for(Books b:books) {
			if(outgoing)
				total += b.getQuantity() * b.getPrice();
			else 
				total -= b.getQuantity() * b.getPrice();
		}
		return total;
	}
}
