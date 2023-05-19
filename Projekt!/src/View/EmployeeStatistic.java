package View;

import java.time.LocalDate;

import Model.Employee;
import items.MyDate;
import javafx.geometry.Insets;

import javafx.geometry.Pos;

import javafx.scene.Cursor;

import javafx.scene.Scene;

import javafx.scene.control.Button;

import javafx.scene.control.DatePicker;

import javafx.scene.control.Label;

import javafx.scene.control.TextField;

import javafx.scene.layout.BorderPane;

import javafx.scene.layout.HBox;

import javafx.scene.layout.VBox;

import javafx.scene.paint.Color;

import javafx.scene.text.Font;

import javafx.scene.text.FontPosture;

import javafx.scene.text.FontWeight;

import javafx.stage.Stage;

public class EmployeeStatistic {

private Employee man;
private Employee lib;

public EmployeeStatistic(Employee man, Employee lib) {
	this.man = man;
	this.lib = lib;
}
	
public void show(Stage primaryStage) {


Label statistics = new Label("Employee Statistic");

statistics.setPrefSize(800, 70);

statistics.setAlignment(Pos.CENTER_LEFT);

statistics.setPadding(new Insets(20));

statistics.setStyle("-fx-background-color: #459062;");

statistics.setFont(Font.font("Times new roman", FontWeight.BOLD, FontPosture.REGULAR, 35));


DatePicker firstDate = new DatePicker();

Label first = new Label("From:");

first.setFont(Font.font("Times new roman", FontWeight.BOLD, FontPosture.REGULAR, 20));

HBox firstBox = new HBox();

firstBox.setSpacing(5);

firstBox.getChildren().addAll(first, firstDate);


DatePicker secondDate = new DatePicker();

Label second = new Label("To:");

second.setFont(Font.font("Times new roman", FontWeight.BOLD, FontPosture.REGULAR, 20));

HBox secondBox = new HBox();

secondBox.setSpacing(5);

secondBox.setSpacing(5);

secondBox.getChildren().addAll(second, secondDate);
firstDate.setValue(LocalDate.now());
secondDate.setValue(LocalDate.now());


HBox dates = new HBox();

dates.getChildren().addAll(firstBox, secondBox);

dates.setSpacing(20);

dates.setPadding(new Insets(10, 20, 10, 30));


Label booksSold = new Label("Books sold:");

booksSold.setFont(Font.font("Times new roman", FontWeight.BOLD, FontPosture.REGULAR, 20));


Label bills = new Label("Nr of bills:");

bills.setFont(Font.font("Times new roman", FontWeight.BOLD, FontPosture.REGULAR, 20));


Label money = new Label("Money made:");

money.setFont(Font.font("Times new roman", FontWeight.BOLD, FontPosture.REGULAR, 20));


VBox labelBox = new VBox();

labelBox.getChildren().addAll(booksSold, bills, money);

labelBox.setPadding(new Insets(0, 0, 0, 20));

labelBox.setSpacing(15);


VBox vbox = new VBox();

vbox.setSpacing(30);

vbox.getChildren().addAll(statistics, dates, labelBox);


Button filter = new Button("Filetr");
filter.setPrefSize(200, 40);

filter.setStyle("-fx-filterground-color: white; -fx-border-radius: 15px; -fx-filterground-radius: 15px;");

filter.setTextFill(Color.GREEN);

filter.setOnMouseEntered(e->{

filter.setCursor(Cursor.HAND);

filter.setStyle("-fx-filterground-color: gainsboro; -fx-border-radius: 15px; -fx-filterground-radius: 15px;");

});

filter.setOnMouseExited(e->{

filter.setStyle("-fx-filterground-color: white; -fx-border-radius: 15px; -fx-filterground-radius: 15px;");

});
filter.setOnAction(e->{
	MyDate begDay = new MyDate(firstDate.getValue().getDayOfMonth(), firstDate.getValue().getMonthValue(), firstDate.getValue().getYear());
});


Scene scene = new Scene(vbox, 800, 500);

primaryStage.setScene(scene);

primaryStage.setResizable(false);

primaryStage.setTitle("Edit Users");

primaryStage.show();

}

}
