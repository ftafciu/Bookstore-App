package View;

import java.io.FileInputStream;
import java.time.LocalDate;
import java.util.ArrayList;

import Model.Author;
import Model.Books;
import Model.BooksRW;
import Model.Employee;
import Model.InOutControl;
import Model.SaleInOut;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class AddBooks {

private Employee manager;
private boolean changedCat;

public AddBooks(Employee manager, boolean changedCat) {
	this.manager = manager;
	this.changedCat = changedCat;
}

public void show(Stage primaryStage) {


Label addBook = new Label("Add Books");

addBook.setFont(Font.font("Times New Roman", FontWeight.BOLD, 30));

addBook.setPadding(new Insets(0,0,50,0));


HBox textPane = new HBox();

textPane.setSpacing(270);

textPane.setStyle("-fx-background-color: #459062");

textPane.setPrefSize(500, 100);
textPane.setPadding(new Insets(20));


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
	(new Stock(manager)).show(primaryStage);
});
backBtn.setGraphic(backIcon);


textPane.getChildren().addAll(backBtn, addBook);



TextField name = new TextField();

name.setPromptText("Enter book title");

name.setAlignment(Pos.CENTER);

name.setStyle("-fx-border-radius:15px");

name.setStyle("-fx-background-radius:15px");

name.setFocusTraversable(false);

name.setPrefHeight(40);

name.setMaxWidth(200);



ArrayList<String> list = (new BooksRW()).getCategories();
list.add("Other");
ComboBox<String> category = new ComboBox<>(FXCollections.observableArrayList(list));

category.setPromptText("Category");

category.setStyle("-fx-border-radius:15px; -fx-background-color: white; -fx-background-radius:15px");

category.setFocusTraversable(false);

category.setPrefHeight(40);

category.setMaxWidth(200);

category.setOnAction(e->{
	if(category.getValue().equals("Other"))
		(new AddCategory(manager, false, null)).show(primaryStage);
});

if(changedCat)
	category.setValue(((new BooksRW()).getCategories().get((new BooksRW()).getCategories().size() - 1)));


TextField author = new TextField();

author.setPromptText("Enter book author");

author.setAlignment(Pos.CENTER);

author.setStyle("-fx-border-radius:15px");

author.setStyle("-fx-background-radius:15px");

author.setFocusTraversable(false);

author.setPrefHeight(40);

author.setMaxWidth(200);



TextField ISBN = new TextField();

ISBN.setPromptText("Enter book ISBN");

ISBN.setAlignment(Pos.CENTER);

ISBN.setStyle("-fx-border-radius:15px");

ISBN.setStyle("-fx-background-radius:15px");

ISBN.setFocusTraversable(false);

ISBN.setPrefHeight(40);

ISBN.setMaxWidth(200);

TextField buyPrice = new TextField();

buyPrice.setPromptText("Enter book original price");

buyPrice.setAlignment(Pos.CENTER);

buyPrice.setStyle("-fx-border-radius:15px");

buyPrice.setStyle("-fx-background-radius:15px");

buyPrice.setFocusTraversable(false);

buyPrice.setPrefHeight(40);

buyPrice.setMaxWidth(200);

TextField price = new TextField();

price.setPromptText("Enter book price");

price.setAlignment(Pos.CENTER);

price.setStyle("-fx-border-radius:15px");

price.setStyle("-fx-background-radius:15px");

price.setFocusTraversable(false);

price.setPrefHeight(40);

price.setMaxWidth(200);



Button addBtn = new Button("Add");

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
	if(!(name.getText().equals("") || author.getText().equals("") || ISBN.getText().equals("") || price.getText().equals("") || buyPrice.getText().equals(""))) {
		String [] authorInfo = author.getText().split("\\s");
		System.out.println(authorInfo[0]);
		System.out.println(authorInfo[1]);
		try {
			(new BooksRW()).addBook(new Books(new Author(authorInfo[0], authorInfo[1]), name.getText(), ISBN.getText(), category.getValue(), Double.parseDouble(price.getText())
					, Double.parseDouble(buyPrice.getText())));
			ArrayList<Books> bookOfTrans = new ArrayList<>();
			bookOfTrans.add(new Books(new Author(authorInfo[0], authorInfo[1]), name.getText(), ISBN.getText(), category.getValue(), Double.parseDouble(price.getText())
					, Double.parseDouble(buyPrice.getText())));
			SaleInOut sl = new SaleInOut(bookOfTrans, LocalDate.now(), false);
			InOutControl inO = new InOutControl();
			inO.add(sl);
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


VBox vbox = new VBox(10);

vbox.setAlignment(Pos.CENTER);

vbox.setPrefSize(800, 500);

vbox.getChildren().addAll(textPane, name, category,author, ISBN, buyPrice, price, addBtn);

vbox.setStyle("-fx-background-color: #459062");




Scene scene = new Scene(vbox, 800, 500);

primaryStage.setScene(scene);

primaryStage.setResizable(false);

primaryStage.setTitle("Edit Books");

primaryStage.show();



}

}