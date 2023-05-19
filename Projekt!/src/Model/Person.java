package Model;

import java.io.Serializable;
import java.time.LocalDate;

import items.MyDate;

public abstract class Person implements Serializable{
	private String name, surname, username, password, email, status;
	private MyDate birthday;
	private int id;
	private static int total = 0;

	public Person(String name, String surname) {
		this.name = name;
		this.surname = surname;
	}
	
	public Person(String name, String surname, String username, String password, String email, String status, LocalDate dt) {
		setName(name);
		setSurname(surname);
		setUsername(username);
		setPassword(password);
		setEmail(email);
		this.status = status;
		this.birthday = new MyDate(dt.getDayOfMonth(), dt.getMonthValue(), dt.getYear());
		this.id = total;
		total++;
		
	}


	public String getName() {
		return name;
	}
	
	public String getSurname() {
		return surname;
	}

	public String getUsername() {
		return username;
	}

	public String getPassoword() {
		return password;
	}

	public String getEmail() {
		return email;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void setSurname(String surname) {
		this.surname = surname;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public boolean equals(Object o) {
		 if (o instanceof Person)
		 return username.equals(((Person)o).getUsername());
		 else
		 return false;
	}

	public abstract String toString();
	
	public int getId() {
		return id;
	}
}
