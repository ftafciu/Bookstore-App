package View;

import java.io.FileInputStream;

import Model.Employee;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
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
import javafx.scene.control.Alert.AlertType;

public class Manager {
	
	private Employee man;
	
	public Manager(Employee man) {
		this.man = man;
	}
	
	public void show(Stage primaryStage) {
		
		Label hiName = new Label("Hi " + man.getName());
		hiName.setStyle("-fx-background-color:#459062");
		hiName.setAlignment(Pos.BASELINE_CENTER);
		hiName.setPrefHeight(100);
		hiName.setPrefWidth(800);
		hiName.setFont(Font.font("Times New Roman", FontWeight.BOLD, 30));
		
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
		
		Button bookBtn = new Button();
		bookBtn.setPrefSize(100, 100);
			try {
			inputStream = new FileInputStream("src/book.png");
		}
		catch( Exception e) {
			System.out.println("This should never happen but anyway");
		}
		Image bookImg = new Image(inputStream);
		ImageView bookIcon = new ImageView(bookImg);
		bookIcon.setFitHeight(100);
		bookIcon.setFitWidth(100);
		bookBtn.setGraphic(bookIcon);
		bookBtn.setStyle("-fx-border-radius:13px; -fx-background-radius:13px; -fx-background-color:#459062;");
		bookBtn.setCursor(Cursor.HAND);
		bookBtn.setOnMouseEntered(e->{
			bookBtn.setStyle("-fx-border-radius:13px; -fx-background-radius:13px; -fx-background-color: lightgreen;");
			bookBtn.setCursor(Cursor.HAND);
		});
		bookBtn.setOnMouseExited(e->{
			bookBtn.setStyle("-fx-border-radius:13px; -fx-background-radius:13px; -fx-background-color:#459062;");
		});
		bookBtn.setOnAction(e->{
			(new Stock(man)).show(primaryStage);
		});
		bookBtn.setGraphic(bookIcon);
		
		Label book = new Label("Book Stock");
		book.setFont(Font.font("Times New Roman", FontWeight.BOLD, 25));
		book.setAlignment(Pos.BASELINE_CENTER);
		VBox bookVbox = new VBox();
		bookVbox.getChildren().addAll(bookBtn, book);
		
		
		Button statisticBtn = new Button();
		statisticBtn.setPrefSize(100, 100);
		statisticBtn.setStyle("-fx-border-radius:13px; -fx-background-radius:13px; -fx-background-color: #459062;");
		statisticBtn.setCursor(Cursor.HAND);
		statisticBtn.setOnMouseEntered(e->{
			statisticBtn.setStyle("-fx-border-radius:13px; -fx-background-radius:13px; -fx-background-color: lightgreen;");
			statisticBtn.setCursor(Cursor.HAND);
		});
		statisticBtn.setOnMouseExited(e->{
			statisticBtn.setStyle("-fx-border-radius:13px; -fx-background-radius:13px; -fx-background-color:#459062;");
		});
		
		try {
			
			inputStream = new FileInputStream("src/statistical.png");
		}
		catch( Exception e) {
			System.out.println("This should never happen but anyway");
		}
		Image statisticImg = new Image(inputStream);
		ImageView statisticIcon = new ImageView(statisticImg);
		statisticIcon.setFitHeight(100);
		statisticIcon.setFitWidth(100);
		statisticBtn.setGraphic(statisticIcon);
		
		Label statistic = new Label("Book statistic");
		statistic.setFont(Font.font("Times New Roman", FontWeight.BOLD, 25));
		statistic.setAlignment(Pos.BASELINE_CENTER);
		
		VBox statisticVbox = new VBox();
		statisticVbox.getChildren().addAll(statisticBtn, statistic);

		
		
		Button performancebtn = new Button();
		performancebtn.setPrefSize(100, 100);
		performancebtn.setStyle("-fx-border-radius:13px; -fx-background-radius:13px; -fx-background-color: #459062;");
		performancebtn.setCursor(Cursor.HAND);
		performancebtn.setOnMouseEntered(e->{
			performancebtn.setStyle("-fx-border-radius:13px; -fx-background-radius:13px; -fx-background-color: lightgreen;");
			performancebtn.setCursor(Cursor.HAND);
		});
		performancebtn.setOnMouseExited(e->{
			performancebtn.setStyle("-fx-border-radius:13px; -fx-background-radius:13px; -fx-background-color:#459062;");
		});
		performancebtn.setOnAction(e->{
			(new Libs(man)).show(primaryStage);
		});
		
		try {
			inputStream = new FileInputStream("src/performance.png");
		}
		catch( Exception e) {
			System.out.println("This should never happen but anyway");
		}
		Image performanceImg = new Image(inputStream);
		ImageView performanceIcon = new ImageView(performanceImg);
		performanceIcon.setFitHeight(100);
		performanceIcon.setFitWidth(100);
		performancebtn.setGraphic(performanceIcon);
		
		Label performance = new Label("Employee performance");
		performance .setFont(Font.font("Times New Roman", FontWeight.BOLD, 25));
		performance.setAlignment(Pos.BASELINE_CENTER);
		
		VBox performanceVbox = new VBox();
		performanceVbox.getChildren().addAll(performancebtn, performance);
		performanceVbox.setAlignment(Pos.TOP_CENTER);
		
		HBox hbox = new HBox();
		hbox.setPrefHeight(100);
		hbox.getChildren().addAll(bookVbox, statisticVbox);
		hbox.setSpacing(350);
		hbox.setPadding(new Insets(30,0,0,90));
		
		
		Label note = new Label("Leave yourself a note");
		note.setStyle("-fx-background-color:#459062");
		note.setAlignment(Pos.BASELINE_LEFT);
		note.setPrefHeight(50);
		note.setPrefWidth(800);
		note.setFont(Font.font("Times New Roman", FontWeight.BOLD, 25));
		
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
		vbox.getChildren().addAll(userBox, hbox, performanceVbox, noteBox, textArea);
		
		Alert alert = new Alert(AlertType.WARNING);
		alert.setHeaderText("Warning!");
		alert.setTitle("...");
		
		Scene scene = new Scene(vbox, 800, 500);
		primaryStage.setScene(scene);
	 	primaryStage.setResizable(false);
	 	primaryStage.setTitle("Manager");
	 	primaryStage.show();
	}
}
