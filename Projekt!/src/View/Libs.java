package View;

import java.util.ArrayList;

import Model.Admin;

import Model.Books;

import Model.BooksRW;

import Model.Employee;

import Model.Person;

import Model.ReadUser;

import javafx.collections.FXCollections;

import javafx.collections.ObservableList;

import javafx.geometry.Insets;

import javafx.geometry.Pos;

import javafx.scene.Cursor;

import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

import javafx.scene.control.Label;

import javafx.scene.control.TableColumn;

import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;

import javafx.scene.layout.BorderPane;

import javafx.scene.layout.HBox;

import javafx.scene.paint.Color;

import javafx.scene.text.Font;

import javafx.scene.text.FontPosture;

import javafx.scene.text.FontWeight;

import javafx.stage.Stage;



public class Libs {

private Person person;

public Libs(Person person) {

this.person = person;

}


public void show(Stage primaryStage) {

BorderPane content = new BorderPane();

Label userLabel = new Label("Users");

userLabel.setPrefSize(800, 70);

userLabel.setAlignment(Pos.CENTER_LEFT);

userLabel.setPadding(new Insets(20));

userLabel.setStyle("-fx-background-color: green;");

userLabel.setFont(Font.font("Times new roman", FontWeight.BOLD, FontPosture.REGULAR, 35));

TableView<Employee> table = new TableView<>();

ArrayList<Employee> list = new ArrayList<>();
ArrayList<Person> primary = (new ReadUser()).primary();
for(Person p:primary)
	if(p.getStatus().equals("Librarian"))
		list.add((Employee)p);

ObservableList<Employee> personList = FXCollections.observableArrayList((list));

table.setItems(personList);

TableColumn name = new TableColumn("Name");

name.setMinWidth(150);

name.setCellValueFactory(new PropertyValueFactory<Person, String>("Name"));


TableColumn surname = new TableColumn("Surname");

surname.setMinWidth(150);

surname.setCellValueFactory(new PropertyValueFactory<Person, String>("Surname"));

TableColumn username = new TableColumn("Username");

username.setMinWidth(150);

username.setCellValueFactory(new PropertyValueFactory<Person, String>("Username"));

TableColumn email = new TableColumn("Email");

email.setMinWidth(150);

email.setCellValueFactory(new PropertyValueFactory<Person, String>("Email"));

TableColumn salary = new TableColumn("Salary");

salary.setMinWidth(100);

salary.setCellValueFactory(new PropertyValueFactory<Person, Double>("Salary"));

TableColumn status = new TableColumn("Status");

status.setCellValueFactory(new PropertyValueFactory<Person, String>("Status"));

status.setMinWidth(100);

ArrayList<Employee> selected = new ArrayList<>();
table.getSelectionModel().selectedItemProperty().addListener(ov->{
	ObservableList<Employee> selectedItems = table.getSelectionModel().getSelectedItems();
	selected.clear();
	for(Employee b:selectedItems)
		selected.add((Employee)(new ReadUser()).findUser(b.getUsername()));
});


table.getColumns().addAll(name, surname, username, email, salary, status);

HBox buttons = new HBox();

buttons.setPrefSize(800, 70);

buttons.setStyle("-fx-background-color: green");

buttons.setAlignment(Pos.CENTER);

buttons.setSpacing(20);

Button edit = new Button("view stats");

edit.setPrefSize(200, 40);

edit.setStyle("-fx-background-color: white; -fx-border-radius: 15px; -fx-background-radius: 15px;");

edit.setTextFill(Color.GREEN);

edit.setOnMouseEntered(e->{

edit.setCursor(Cursor.HAND);

edit.setStyle("-fx-background-color: gainsboro; -fx-border-radius: 15px; -fx-background-radius: 15px;");

});

edit.setOnMouseExited(e->{

edit.setStyle("-fx-background-color: white; -fx-border-radius: 15px; -fx-background-radius: 15px;");

});

edit.setOnAction(e->{
	if(selected.isEmpty()) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setHeaderText("No items selected");
		alert.setContentText("Select an item please");
		alert.showAndWait();
	}else {
		(new EmployeeStatistic((Employee)person, selected.get(0))).show(primaryStage);
	}
});

Button back = new Button("back");

back.setPrefSize(200, 40);

back.setStyle("-fx-background-color: white; -fx-border-radius: 15px; -fx-background-radius: 15px;");

back.setTextFill(Color.GREEN);

back.setOnMouseEntered(e->{

back.setCursor(Cursor.HAND);

back.setStyle("-fx-background-color: gainsboro; -fx-border-radius: 15px; -fx-background-radius: 15px;");

});

back.setOnMouseExited(e->{

back.setStyle("-fx-background-color: white; -fx-border-radius: 15px; -fx-background-radius: 15px;");

});

back.setOnAction(e->{
	(new Manager((Employee)person)).show(primaryStage);
});


buttons.getChildren().addAll(edit, back);

content.setTop(userLabel);

content.setCenter(table);

content.setBottom(buttons);


Scene scene = new Scene(content, 800, 550);

primaryStage.setScene(scene);

primaryStage.setResizable(false);

primaryStage.show();

}

}