package dad.calculadora.compleja;

import dad.calculadora.compleja.Complejo;
import javafx.application.Application;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Compleja extends Application  {
	
	private Complejo sumar = new Complejo();
	
	private Complejo[] complejo = {+, -, /, *};

	private TextField ptxt, atxt, ptxt1, atxt1, ptxt2, atxt2;
	private DoubleProperty real = new SimpleDoubleProperty(0);
	private DoubleProperty imaginario = new SimpleDoubleProperty(0);
	private ComboBox<Complejo> operacionCombo;


	@Override
	public void start(Stage primaryStage) throws Exception {
		//VBox Combo
		//ComboBox
		operacionCombo = new ComboBox();
		operacionCombo.getItems().addAll();
		operacionCombo.getSelectionModel().selectFirst();
		
		VBox combo = new VBox();
		combo.setSpacing(5);
		combo.setAlignment(Pos.CENTER);
		combo.getChildren().addAll(operacionCombo);
		
		//VBox Medio
		
		//textfield
		ptxt = new TextField("0");
		ptxt.setPrefColumnCount(4);
		
		atxt = new TextField("0");
		atxt.setPrefColumnCount(4);
		

		//HBox operaciones
		HBox operaciones = new HBox();
		operaciones.setAlignment(Pos.CENTER);
		operaciones.setSpacing(5);
		operaciones.getChildren().addAll(ptxt,new Label("+"),atxt,new Label("i"));
		
		//textfield
		ptxt1 = new TextField("0");
		ptxt1.setPrefColumnCount(4);
		
		atxt1 = new TextField("0");
		atxt1.setPrefColumnCount(4);
		
		//HBox operaciones1
		HBox operaciones1 = new HBox();
		operaciones1.setAlignment(Pos.CENTER);
		operaciones1.setSpacing(5);
		operaciones1.getChildren().addAll(ptxt1,new Label("+"),atxt1,new Label("i"));
		
		//textfield
		ptxt2 = new TextField("0");
		ptxt2.setPrefColumnCount(4);
		
		atxt2 = new TextField("0");
		atxt2.setPrefColumnCount(4);
		
		//HBox operaciones2
		HBox operaciones2 = new HBox();
		operaciones2.setAlignment(Pos.CENTER);
		operaciones2.setSpacing(5);
		operaciones2.getChildren().addAll(ptxt2,new Label("+"),atxt2,new Label("i"));
		
		
		VBox medio = new VBox();
		medio.setSpacing(5);
		medio.setAlignment(Pos.CENTER);
		medio.getChildren().addAll(operaciones, operaciones1, new Separator(), operaciones2);
		
		//HBox encabezado
		HBox encabezado = new HBox();
		encabezado.setAlignment(Pos.CENTER);
		encabezado.setSpacing(5);
		encabezado.getChildren().addAll(combo, medio);
		
		// creamos la escena
		Scene escena = new Scene(encabezado, 320, 200);

		// configuramos la ventana
		primaryStage.setScene(escena);
		primaryStage.setTitle("IMC");
		primaryStage.show();
	
	}



	public static void main(String[] args) {
		launch(args);
	}
	




}
