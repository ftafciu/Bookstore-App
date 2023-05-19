package Model;

import java.time.LocalDate;

public class Admin extends Person{

	public Admin(String name, String surname, String username, String password, String email, LocalDate dt) {
		super(name, surname, username, password, email, "Administrator", dt);
	}
	
	public String toString() {
		return this.getName() + " " + this.getSurname() + ", Administrator";
	}
	
}
