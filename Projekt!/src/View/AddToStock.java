package View;

import java.time.LocalDate;
import java.util.ArrayList;

import Model.Books;
import Model.BooksRW;
import Model.Employee;
import Model.InOutControl;
import Model.SaleInOut;
import javafx.geometry.Insets;

import javafx.geometry.Pos;

import javafx.scene.Cursor;

import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

import javafx.scene.control.Label;

import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;

import javafx.scene.layout.VBox;

import javafx.scene.paint.Color;

import javafx.scene.text.Font;

import javafx.scene.text.FontPosture;

import javafx.scene.text.FontWeight;

import javafx.stage.Stage;

public class AddToStock {

	private Books book;
	private Employee man;
	
	public AddToStock(Employee man, Books book) {
		this.man = man;
		this.book = book;
	}

public void show(Stage primaryStage) {


BorderPane content = new BorderPane();

Label stockLabel = new Label("Add to stock");

stockLabel.setPrefSize(800, 70);

stockLabel.setAlignment(Pos.CENTER_LEFT);

stockLabel.setPadding(new Insets(20));

stockLabel.setStyle("-fx-background-color: #459062;");

stockLabel.setFont(Font.font("Times new roman", FontWeight.BOLD, FontPosture.REGULAR, 35));


content.setTop(stockLabel);


TextField quantity = new TextField();

quantity.setPromptText("Enter quantity");

quantity.setAlignment(Pos.CENTER);

quantity.setStyle("-fx-border-radius:15px");

quantity.setStyle("-fx-background-radius:15px");

quantity.setFocusTraversable(false);

quantity.setPrefHeight(40);

quantity.setMaxWidth(200);



Button add = new Button("Add to stock");

add.setPrefSize(200, 40);

add.setAlignment(Pos.CENTER);

add.setStyle("-fx-background-color: white; -fx-border-radius: 15px; -fx-background-radius: 15px;");

add.setTextFill(Color.GREEN);

add.setOnMouseEntered(e->{

add.setCursor(Cursor.HAND);

add.setStyle("-fx-background-color: gainsboro; -fx-border-radius: 15px; -fx-background-radius: 15px;");

});

add.setOnMouseExited(e->{

add.setStyle("-fx-background-color: white; -fx-border-radius: 15px; -fx-background-radius: 15px;");

});

add.setOnAction(e->{
	try {
		int value = Integer.parseInt(quantity.getText());
		if(value <= 0) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setHeaderText("Invalid value");
			alert.setContentText("Please enter only numbers greater than 0");
			alert.showAndWait();
		}else {
			(new BooksRW()).modifyQuantity(value, book);
			Books clone = (Books)book.clone();
			clone.changeQuantity(-1);
			ArrayList<Books> transArray = new ArrayList<>();
			transArray.add(clone);
			SaleInOut sl = new SaleInOut(transArray, LocalDate.now(), false);
			InOutControl ino = new InOutControl();
			ino.add(sl);
			(new EditBooks(man, book, false)).show(primaryStage);
		}
	}catch(NumberFormatException e1) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setHeaderText("Invalid value");
		alert.setContentText("Please enter only numbers");
		alert.showAndWait();
	}
});



VBox vbox = new VBox();

vbox.setSpacing(30);

vbox.getChildren().addAll(quantity, add);

vbox.setAlignment(Pos.CENTER);

content.setCenter(vbox);




Scene scene = new Scene(content, 800, 500);

primaryStage.setScene(scene);

primaryStage.setResizable(false);

primaryStage.setTitle("Edit Users");

primaryStage.show();

}

}