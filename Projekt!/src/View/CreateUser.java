package View;

import java.io.FileInputStream;

import Model.Admin;
import Model.Employee;
import Model.ReadUser;
import javafx.collections.FXCollections;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class CreateUser {

	private Admin admin;
	
	public CreateUser(Admin admin) {
		this.admin = admin;
	}
	
public void show(Stage primaryStage) {


Label text1 = new Label("Create User");

text1.setFont(Font.font("Times New Roman", FontWeight.BOLD, 30));

HBox textPane = new HBox();

textPane.setSpacing(270);

textPane.setStyle("-fx-background-color: #459062");

textPane.setPrefSize(500, 100);


Button backBtn = new Button();

FileInputStream inputStream = null;

try {

inputStream = new FileInputStream("src/back-button.png");

}

catch( Exception e) {

System.out.println("This should never happen but anyway");

}


Image backImg = new Image(inputStream);

ImageView backIcon = new ImageView(backImg);

backIcon.setFitHeight(30);

backIcon.setFitWidth(30);

backBtn.setGraphic(backIcon);

backBtn.setStyle("-fx-border-radius:13px; -fx-background-radius:13px; -fx-background-color:#459062 ;");

backBtn.setCursor(Cursor.HAND);

backBtn.setOnMouseEntered(e->{

backBtn.setStyle("-fx-border-radius:13px; -fx-background-radius:13px; -fx-background-color: lightgreen;");

backBtn.setCursor(Cursor.HAND);

});

backBtn.setOnMouseExited(e->{

backBtn.setStyle("-fx-border-radius:13px; -fx-background-radius:13px; -fx-background-color:#459062 ;");

});
backBtn.setOnAction(e->{
	(new Administrator(admin)).show(primaryStage);
});

backBtn.setGraphic(backIcon);


textPane.getChildren().addAll(backBtn, text1);


String status[] = {"Librarian", "Manager"};

ComboBox<String> comboBox = new ComboBox<>(FXCollections.observableArrayList(status));

comboBox.setPromptText("Status");

comboBox.setStyle("-fx-border-radius:13px; -fx-background-radius:13px; -fx-background-color: white;");

comboBox.setPrefSize(200, 40);



TextField name = new TextField();

name.setPromptText("Enter your name");

name.setAlignment(Pos.CENTER);

name.setStyle("-fx-border-radius:15px");

name.setStyle("-fx-background-radius:15px");

name.setFocusTraversable(false);

name.setPrefHeight(40);

name.setMaxWidth(200);


TextField surname = new TextField();

surname.setPromptText("Enter your surname");

surname.setAlignment(Pos.CENTER);

surname.setStyle("-fx-border-radius:15px");

surname.setStyle("-fx-background-radius:15px");

surname.setFocusTraversable(false);

surname.setPrefHeight(40);

surname.setMaxWidth(200);


DatePicker birthday = new DatePicker();

birthday.setPromptText("Enter your birthday");

birthday.setFocusTraversable(false);

birthday.setPrefHeight(40);

birthday.setMaxWidth(200);


TextField email = new TextField();

email.setPromptText("Enter your email");

email.setAlignment(Pos.CENTER);

email.setStyle("-fx-border-radius:15px");

email.setStyle("-fx-background-radius:15px");

email.setFocusTraversable(false);

email.setPrefHeight(40);

email.setMaxWidth(200);



TextField usernametf = new TextField();

usernametf.setPromptText("Enter username");

usernametf.setAlignment(Pos.CENTER);

usernametf.setStyle("-fx-border-radius:15px");

usernametf.setStyle("-fx-background-radius:15px");

usernametf.setFocusTraversable(false);

usernametf.setPrefHeight(40);

usernametf.setMaxWidth(200);

try {

inputStream = new FileInputStream("src/user.png");

}catch(Exception a) {

System.out.println("This should never happen but anyway");

}

Image user = new Image(inputStream);

ImageView userIcon = new ImageView(user);

userIcon.setFitHeight(20);

userIcon.setFitWidth(20);

HBox usernameBox = new HBox(15);

usernameBox.getChildren().addAll( usernametf, userIcon);

usernameBox.setAlignment(Pos.CENTER);


PasswordField passwordtf = new PasswordField();

passwordtf.setPromptText("Enter password");

passwordtf.setAlignment(Pos.CENTER);

passwordtf.setStyle("-fx-border-radius:15px");

passwordtf.setStyle("-fx-background-radius:15px");

passwordtf.setFocusTraversable(false);

passwordtf.setPrefHeight(40);

passwordtf.setMaxWidth(200);


try {

inputStream = new FileInputStream("src/key.png");

}

catch(Exception a) {

System.out.println("This should never happen but anyway");

}

Image key = new Image(inputStream);

ImageView keyIcon = new ImageView(key);

keyIcon.setFitHeight(20);

keyIcon.setFitWidth(20);

HBox passwordBox = new HBox(15);

passwordBox.getChildren().addAll(passwordtf, keyIcon);

passwordBox.setAlignment(Pos.CENTER);


TextField salary = new TextField();
salary.setPromptText("Salary");
salary.setAlignment(Pos.CENTER);

salary.setStyle("-fx-border-radius:15px");

salary.setStyle("-fx-background-radius:15px");

salary.setFocusTraversable(false);

salary.setPrefHeight(40);

salary.setMaxWidth(200);

VBox fieldsPane = new VBox();

fieldsPane.setStyle("-fx-background-color: #459062");

fieldsPane.setSpacing(10);

fieldsPane.setPrefSize(500, 300);

fieldsPane.setAlignment(Pos.CENTER);


fieldsPane.getChildren().addAll(name, surname, comboBox, birthday, email, usernameBox, passwordBox, salary);


Button Registerbtn = new Button("Register");

Registerbtn.setAlignment(Pos.CENTER);

Registerbtn.setPrefSize(140, 40);

Registerbtn.setTextFill(Color.GRAY);

Registerbtn.setFont(Font.font("Times New Roman", FontWeight.BOLD, 16));

Registerbtn.setStyle("-fx-border-radius:13px; -fx-background-radius:13px; -fx-background-color: white;");

Registerbtn.setOnMouseEntered(e->{

Registerbtn.setStyle("-fx-border-radius:13px; -fx-background-radius:13px; -fx-background-color: lightgrey;");

Registerbtn.setCursor(Cursor.HAND);

});

Registerbtn.setOnMouseExited(e->{

Registerbtn.setStyle("-fx-border-radius:13px; -fx-background-radius:13px; -fx-background-color: white;");

});

Registerbtn.setOnAction(e->{
	if(!(name.getText().equals("") || surname.getText().equals("") || comboBox.getValue().equals("Status") || email.getText().equals("") || usernametf.getText().equals("") || 
			passwordtf.getText().equals(""))){
	ReadUser ru = new ReadUser();
	try {
		double salaryV = Double.parseDouble(salary.getText());
		ru.addUser(new Employee(name.getText(), surname.getText(), usernametf.getText(), passwordtf.getText(), email.getText(), birthday.getValue() ,comboBox.getValue(), salaryV));
	}catch (NumberFormatException e1) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setHeaderText("Invalid value");
		alert.setContentText("Please enter only numbers in the salary data field");
		alert.showAndWait();
	}

}else {
	Alert alert = new Alert(AlertType.ERROR);
	alert.setHeaderText("Blank fields!!");
	alert.setContentText("Please fill all the fields");
	alert.showAndWait();
}
});



VBox vbox = new VBox(5);

vbox.setAlignment(Pos.CENTER);

vbox.setPrefSize(800, 500);

vbox.getChildren().addAll(textPane, fieldsPane, Registerbtn);

vbox.setStyle("-fx-background-color: #459062");


Scene scene = new Scene(vbox, 800, 500);

primaryStage.setScene(scene);

primaryStage.setResizable(false);

primaryStage.setTitle("Register");

primaryStage.show();


}

}
