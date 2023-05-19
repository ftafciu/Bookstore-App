package Model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

import items.MyDate;

public class Bill implements Serializable{
	
	private ArrayList<Books> books;
	private MyDate date;
	
	public Bill(ArrayList<Books> books, LocalDate dt) {
		this.books = books;
		this.date = new MyDate(dt.getDayOfMonth(), dt.getMonthValue(), dt.getYear());
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
			total += b.getQuantity() * b.getPrice();
		}
		return total;
	}

}
