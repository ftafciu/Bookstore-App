package View;

import Model.Books;
import Model.BooksRW;
import Model.Employee;
import javafx.geometry.Insets;

import javafx.geometry.Pos;

import javafx.scene.Cursor;

import javafx.scene.Scene;

import javafx.scene.control.Button;

import javafx.scene.control.Label;

import javafx.scene.control.TextField;

import javafx.scene.layout.BorderPane;

import javafx.scene.layout.VBox;

import javafx.scene.paint.Color;

import javafx.scene.text.Font;

import javafx.scene.text.FontPosture;

import javafx.scene.text.FontWeight;

import javafx.stage.Stage;

public class AddCategory {

	private Employee man;
	private boolean whereFrom;
	private Books book;
	
	public AddCategory(Employee man, boolean whereFrom, Books book) {
		this.man = man;
		this.whereFrom = whereFrom;
		this.book = book;
	}
	
public void show(Stage primaryStage) {


BorderPane content = new BorderPane();

Label stockLabel = new Label("Add category");

stockLabel.setPrefSize(800, 70);

stockLabel.setAlignment(Pos.CENTER_LEFT);

stockLabel.setPadding(new Insets(20));

stockLabel.setStyle("-fx-background-color: #459062;");

stockLabel.setFont(Font.font("Times new roman", FontWeight.BOLD, FontPosture.REGULAR, 35));


content.setTop(stockLabel);


TextField quantity = new TextField();

quantity.setPromptText("Enter category");

quantity.setAlignment(Pos.CENTER);

quantity.setStyle("-fx-border-radius:15px");

quantity.setStyle("-fx-background-radius:15px");

quantity.setFocusTraversable(false);

quantity.setPrefHeight(40);

quantity.setMaxWidth(200);



Button add = new Button("Add category");

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
	(new BooksRW()).addCategory(quantity.getText());
	if(whereFrom)
		(new EditBooks(man, book, true)).show(primaryStage);
	else
		(new AddBooks(man, true)).show(primaryStage);
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