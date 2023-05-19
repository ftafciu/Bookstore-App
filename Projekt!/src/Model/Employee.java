package Model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;

public class Employee extends Person{
	
	private double salary;
	private File bills; 
	private ArrayList<Bill> issued;
	
	public Employee(String name, String surname, String username, String password, String email, LocalDate dt, String status, double salary) {
		super(name, surname, username, password, email, status, dt);
		this.salary = salary;
		if(status.equals("Librarian")) {
			bills = new File(this.getId() + ".dat");
			issued = new ArrayList<>();
			writeBills();
		}
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public String toString() {
		return this.getName() + " " + this.getSurname() + ", " + this.getStatus();
	}
	
	public void writeBills() {
		try {
			FileOutputStream out = new FileOutputStream(bills);
			ObjectOutputStream outOb = new ObjectOutputStream(out);
			outOb.writeObject(issued);
			outOb.close();
			out.close();
		}catch (FileNotFoundException e) {
			System.err.println("File not Found!!!");
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}
	
	public ArrayList<Bill> readBills(){
		try {
			FileInputStream in = new FileInputStream(bills);
			ObjectInputStream inOb = new ObjectInputStream(in);
			issued = (ArrayList<Bill>) inOb.readObject();
			in.close();
			inOb.close();
		}catch (FileNotFoundException e) {
			System.err.println("File not Found!!!");
		} catch (ClassNotFoundException e) {
			System.err.println("Class not Found!!!");
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
		
		return issued;
	}
	
	public void newBill(ArrayList<Books> booksOfBill, LocalDate dt) {
		issued.add(new Bill(booksOfBill, dt));
		writeBills();
	}

}
