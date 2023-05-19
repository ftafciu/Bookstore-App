package View;

import java.io.FileInputStream;
import java.util.ArrayList;

import Model.Author;
import Model.Books;
import Model.BooksRW;
import Model.Employee;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
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

public class EditBooks {


private Books book;
private Employee man;
private boolean changedCat;

public EditBooks(Employee man, Books book, boolean changedCat) {
	this.book = book;
	this.man = man;
	this.changedCat = changedCat;
}

public void show(Stage primaryStage) {


Label addBook = new Label("Edit Books");

addBook.setFont(Font.font("Times New Roman", FontWeight.BOLD, 30));

addBook.setPadding(new Insets(0,0,50,0));


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
	(new Stock(man)).show(primaryStage);
});

backBtn.setGraphic(backIcon);


textPane.getChildren().addAll(backBtn, addBook);



TextField name = new TextField();

name.setAlignment(Pos.CENTER);

name.setStyle("-fx-border-radius:15px");

name.setStyle("-fx-background-radius:15px");

name.setFocusTraversable(false);

name.setPrefHeight(40);

name.setMaxWidth(200);

name.setText(book.getBookTitle());


ArrayList<String> list = (new BooksRW()).getCategories();
list.add("Other");
ComboBox<String> category = new ComboBox<>(FXCollections.observableArrayList(list));

category.setStyle("-fx-border-radius:15px; -fx-background-color: white; -fx-background-radius:15px");

category.setFocusTraversable(false);

category.setPrefHeight(40);

category.setMaxWidth(200);

category.setValue(book.getCategory());

category.setOnAction(e->{
	if(category.getValue().equals("Other"))
		(new AddCategory(man, true, book)).show(primaryStage);
});

if(changedCat)
	category.setValue(((new BooksRW()).getCategories().get((new BooksRW()).getCategories().size() - 1)));


TextField author = new TextField();

author.setAlignment(Pos.CENTER);

author.setStyle("-fx-border-radius:15px");

author.setStyle("-fx-background-radius:15px");

author.setFocusTraversable(false);

author.setPrefHeight(40);

author.setMaxWidth(200);

author.setText(book.getAuthor().getName() + " " + book.getAuthor().getSurname());



TextField ISBN = new TextField();

ISBN.setAlignment(Pos.CENTER);

ISBN.setStyle("-fx-border-radius:15px");

ISBN.setStyle("-fx-background-radius:15px");

ISBN.setFocusTraversable(false);

ISBN.setPrefHeight(40);

ISBN.setMaxWidth(200);

ISBN.setText(book.getISBN());


TextField price = new TextField();

price.setAlignment(Pos.CENTER);

price.setStyle("-fx-border-radius:15px");

price.setStyle("-fx-background-radius:15px");

price.setFocusTraversable(false);

price.setPrefHeight(40);

price.setMaxWidth(200);

price.setText(book.getPrice() + "0");



Button saveBtn = new Button("Save");

saveBtn.setAlignment(Pos.CENTER);

saveBtn.setPrefSize(140, 40);

saveBtn.setTextFill(Color.GRAY);

saveBtn.setFont(Font.font("Times New Roman", FontWeight.BOLD, 16));

saveBtn.setStyle("-fx-border-radius:13px; -fx-background-radius:13px; -fx-background-color: white;");

saveBtn.setOnMouseEntered(e->{

saveBtn.setStyle("-fx-border-radius:13px; -fx-background-radius:13px; -fx-background-color: lightgrey;");

saveBtn.setCursor(Cursor.HAND);

});

saveBtn.setOnMouseExited(e->{

saveBtn.setStyle("-fx-border-radius:13px; -fx-background-radius:13px; -fx-background-color: white;");

});
saveBtn.setOnAction(e->{
	BooksRW rw = new BooksRW();
	if(!(name.getText().equals("") || author.equals("") || ISBN.equals(""))) {
		try {
			String [] authorInfo = author.getText().split("\\s");
			rw.modifyPrice(Double.parseDouble(price.getText()), book);
			rw.modifyTitle(name.getText(), book);
			rw.modifyCategory(category.getValue(), book);
			rw.modifyAuthor(new Author(authorInfo[0], authorInfo[1]), book);
			rw.modifyISBN(ISBN.getText(), book);
			(new Stock(man)).show(primaryStage);
		}catch(NumberFormatException e1) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setHeaderText("Invalid value");
			alert.setContentText("Please enter only numbers in the price data field");
			alert.showAndWait();

		}
	}else {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setHeaderText("Blank fields!!");
		alert.setContentText("Please fill all the fields");
		alert.showAndWait();
	}
});



Button addBtn = new Button("Add More");

addBtn.setAlignment(Pos.CENTER);

addBtn.setPrefSize(140, 40);

addBtn.setTextFill(Color.GRAY);

addBtn.setFont(Font.font("Times New Roman", FontWeight.BOLD, 16));

addBtn.setStyle("-fx-border-radius:13px; -fx-background-radius:13px; -fx-background-color: white;");

addBtn.setOnMouseEntered(e->{

addBtn.setStyle("-fx-border-radius:13px; -fx-background-radius:13px; -fx-background-color: lightgrey;");

addBtn.setCursor(Cursor.HAND);

});

addBtn.setOnMouseExited(e->{

addBtn.setStyle("-fx-border-radius:13px; -fx-background-radius:13px; -fx-background-color: white;");

});
addBtn.setOnAction(e->{
	(new AddToStock(man, book)).show(primaryStage);
});



HBox buttons = new HBox();

buttons.getChildren().addAll(saveBtn, addBtn);

buttons.setSpacing(10);

buttons.setAlignment(Pos.BASELINE_CENTER);


VBox vbox = new VBox(10);

vbox.setAlignment(Pos.CENTER);

vbox.setPrefSize(800, 500);

vbox.getChildren().addAll(textPane, name, category,author, ISBN, price, buttons);

vbox.setStyle("-fx-background-color: #459062");




Scene scene = new Scene(vbox, 800, 500);

primaryStage.setScene(scene);

primaryStage.setResizable(false);

primaryStage.setTitle("Edit Books");

primaryStage.show();

}

}
