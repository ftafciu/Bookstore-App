package Model;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class BooksRW {
	
		private final File fp;
		private ArrayList<Books>books;
		
		public BooksRW(){
			fp=new File("books.dat");
			books = new ArrayList<Books>();
			if(!fp.exists()){
				write();
			} else {
				books = readBooks();
			
			}
		}

		public ArrayList<Books> readBooks() {
			try {
				ObjectInputStream ois=new ObjectInputStream(new FileInputStream(fp));
				books = (ArrayList<Books>) ois.readObject();
				ois.close();
			} catch (FileNotFoundException e) {
				System.err.println("File not Found!!!");
			} catch (ClassNotFoundException e) {
				System.err.println("Class not Found!!!");
			} catch (IOException e) {
				System.err.println("File not accessable,FILE IS EMPTY!!!");
			}
			return books;
		}

		private void write() {
			try {
				ObjectOutputStream oos=new ObjectOutputStream( new FileOutputStream(fp));
				System.out.println("Working write2");
				if(books.isEmpty()) {
					System.out.println("Book is empty");
				}
				oos.writeObject(books);
				oos.close();
			} catch (FileNotFoundException e) {
				System.err.println("File not Found!!!");
			} catch (IOException e) {
				System.err.println("File not Writable!!!");
			}
		} 
		
		public void addBook(Books book) {
			books.add(book);
			write();
		}
		
		public void deleteBook(Books book) {
			books.remove(books.indexOf(book));
			write();
		}
		
		public void modifyTitle(String title, Books book) {
			books.get(books.indexOf(book)).setTitle(title);
			write();
		}
		
		public void modifyISBN(String ISBN, Books book) {
			books.get(books.indexOf(book)).setISBN(ISBN);
			write();
		}
		
		public void modifyAuthor(Author author, Books book) {
			books.get(books.indexOf(book)).setAuthor(author);
			write();
		}
		
		public void modifyCategory(String category, Books book) {
			books.get(books.indexOf(book)).setCategory(category);
			write();
		}
		
		public void modifyQuantity(int quantity, Books book) {
			books.get(books.indexOf(book)).changeQuantity(quantity);
			write();
		}
		
		public void modifyPrice(double price, Books book) {
			books.get(books.indexOf(book)).setPrice(price);
			write();
		}
		
		public ArrayList<Books> getBooks(){
			return books;
		}
		
		public Books findBook(String title) {
			
			for(Books book : books)
				if(book.getTitle().equals(title))
					return book;
			
			return null;
		}
		
		public ArrayList<String> getCategories(){
			ArrayList<String> temp = new ArrayList<>();
			File categories = new File("src/CategoryFile");
			try {
				Scanner in = new Scanner(categories);
				while(in.hasNext()) {
					temp.add(in.next());
				}
				in.close();
			}catch(java.io.FileNotFoundException e) {
				System.out.println("Couldnt read");
				return null;
			}
			
			return temp;
		}
		
		public void addCategory(String newCat) {
			String temp = "";
			try {
				Scanner in = new Scanner(new File("src/CategoryFile"));
				while(in.hasNext()) {
					temp += in.next() + "\n";
				}
				in.close();
				temp += newCat;
				PrintWriter write = new PrintWriter(new File("src/CategoryFile"));
				write.print(temp);
				write.close();
			}catch(java.io.FileNotFoundException e) {
				
			}
		}
}
