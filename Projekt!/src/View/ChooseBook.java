package View;

import java.time.LocalDate;
import java.util.ArrayList;

import Model.Admin;
import Model.Books;
import Model.BooksRW;
import Model.Employee;
import Model.InOutControl;
import Model.SaleInOut;
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

public class ChooseBook {

	private Employee lib;
	private ArrayList<Books> billBooks;
	
	public ChooseBook(Employee lib) {
		this.lib = lib;
		billBooks = new ArrayList<Books>();
	}
	
	public void show(Stage primaryStage) {
BorderPane content = new BorderPane();
		
		Label stockLabel = new Label("Stock");
		stockLabel.setPrefSize(800, 70);
		stockLabel.setAlignment(Pos.CENTER_LEFT);
		stockLabel.setPadding(new Insets(20));
		stockLabel.setStyle("-fx-background-color: green;");
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
		buttons.setStyle("-fx-background-color: green");
		buttons.setAlignment(Pos.CENTER);
		buttons.setSpacing(20);
		
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
			(new Librarian(lib)).show(primaryStage);
		});
		Button add= new Button("add to bill");
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
			if(selected.isEmpty()) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setHeaderText("No items selected");
				alert.setContentText("Select an item please");
				alert.showAndWait();
			}else {
				Books temp = selected.get(0);
				(new BooksRW()).modifyQuantity(-1, temp);
				Books temp1 = (Books)temp.clone();
				temp1.changeQuantity(-temp.getQuantity());
				temp1.changeQuantity(1);
				if(billBooks.contains(temp1))
					billBooks.get(billBooks.indexOf(temp1)).changeQuantity(1);
				else
					billBooks.add(temp1);
			}
		});
		Button create = new Button("Create bill");
		create.setPrefSize(200, 40);
		create.setStyle("-fx-background-color: white; -fx-border-radius: 15px; -fx-background-radius: 15px;");
		create.setTextFill(Color.GREEN);
		create.setOnMouseEntered(e->{
			create.setCursor(Cursor.HAND);
			create.setStyle("-fx-background-color: gainsboro; -fx-border-radius: 15px; -fx-background-radius: 15px;");
		});
		create.setOnMouseExited(e->{
			create.setStyle("-fx-background-color: white; -fx-border-radius: 15px; -fx-background-radius: 15px;");
		});
		create.setOnAction(e->{
			lib.newBill(billBooks, LocalDate.now());
			InOutControl ino = new InOutControl();
			ino.add(new SaleInOut(billBooks, LocalDate.now(), true));
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setHeaderText("Successful transaction");
			alert.showAndWait();
			(new Librarian(lib)).show(primaryStage);
		});
		buttons.getChildren().addAll(back, add, create);
		
		content.setTop(stockLabel);
		content.setCenter(table);
		content.setBottom(buttons);
		
		Scene scene = new Scene(content, 800, 550);
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();
	}
	
}
