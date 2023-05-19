package Model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class InOutControl {
	
	private ArrayList<SaleInOut> transactions;
	private final File file;
	
	public InOutControl() {
		file = new File("transactions.dat");
		transactions = new ArrayList<>();
		if(!file.exists())
			write();
		else 
			read();
	}
	
	public void write() {
		try {
			ObjectOutputStream oos=new ObjectOutputStream( new FileOutputStream(file));
			System.out.println("Working write2");
			oos.writeObject(transactions);
			oos.close();
		} catch (FileNotFoundException e) {
			System.err.println("File not Found!!!");
		} catch (IOException e) {
			System.err.println("File not Writable!!!");
		}
	}
	
	public void read() {
		try {
			ObjectInputStream ois=new ObjectInputStream(new FileInputStream(file));
			transactions = (ArrayList<SaleInOut>) ois.readObject();
			ois.close();
		} catch (FileNotFoundException e) {
			System.err.println("File not Found!!!");
		} catch (ClassNotFoundException e) {
			System.err.println("Class not Found!!!");
		} catch (IOException e) {
			System.err.println("File not accessable,FILE IS EMPTY!!!");
		}
	}
	
	public void add(SaleInOut temp) {
		transactions.add(temp);
		write();
	}
	
	public ArrayList<SaleInOut> getTransactions(){
		return transactions;
	}
	

}
