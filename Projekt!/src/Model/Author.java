package Model;

import java.util.ArrayList;

public class Author extends Person {
	//private ArrayList<Books> listOfBooks;

	public Author(String name, String surname) {
		super(name, surname);
	}
	
	public String toString() {
		return this.getName() + " " + this.getSurname();
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof Author && this.getName().equals(((Author)o).getName()) && this.getSurname().equals(((Author)o).getSurname()))
				return true;
		
		return false;
	}

	//TODO
//	public void addBook(Books book) {
//		listOfBooks.add(book);
//	}
//
//	public String printBooks() {
//		StringBuilder print = new StringBuilder();
//		print.append("Printing the list for author: " + this.getName());
//		print.append("\n-------------------------------------------\n");
//		for (int i = 0; i < listOfBooks.size(); i++) {
//			print.append(i + 1 + "." + listOfBooks.get(i));
//		}
//		print.append("---------------------------------------------\n");
//		return print.toString();
//	}
//
//	public void BookSuggestion() {
//		System.out.println("\n\nOur book suggestion for the author " + this.getName());
//		System.out.println(listOfBooks.get((int) Math.random() * listOfBooks.size()));
//	}
//
//	public int getBookIndex(Books book) {
//		return listOfBooks.indexOf(book);
//	}
//
//	public void replaceBook(Books book, int index) {
//		listOfBooks.add(index, book);
//	}

	
}
