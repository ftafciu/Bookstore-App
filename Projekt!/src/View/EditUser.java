package View;

import java.io.FileInputStream;

import java.time.LocalDate;

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

public class EditUser {

	private Employee edited;
	private Admin admin;
	
	public EditUser(Admin admin, Employee edited) {
		this.admin = admin;
		this.edited = edited;
	}


public void show(Stage primaryStage) {


Label text1 = new Label("Edit User");

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
	(new Users(admin)).show(primaryStage);
});

backBtn.setGraphic(backIcon);


textPane.getChildren().addAll(backBtn, text1);


String status[] = {"Librarian", "Manager"};

ComboBox<String> comboBox = new ComboBox<>(FXCollections.observableArrayList(status));

comboBox.setPromptText(edited.getStatus());

comboBox.setStyle("-fx-border-radius:13px; -fx-background-radius:13px; -fx-background-color: white;");

comboBox.setPrefSize(200, 40);




TextField name = new TextField();

name.setAlignment(Pos.CENTER);

name.setStyle("-fx-border-radius:15px");

name.setStyle("-fx-background-radius:15px");

name.setFocusTraversable(false);

name.setPrefHeight(40);

name.setMaxWidth(200);

name.setText(edited.getName());


TextField surname = new TextField();

surname.setAlignment(Pos.CENTER);

surname.setStyle("-fx-border-radius:15px");

surname.setStyle("-fx-background-radius:15px");

surname.setFocusTraversable(false);

surname.setPrefHeight(40);

surname.setMaxWidth(200);

surname.setText(edited.getSurname());


DatePicker birthday = new DatePicker();

birthday.setFocusTraversable(false);

birthday.setPrefHeight(40);

birthday.setMaxWidth(200);


TextField email = new TextField();

email.setAlignment(Pos.CENTER);

email.setStyle("-fx-border-radius:15px");

email.setStyle("-fx-background-radius:15px");

email.setFocusTraversable(false);

email.setPrefHeight(40);

email.setMaxWidth(200);

email.setText(edited.getEmail());


TextField usernametf = new TextField();

usernametf.setAlignment(Pos.CENTER);

usernametf.setStyle("-fx-border-radius:15px");

usernametf.setStyle("-fx-background-radius:15px");

usernametf.setFocusTraversable(false);

usernametf.setPrefHeight(40);

usernametf.setMaxWidth(200);

usernametf.setText(edited.getUsername());


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
TextField salary = new TextField();
salary.setPromptText("Salary");
salary.setAlignment(Pos.CENTER);

salary.setStyle("-fx-border-radius:15px");

salary.setStyle("-fx-background-radius:15px");

salary.setFocusTraversable(false);

salary.setPrefHeight(40);

salary.setMaxWidth(200);
salary.setText(edited.getSalary() + "");

VBox fieldsPane = new VBox();

fieldsPane.setStyle("-fx-background-color: #459062");

fieldsPane.setSpacing(10);

fieldsPane.setPrefSize(500, 300);

fieldsPane.setAlignment(Pos.CENTER);


fieldsPane.getChildren().addAll(name, surname, comboBox, birthday, email, usernameBox, salary);


Button Savebtn = new Button("Save");

Savebtn.setAlignment(Pos.CENTER);

Savebtn.setPrefSize(140, 40);

Savebtn.setTextFill(Color.GRAY);

Savebtn.setFont(Font.font("Times New Roman", FontWeight.BOLD, 16));

Savebtn.setStyle("-fx-border-radius:13px; -fx-background-radius:13px; -fx-background-color: white;");

Savebtn.setOnMouseEntered(e->{

Savebtn.setStyle("-fx-border-radius:13px; -fx-background-radius:13px; -fx-background-color: lightgrey;");

Savebtn.setCursor(Cursor.HAND);

});

Savebtn.setOnMouseExited(e->{

Savebtn.setStyle("-fx-border-radius:13px; -fx-background-radius:13px; -fx-background-color: white;");

});
Savebtn.setOnAction(e->{
	if(!(name.getText().equals("") || surname.getText().equals("") || email.getText().equals("") || usernametf.getText().equals(""))){
	ReadUser ru = new ReadUser();
	try {
		double salaryV = Double.parseDouble(salary.getText());
		ru.modifyName(edited, name.getText());
		ru.modifySurname(edited, surname.getText());
		ru.modifyUsername(edited, usernametf.getText());
		ru.modifyEmail(edited, email.getText());
		ru.modifySalary(edited, salaryV);
		(new Users(admin)).show(primaryStage);
	}catch (NumberFormatException e1) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setHeaderText("Invalid value");
		alert.setContentText("Please enter only numbers in the salary data field");
		alert.showAndWait();
	}
}});


HBox buttons = new HBox();

buttons.getChildren().addAll(Savebtn);

buttons.setSpacing(10);

buttons.setAlignment(Pos.BASELINE_CENTER);


VBox vbox = new VBox(5);

vbox.setAlignment(Pos.CENTER);

vbox.setPrefSize(800, 500);

vbox.getChildren().addAll(textPane, fieldsPane, buttons);

vbox.setStyle("-fx-background-color: #459062");


Scene scene = new Scene(vbox, 800, 500);

primaryStage.setScene(scene);

primaryStage.setResizable(false);

primaryStage.setTitle("Edit Users");

primaryStage.show();


}

}