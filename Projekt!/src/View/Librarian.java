package View;

import java.io.FileInputStream;

import Model.*;
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


public class Librarian {

	private Employee lib;
	
	public Librarian(Employee lib) {
		this.lib = lib;
	}
	
	public void show(Stage primaryStage) {
	Label hiName = new Label("Hi " + lib.getName());
	hiName.setStyle("-fx-background-color:#459062");
	hiName.setAlignment(Pos.BASELINE_CENTER);
	hiName.setPrefHeight(100);
	hiName.setPrefWidth(800);
	hiName.setFont(Font.font("Times New Roman", FontWeight.BOLD, 50));
	HBox userBox = new HBox();
	userBox.setStyle("-fx-background-color:#459062");
	
	
	FileInputStream inputStream = null;
	try {
		inputStream = new FileInputStream("src/user.png");
	}
	catch( Exception e) {
		System.out.println("This should never happen but anyway");
	}
	
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
	bookBtn.setPrefSize(120, 120);
		try {
		inputStream = new FileInputStream("src/book.png");
	}
	catch( Exception e) {
		System.out.println("This should never happen but anyway");
	}
	Image bookImg = new Image(inputStream);
	ImageView bookIcon = new ImageView(bookImg);
	bookIcon.setFitHeight(120);
	bookIcon.setFitWidth(120);
	bookBtn.setGraphic(bookIcon);
	bookBtn.setStyle("-fx-border-radius:13px; -fx-background-radius:13px; -fx-background-color:#459062 ;");
	bookBtn.setCursor(Cursor.HAND);
	bookBtn.setOnMouseEntered(e->{
		bookBtn.setStyle("-fx-border-radius:13px; -fx-background-radius:13px; -fx-background-color: lightgreen;");
		bookBtn.setCursor(Cursor.HAND);
	});
	bookBtn.setOnMouseExited(e->{
		bookBtn.setStyle("-fx-border-radius:13px; -fx-background-radius:13px; -fx-background-color:#459062 ;");
	});
	bookBtn.setOnAction(e->{
		(new ChooseBook(lib)).show(primaryStage);
	});
	bookBtn.setGraphic(bookIcon);
	Label book = new Label("Books");
	book.setFont(Font.font("Times New Roman", FontWeight.BOLD, 30));
	book.setAlignment(Pos.BASELINE_CENTER);
	VBox bookVbox = new VBox();
	bookVbox.getChildren().addAll(bookBtn, book);
	
	
	Button billBtn = new Button();
	billBtn.setPrefSize(120, 120);
	billBtn.setStyle("-fx-border-radius:13px; -fx-background-radius:13px; -fx-background-color: #459062;");
	billBtn.setCursor(Cursor.HAND);
	billBtn.setOnMouseEntered(e->{
		billBtn.setStyle("-fx-border-radius:13px; -fx-background-radius:13px; -fx-background-color: lightgreen;");
		billBtn.setCursor(Cursor.HAND);
	});
	billBtn.setOnMouseExited(e->{
		billBtn.setStyle("-fx-border-radius:13px; -fx-background-radius:13px; -fx-background-color:#459062 ;");
	});
	
	try {
		inputStream = new FileInputStream("src/bill.png");
	}
	catch( Exception e) {
		System.out.println("This should never happen but anyway");
	}
	Image billImg = new Image(inputStream);
	ImageView billIcon = new ImageView(billImg);
	billIcon.setFitHeight(120);
	billIcon.setFitWidth(120);
	billBtn.setGraphic(billIcon);
	Label bill = new Label("Bills");
	bill.setFont(Font.font("Times New Roman", FontWeight.BOLD, 30));
	bill.setAlignment(Pos.BASELINE_CENTER);
	VBox billVbox = new VBox();
	billVbox.getChildren().addAll(billBtn, bill);
	HBox hbox = new HBox();
	hbox.setAlignment(Pos.CENTER);
	hbox.getChildren().addAll(bookVbox);
	hbox.setSpacing(350);
	hbox.setPadding(new Insets(30,0,20,90));
	
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
	vbox.getChildren().addAll(userBox, hbox, noteBox, textArea);
	
	Scene scene = new Scene(vbox, 800, 500);
	primaryStage.setScene(scene);
 	primaryStage.setResizable(false);
 	primaryStage.setTitle("Librarian");
 	primaryStage.show();
	     	
	
	
	}
	
	
	

}
