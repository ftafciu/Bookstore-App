package items;

import java.io.Serializable;

public class MyDate implements Comparable<MyDate>, Serializable{

	private int day;
	private int month;
	private int year;
	
	public MyDate(int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
	public String toString() {
		return day + "/" + month + "/" + year;
	}
	
	@Override 
	public int compareTo(MyDate d) {
		
		if(this.year < d.getYear())
			return -1;
		else if(this.year > d.getYear())
			return 1;
		else {
			if(this.month < d.getMonth())
				return -1;
			else if(this.month > d.getMonth())
				return 1;
			else {
				if(this.day < d.getDay())
					return -1;
				else if(this.day > d.getDay())
					return 1;
			}
		}
		
		
		return 0;
	}
	
}
