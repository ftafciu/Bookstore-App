package Model;

import java.io.Serializable;
import java.util.Date;

public class Books implements Serializable, Cloneable {
	private Author author;
	private String bookTitle;
	private String ISBN, category;
	private double price;
	private double buyPrice;
	private int quantity;

	public Books(Author author, String bookTitle, String ISBN, String category, double price, double buyPrice) {
		this.author = author;
		this.bookTitle = bookTitle;
		this.ISBN = ISBN;
		this.category = category;
		this.price = price;
		this.buyPrice = buyPrice;
		this.quantity = 1;
	}

	public Author getAuthor() {
		return this.author;
	}
	
	public void setAuthor(Author author) {
		this.author = author;
	}
	
	public String getBookTitle() {
		return bookTitle;
	}

	public void updateTitle(String title) {
		bookTitle = title;
	}
	
	public String getISBN() {
		return this.ISBN;
	}
	
	public void setISBN(String ISBN) {
		this.ISBN = ISBN;
	}
	
	public String getCategory() {
		return this.category;
	}
	
	public void setCategory(String category) {
			this.category = category;
	}
	
	public double getPrice() {
		return this.price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}

	public String toString() {
		return "Book Title: " + bookTitle + "\n-----------------------" + "\nOther details about this book:"
				+ "\n- ISBN: " + ISBN  + "\n- Author: " + author.getName() + "\n";
	}
	
	public double getBuyPrice() {
		return buyPrice;
	}
	
	public void setBuyPrice(double buyPrice) {
		this.buyPrice = buyPrice;
	}
	
	public void changeQuantity(int number) {
		this.quantity += number;
	}
	
	public int getQuantity() {
		return this.quantity;
	}
	
	public String getTitle() {
		return this.bookTitle;
	}
	
	public void setTitle(String title) {
		this.bookTitle = title;
	}
	
	@Override
	public boolean equals(Object o) {
		
		if(o instanceof Books && this.getISBN().equals(((Books)o).getISBN()))
				return true;
		
		return false;
	}
	
	public Object clone() {
		try {
			Books temp = (Books)super.clone();
			return temp;
		}catch(CloneNotSupportedException e) {
			return null;
		}
	}

}
