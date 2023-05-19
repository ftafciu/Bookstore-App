package View;

import java.io.FileInputStream;

import Model.Admin;
import Model.ReadUser;
import javafx.geometry.Pos;

import javafx.scene.Cursor;

import javafx.scene.Scene;

import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;

import javafx.scene.control.PasswordField;

import javafx.scene.control.TextField;

import javafx.scene.image.Image;

import javafx.scene.image.ImageView;

import javafx.scene.layout.HBox;

import javafx.scene.layout.VBox;

import javafx.scene.paint.Color;

import javafx.scene.text.Font;

import javafx.scene.text.FontWeight;

import javafx.stage.Stage;

public class Register{

public void show(Stage primaryStage) {

Label text1 = new Label("Register");

text1.setFont(Font.font("Times New Roman", FontWeight.BOLD, 30));

VBox textPane = new VBox();

textPane.setStyle("-fx-background-color: #459062");

textPane.setAlignment(Pos.CENTER);

textPane.setPrefSize(500, 100);

textPane.getChildren().add(text1);



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

FileInputStream inputStream = null;

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


PasswordField passwordVerification = new PasswordField();

passwordVerification.setPromptText("Verify password");

passwordVerification.setAlignment(Pos.CENTER);

passwordVerification.setStyle("-fx-border-radius:15px");

passwordVerification.setStyle("-fx-background-radius:15px");

passwordVerification.setFocusTraversable(false);

passwordVerification.setPrefHeight(40);

passwordVerification.setMaxWidth(200);


try {

inputStream = new FileInputStream("src/key.png");

}

catch(Exception a) {

System.out.println("This should never happen but anyway");

}

Image key1 = new Image(inputStream);

ImageView keyIcon1 = new ImageView(key1);

keyIcon1.setFitHeight(20);

keyIcon1.setFitWidth(20);

HBox passwordVerificationBox = new HBox(15);

passwordVerificationBox.getChildren().addAll(passwordVerification, keyIcon1);

passwordVerificationBox.setAlignment(Pos.CENTER);

DatePicker birthday = new DatePicker();

birthday.setPromptText("Enter your birthday");

birthday.setFocusTraversable(false);

birthday.setPrefHeight(40);

birthday.setMaxWidth(200);


VBox fieldsPane = new VBox();

fieldsPane.setStyle("-fx-background-color: #459062");

fieldsPane.setSpacing(10);

fieldsPane.setPrefSize(500, 300);

fieldsPane.setAlignment(Pos.CENTER);


fieldsPane.getChildren().addAll(name, surname, birthday, email, usernameBox, passwordBox, passwordVerificationBox);


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
	if(!(name.getText().equals("") || surname.getText().equals("") || usernametf.getText().equals("") || passwordtf.getText().equals("") || email.getText().equals(""))) {
		ReadUser rw = new ReadUser();
		rw.addUser(new Admin(name.getText(), surname.getText(), usernametf.getText(), passwordtf.getText(), email.getText(), birthday.getValue()));
		(new Administrator((Admin)rw.findUser(usernametf.getText()))).show(primaryStage);
	}
});

VBox vbox = new VBox(10);

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