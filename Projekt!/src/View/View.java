package View;

import java.io.FileInputStream;

import Model.*;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
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

public class View {

	public void show(Stage primaryStage) {

		Label text1 = new Label("Welcome!");
		text1.setFont(Font.font("Times New Roman", FontWeight.BOLD, 30));
		text1.setTextFill(Color.WHITE);
		Label text2 = new Label("Log In");
		text2.setFont(Font.font("Times New Roman", FontWeight.BOLD, 30));
		VBox textPane = new VBox();
		textPane.setStyle("-fx-background-color: #459062");
		textPane.setAlignment(Pos.CENTER);
		textPane.setSpacing(4);
		textPane.setPrefSize(300, 100);
		textPane.getChildren().addAll(text1, text2);
		VBox vbox = new VBox();
		vbox.setAlignment(Pos.CENTER);
		vbox.setPrefSize(800, 500);

		VBox fieldsPane = new VBox();
		fieldsPane.setStyle("-fx-background-color: #459062");
		fieldsPane.setSpacing(4);
		fieldsPane.setPrefSize(300, 100);
		fieldsPane.setAlignment(Pos.CENTER);
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
		HBox usernameBox = new HBox();
		usernameBox.getChildren().addAll(userIcon, usernametf);
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
		HBox passwordBox = new HBox();
		passwordBox.getChildren().addAll(keyIcon, passwordtf);
		passwordBox.setAlignment(Pos.CENTER);
		
		
		fieldsPane.getChildren().addAll(usernameBox, passwordBox);
		
		Button logInbtn = new Button("Log In");
		logInbtn.setAlignment(Pos.CENTER);
		logInbtn.setPrefSize(140, 40);
		logInbtn.setTextFill(Color.GRAY);
		logInbtn.setFont(Font.font("Times New Roman", FontWeight.BOLD, 16));
		logInbtn.setStyle("-fx-border-radius:13px; -fx-background-radius:13px; -fx-background-color: white;");
		logInbtn.setOnMouseEntered(e->{
			logInbtn.setStyle("-fx-border-radius:13px; -fx-background-radius:13px; -fx-background-color: lightgrey;");
			logInbtn.setCursor(Cursor.HAND);
		});
		logInbtn.setOnMouseExited(e->{
			logInbtn.setStyle("-fx-border-radius:13px; -fx-background-radius:13px; -fx-background-color: white;");
		});
		logInbtn.setOnAction(e->{
			ReadUser rw = new ReadUser();
			Person random = rw.findUser(usernametf.getText());
			if(random == null) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setHeaderText("User does not exist");
				alert.setContentText("It seems that this user does not exist");
				alert.showAndWait();
			}else if(!random.getPassoword().equals(passwordtf.getText())){
				Alert alert = new Alert(AlertType.ERROR);
				alert.setHeaderText("Password mismatch");
				alert.setContentText("It seems that the password entered is incorrect!");
				alert.showAndWait();
			}else {
				if(random.getStatus().equals("Administrator"))
					(new Administrator((Admin)random)).show(primaryStage);
				else if(random.getStatus().equals("Librarian"))
					(new Librarian((Employee)random)).show(primaryStage);
				else
					(new Manager((Employee)random)).show(primaryStage);
			}
		});
		HBox registerBox = new HBox();
		registerBox.setSpacing(0);
		registerBox.setStyle("-fx-background-color: #459062");
		registerBox.setAlignment(Pos.CENTER);
		Label register = new Label("New user?");
		register.setStyle("-fx-background-color: #459062");
		register.setFont(Font.font("Times New Roman", FontWeight.BOLD, 15));
		register.setTextFill(Color.WHITE);
		Button registerBtn = new Button("Register");
		registerBtn.setStyle("-fx-background-color: #459062;");
		registerBtn.setTextFill(Color.WHITE);
		registerBtn.setOnMouseEntered(e->{
			registerBtn.setStyle("-fx-background-color: #459062; -fx-underline: true;");
			registerBtn.setCursor(Cursor.HAND);
		});
		registerBtn.setOnMouseExited(e->{
			registerBtn.setStyle("-fx-background-color: #459062; -fx-underline: false");
		});
		registerBtn.setOnAction(e->{
			(new Register()).show(primaryStage);
		});
		registerBox.getChildren().addAll(register, registerBtn);
		
		
		vbox.getChildren().addAll(textPane, fieldsPane, logInbtn, registerBox);
		
		
		try {

		inputStream = new FileInputStream("src/next.png");

		}catch(Exception a) {

		System.out.println("This should never happen but anyway");

		}

		Image button = new Image(inputStream);

		ImageView buttonIcon = new ImageView(button);

		buttonIcon.setFitHeight(20);
		buttonIcon.setFitWidth(20);
		
		logInbtn.setGraphic(buttonIcon);
		vbox.setStyle("-fx-background-color:#459062");
     	vbox.setSpacing(20);
     	Scene scene = new Scene(vbox, 800, 500);
     	primaryStage.setScene(scene);
     	primaryStage.setResizable(false);
     	primaryStage.setTitle("Log in");
     	primaryStage.show();
    	     	
     	
		
	}
}
