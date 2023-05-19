package View;

import java.io.FileInputStream;
import java.io.Serializable;

import Model.Admin;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Administrator implements Serializable{
	
	private Admin admin;
	
	public Administrator(Admin admin) {
		this.admin = admin;
	}
	
	public void show(Stage primaryStage) {
		
		Label hiName = new Label("Hi " + admin.getName());
		hiName.setStyle("-fx-background-color:#459062");
		hiName.setAlignment(Pos.BASELINE_CENTER);
		hiName.setPrefHeight(100);
		hiName.setPrefWidth(800);
		hiName.setFont(Font.font("Times New Roman", FontWeight.BOLD, 50));
		
		HBox userBox = new HBox();
		userBox.setStyle("-fx-background-color:#459062");
		
		FileInputStream inputStream = null;
		
		Button logOutbtn = new Button();
		try {
			inputStream = new FileInputStream("src/log-out.png");
		}
		catch( Exception e) {
			System.out.println("This should never happen but anyway");
		}
		
		Image logOutImg = new Image(inputStream);
		ImageView logOutIcon = new ImageView(logOutImg);
		logOutIcon.setFitHeight(30);
		logOutIcon.setFitWidth(30);
		logOutbtn.setGraphic(logOutIcon);
		logOutbtn.setStyle("-fx-border-radius:13px; -fx-background-radius:13px; -fx-background-color:#459062 ;");
		logOutbtn.setCursor(Cursor.HAND);
		logOutbtn.setOnMouseEntered(e->{
			logOutbtn.setStyle("-fx-border-radius:13px; -fx-background-radius:13px; -fx-background-color: lightgreen;");
			logOutbtn.setCursor(Cursor.HAND);
		});
		logOutbtn.setOnMouseExited(e->{
			logOutbtn.setStyle("-fx-border-radius:13px; -fx-background-radius:13px; -fx-background-color:#459062 ;");
		});
		logOutbtn.setOnAction(e->{
			(new View()).show(primaryStage);
		});
		logOutbtn.setGraphic(logOutIcon);
		
		userBox.getChildren().addAll(hiName, logOutbtn);
		userBox.setSpacing(10);
		
		
		Button createUserbtn = new Button();
		createUserbtn.setPrefSize(100, 100);
			try {
			inputStream = new FileInputStream("src/page.png");
		}
		catch( Exception e) {
			System.out.println("This should never happen but anyway");
		}
		Image createUserImg = new Image(inputStream);
		ImageView createUserIcon = new ImageView(createUserImg);
		createUserIcon.setFitHeight(100);
		createUserIcon.setFitWidth(100);
		createUserbtn.setGraphic(createUserIcon);
		createUserbtn.setStyle("-fx-border-radius:13px; -fx-background-radius:13px; -fx-background-color:#459062;");
		createUserbtn.setCursor(Cursor.HAND);
		createUserbtn.setOnMouseEntered(e->{
			createUserbtn.setStyle("-fx-border-radius:13px; -fx-background-radius:13px; -fx-background-color: lightgreen;");
			createUserbtn.setCursor(Cursor.HAND);
		});
		createUserbtn.setOnMouseExited(e->{
			createUserbtn.setStyle("-fx-border-radius:13px; -fx-background-radius:13px; -fx-background-color:#459062;");
		});
		createUserbtn.setOnAction(e->{
			(new CreateUser(admin)).show(primaryStage);
		});
		createUserbtn.setGraphic(createUserIcon);
		
		Label createUser = new Label("Create User");
		createUser.setFont(Font.font("Times New Roman", FontWeight.BOLD, 20));
		createUser.setAlignment(Pos.BASELINE_CENTER);
		VBox userVbox = new VBox();
		userVbox.getChildren().addAll(createUserbtn, createUser);
		
		
		Button editUserBtn = new Button();
		editUserBtn.setPrefSize(100, 100);
		editUserBtn.setStyle("-fx-border-radius:13px; -fx-background-radius:13px; -fx-background-color: #459062;");
		editUserBtn.setCursor(Cursor.HAND);
		editUserBtn.setOnMouseEntered(e->{
			editUserBtn.setStyle("-fx-border-radius:13px; -fx-background-radius:13px; -fx-background-color: lightgreen;");
			editUserBtn.setCursor(Cursor.HAND);
		});
		editUserBtn.setOnMouseExited(e->{
			editUserBtn.setStyle("-fx-border-radius:13px; -fx-background-radius:13px; -fx-background-color:#459062;");
		});
		
		try {
			
			inputStream = new FileInputStream("src/edit.png");
		}
		catch( Exception e) {
			System.out.println("This should never happen but anyway");
		}
		Image editImg = new Image(inputStream);
		ImageView editIcon = new ImageView(editImg);
		editIcon.setFitHeight(100);
		editIcon.setFitWidth(100);
		editUserBtn.setGraphic(editIcon);
		
		Label edit = new Label("Edit User");
		edit.setFont(Font.font("Times New Roman", FontWeight.BOLD, 30));
		edit.setAlignment(Pos.BASELINE_CENTER);
		
		VBox editUserVbox = new VBox();
		editUserVbox.getChildren().addAll(editUserBtn, edit);

		
		Button UserstatisticBtn = new Button();
		UserstatisticBtn.setPrefSize(100, 100);
		UserstatisticBtn.setStyle("-fx-border-radius:13px; -fx-background-radius:13px; -fx-background-color: #459062;");
		UserstatisticBtn.setCursor(Cursor.HAND);
		UserstatisticBtn.setOnMouseEntered(e->{
			UserstatisticBtn.setStyle("-fx-border-radius:13px; -fx-background-radius:13px; -fx-background-color: lightgreen;");
			UserstatisticBtn.setCursor(Cursor.HAND);
		});
		UserstatisticBtn.setOnMouseExited(e->{
			UserstatisticBtn.setStyle("-fx-border-radius:13px; -fx-background-radius:13px; -fx-background-color:#459062;");
		});
		UserstatisticBtn.setOnAction(e->{
			(new Users(admin)).show(primaryStage);
		});
		
		try {
			
			inputStream = new FileInputStream("src/statistics.png");
		}
		catch( Exception e) {
			System.out.println("This should never happen but anyway");
		}
		Image UserstatisticImg = new Image(inputStream);
		ImageView UserstatisticIcon = new ImageView(UserstatisticImg);
		UserstatisticIcon.setFitHeight(100);
		UserstatisticIcon.setFitWidth(100);
		UserstatisticBtn.setGraphic(UserstatisticIcon);
		
		Label statistic = new Label("Users");
		statistic.setFont(Font.font("Times New Roman", FontWeight.BOLD, 25));
		statistic.setAlignment(Pos.BASELINE_CENTER);
		
		VBox UserstatisticVbox = new VBox();
		UserstatisticVbox.getChildren().addAll(UserstatisticBtn, statistic);

		
		Button financialStatisticsbtn = new Button();
		financialStatisticsbtn.setPrefSize(100, 100);
		financialStatisticsbtn.setStyle("-fx-border-radius:13px; -fx-background-radius:13px; -fx-background-color: #459062;");
		financialStatisticsbtn.setCursor(Cursor.HAND);
		financialStatisticsbtn.setOnMouseEntered(e->{
			financialStatisticsbtn.setStyle("-fx-border-radius:13px; -fx-background-radius:13px; -fx-background-color: lightgreen;");
			financialStatisticsbtn.setCursor(Cursor.HAND);
		});
		financialStatisticsbtn.setOnMouseExited(e->{
			financialStatisticsbtn.setStyle("-fx-border-radius:13px; -fx-background-radius:13px; -fx-background-color:#459062;");
		});
		
		try {
			inputStream = new FileInputStream("src/business-report.png");
		}
		catch( Exception e) {
			System.out.println("This should never happen but anyway");
		}
		Image financialImg = new Image(inputStream);
		ImageView financialIcon = new ImageView(financialImg);
		financialIcon.setFitHeight(100);
		financialIcon.setFitWidth(100);
		financialStatisticsbtn.setGraphic(financialIcon);
		
		Label financial = new Label("Financial Statistics");
		financial .setFont(Font.font("Times New Roman", FontWeight.BOLD, 30));
		financial.setAlignment(Pos.BASELINE_CENTER);
		
		VBox financialVbox = new VBox();
		financialVbox.getChildren().addAll(financialStatisticsbtn, financial);
		
		Label ads = new Label("Your library app");
		ads.setStyle("-fx-background-color:#459062");
		ads.setAlignment(Pos.BASELINE_LEFT);
		ads.setPrefHeight(50);
		ads.setPrefWidth(300);
		ads.setFont(Font.font("Times New Roman", FontWeight.BOLD, 30));
		HBox userbox = new HBox();
		userBox.setAlignment(Pos.CENTER);
		userbox.setPadding(new Insets(10, 0, 0, 70));
		userbox.getChildren().addAll(userVbox, ads);
		userbox.setSpacing(270);
		
		HBox statisticBox = new HBox();
		statisticBox.setPadding(new Insets(10, 0, 0, 70));
		statisticBox.getChildren().addAll(UserstatisticVbox, financialVbox);
		statisticBox.setSpacing(270);
		
		
		Label note = new Label("Leave yourself a note");
		note.setStyle("-fx-background-color:#459062");
		note.setAlignment(Pos.BASELINE_LEFT);
		note.setPrefHeight(50);
		note.setPrefWidth(800);
		note.setFont(Font.font("Times New Roman", FontWeight.BOLD, 30));
		
		try {
			inputStream = new FileInputStream("src/notes.png");
		}
		catch( Exception e) {
			System.out.println("This should never happen but anyway");
		}
		Image notesImg = new Image(inputStream);
		ImageView notesIcon = new ImageView(notesImg);
		notesIcon.setFitHeight(50);
		notesIcon.setFitWidth(50);
		HBox noteBox = new HBox();
		noteBox.getChildren().addAll(notesIcon, note);
		noteBox.setStyle("-fx-background-color:#459062");
		noteBox.setPadding(new Insets(0, 0, 0, 10));
		
		TextArea textArea = new TextArea();
		textArea.setStyle("-fx-border-color: black; -fx-border-width:10");
		

		VBox vbox = new VBox();
		vbox.getChildren().addAll(userBox, userbox, statisticBox, noteBox, textArea);
		
		Scene scene = new Scene(vbox, 800, 500);
		primaryStage.setScene(scene);
	 	primaryStage.setResizable(false);
	 	primaryStage.setTitle("Administrator");
	 	primaryStage.show();
	 	
	}
}
