package Model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ReadUser {
	
	private ArrayList<Person> users;
	private final File file;
	
	public ReadUser() {
		this.users = new ArrayList<>();
		this.file = new File("user.dat");
		if(!file.exists())
			Write();
		else
			Read();
	}
	
	public void Read() {
		
		try {
			FileInputStream in = new FileInputStream(file);
			ObjectInputStream inOb = new ObjectInputStream(in);
			users = (ArrayList<Person>)inOb.readObject();
			inOb.close();
			in.close();
		}catch(java.io.FileNotFoundException e) {
			System.out.println("File not found");
		}catch(IOException e) {
			System.out.println("Ndodh io exception");
		}catch(ClassNotFoundException e) {
			System.out.println("Not serializable class");
		}
		
	}
	
	public void Write() {
		
		try {
			FileOutputStream out = new FileOutputStream(file);
			ObjectOutputStream outOb = new ObjectOutputStream(out);
			outOb.writeObject(users);
			outOb.close();
			out.close();
		}catch(IOException e) {
			System.out.println("oh no");
		}
		
	}
	
	public void addUser(Person user) {
		users.add(user);
		Write();
	}
	
	public void deleteUser(String username) {
		users.remove(this.findUser(username));
		Write();
	}
	
	public void modifyUsername(Person person, String username) {
		users.get(users.indexOf(person)).setUsername(username);
		Write();
	}
	
	public void modifyPassword(Person person, String password) {
		users.get(users.indexOf(person)).setPassword(password);
		Write();
	}
	
	public void modifyName(Person person, String name) {
		users.get(users.indexOf(person)).setName(name);
		Write();
	}
	
	public void modifySurname(Person person, String surname) {
		users.get(users.indexOf(person)).setSurname(surname);
		Write();
	}
	
	public void modifySalary(Person person, double salary) {
		((Employee)users.get(users.indexOf(person))).setSalary(salary);
		Write();
	}
	
	public void modifyEmail(Person person, String email) {
		users.get(users.indexOf(person)).setEmail(email);
		Write();
	}
	
	public Person findUser(String username) {
		for(int i=0; i<users.size(); i++) {
			if(users.get(i).getUsername().equals(username)) {
				return users.get(i);
			}
		}
		return null;
	}
	
	public Person findUser(Person user) {
		for(int i=0; i<users.size(); i++) {
			if(users.get(i).equals(user)) {
				return users.get(i);
			}
		}
		return null;
	}
	
	public ArrayList<Person> primary(){
		return users;
	}


}
