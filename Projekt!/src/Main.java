
import java.time.LocalDate;

import Model.Employee;
import View.*;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application{

	public static void main(String [] args) {
		Application.launch(args);
	}
	
	public void start(Stage primaryStage) {
		
		//(new Manager(new Employee("Random", "Random", "Random", "Random", "Random", LocalDate.now(), "Manager", 1000))).show(primaryStage);
		(new View()).show(primaryStage);
	}
	
}
