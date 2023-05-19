package View;

import java.util.ArrayList;

import Model.Admin;
import Model.Books;
import Model.BooksRW;
import Model.Employee;
import Model.Person;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Stock {

	private Person person;
	
	public Stock(Person person) {
		this.person = person;
	}
	
	public void show(Stage primaryStage) {
		
		BorderPane content = new BorderPane();
		
		Label stockLabel = new Label("Stock");
		stockLabel.setPrefSize(800, 70);
		stockLabel.setAlignment(Pos.CENTER_LEFT);
		stockLabel.setPadding(new Insets(20));
		stockLabel.setStyle("-fx-background-color: #459062;");
		stockLabel.setFont(Font.font("Times new roman", FontWeight.BOLD, FontPosture.REGULAR, 35));
		
		TableView<Books> table = new TableView<>();
		ObservableList<Books> list = FXCollections.observableArrayList((new BooksRW()).getBooks());
		System.out.println((new BooksRW()).getBooks());
		table.setItems(list);
		TableColumn title = new TableColumn("Title");
		title.setMinWidth(300);
		title.setCellValueFactory(new PropertyValueFactory<Books, String>("bookTitle"));
		TableColumn author = new TableColumn("Author");
		author.setMinWidth(100);
		author.setCellValueFactory(new PropertyValueFactory<Books, String>("author"));
		TableColumn category = new TableColumn("Category");
		category.setMinWidth(100);
		category.setCellValueFactory(new PropertyValueFactory<Books, String>("category"));
		TableColumn isbn = new TableColumn("ISBN");
		isbn.setMinWidth(100);
		isbn.setCellValueFactory(new PropertyValueFactory<Books, String>("ISBN"));
		TableColumn number = new TableColumn("Quantity");
		number.setCellValueFactory(new PropertyValueFactory<Books, Integer>("quantity"));
		number.setMinWidth(100);
		TableColumn price = new TableColumn("Price");
		price.setMinWidth(100);
		price.setCellValueFactory(new PropertyValueFactory<Books, Double>("price"));
		table.getColumns().addAll(title, author, category, isbn, number, price);
		ArrayList<Books> selected = new ArrayList<>();
		table.getSelectionModel().selectedItemProperty().addListener(ov->{
			ObservableList<Books> selectedItems = table.getSelectionModel().getSelectedItems();
			selected.clear();
			for(Books b:selectedItems)
				selected.add((new BooksRW()).findBook(b.getTitle()));
		});
		
		HBox buttons = new HBox();
		buttons.setPrefSize(800, 70);
		buttons.setStyle("-fx-background-color: #459062");
		buttons.setAlignment(Pos.CENTER);
		buttons.setSpacing(20);
		Button edit = new Button("edit");
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
				(new EditBooks((Employee)person, selected.get(0), false)).show(primaryStage);
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
			if(person.getStatus().equals("Manager"))
				(new Manager((Employee)person)).show(primaryStage);
			else
				(new Administrator((Admin)person)).show(primaryStage);
		});
		Button add= new Button("add");
		add.setPrefSize(200, 40);
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
			(new AddBooks((Employee)person, false)).show(primaryStage);
		});
		buttons.getChildren().addAll(edit, back, add);
		
		content.setTop(stockLabel);
		content.setCenter(table);
		content.setBottom(buttons);
		
		Scene scene = new Scene(content, 800, 550);
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();
	}
	
	
}
