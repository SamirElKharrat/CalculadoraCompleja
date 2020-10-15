package dad.calculadora.compleja;

import dad.calculadora.compleja.Complejo;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
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
import javafx.util.converter.NumberStringConverter;

public class Compleja extends Application {

	private String[] complejo = { "+", "-", "*", "/" };

	private TextField ptxt, atxt, ptxt1, atxt1, ptxt2, atxt2;
	private DoubleProperty real = new SimpleDoubleProperty(0);
	private DoubleProperty imaginario = new SimpleDoubleProperty(0);
	private ComboBox<String> operacionCombo;

	private Complejo complejo1_ = new Complejo();
	private Complejo complejo2_ = new Complejo();
	private Complejo resultado_ = new Complejo();

	@Override
	public void start(Stage primaryStage) throws Exception {

		// VBox Combo
		// ComboBox
		operacionCombo = new ComboBox<String>();
		operacionCombo.getItems().addAll(complejo);
		operacionCombo.getSelectionModel().selectFirst();

		operacionCombo.valueProperty().addListener(e -> {
			if (operacionCombo.valueProperty().getValue() == "+") {
				resultado_.realProperty().bind(complejo1_.realProperty().add(complejo2_.realProperty()));
				resultado_.imaginarioProperty().bind(complejo1_.imaginarioProperty().add(complejo2_.imaginarioProperty()));
				
			} else if (operacionCombo.valueProperty().getValue() == "-") {
				resultado_.realProperty().bind(complejo1_.realProperty().subtract(complejo2_.realProperty()));
				resultado_.imaginarioProperty()
						.bind(complejo1_.imaginarioProperty().subtract(complejo2_.imaginarioProperty()));
				
			} else if (operacionCombo.valueProperty().getValue() == "*") {
				resultado_.realProperty().bind(complejo1_.realProperty().multiply(complejo2_.realProperty())
						.subtract(complejo1_.imaginarioProperty().multiply(complejo2_.imaginarioProperty())));

				resultado_.imaginarioProperty().bind(complejo1_.realProperty().multiply(complejo2_.imaginarioProperty())
						.add(complejo1_.imaginarioProperty().multiply(complejo2_.realProperty())));
				
			} else if (operacionCombo.valueProperty().getValue() == "/") {
				resultado_.realProperty().bind((complejo1_.realProperty().multiply(complejo2_.realProperty())
						.add(complejo1_.imaginarioProperty().multiply(complejo2_.imaginarioProperty())))
								.divide((complejo2_.realProperty().multiply(complejo2_.realProperty()).add(
										complejo2_.imaginarioProperty().multiply(complejo2_.imaginarioProperty())))));

				resultado_.imaginarioProperty().bind((complejo1_.imaginarioProperty().multiply(complejo2_.realProperty())
						.subtract(complejo1_.realProperty().multiply(complejo2_.imaginarioProperty())))
								.divide((complejo2_.realProperty().multiply(complejo2_.realProperty()).add(
										complejo2_.imaginarioProperty().multiply(complejo2_.imaginarioProperty())))));
			}
		});

		VBox combo = new VBox();
		combo.setSpacing(5);
		combo.setAlignment(Pos.CENTER);
		combo.getChildren().addAll(operacionCombo);

		// VBox Medio

		// textfield
		ptxt = new TextField("0");
		ptxt.setPrefColumnCount(4);

		atxt = new TextField("0");
		atxt.setPrefColumnCount(4);

		// HBox operaciones
		HBox operaciones = new HBox();
		operaciones.setAlignment(Pos.CENTER);
		operaciones.setSpacing(5);
		operaciones.getChildren().addAll(ptxt, new Label("+"), atxt, new Label("i"));
		
		Bindings.bindBidirectional(ptxt.textProperty(), complejo1_.realProperty(), new NumberStringConverter());
		Bindings.bindBidirectional(atxt.textProperty(), complejo1_.imaginarioProperty(), new NumberStringConverter());

		// textfield
		ptxt1 = new TextField("0");
		ptxt1.setPrefColumnCount(4);

		atxt1 = new TextField("0");
		atxt1.setPrefColumnCount(4);

		// HBox operaciones1
		HBox operaciones1 = new HBox();
		operaciones1.setAlignment(Pos.CENTER);
		operaciones1.setSpacing(5);
		operaciones1.getChildren().addAll(ptxt1, new Label("+"), atxt1, new Label("i"));
		
		Bindings.bindBidirectional(ptxt1.textProperty(), complejo2_.realProperty(), new NumberStringConverter());
		Bindings.bindBidirectional(atxt1.textProperty(), complejo2_.imaginarioProperty(), new NumberStringConverter());

		// textfield
		ptxt2 = new TextField("0");
		ptxt2.setPrefColumnCount(4);

		atxt2 = new TextField("0");
		atxt2.setPrefColumnCount(4);
		
		Bindings.bindBidirectional(ptxt2.textProperty(), resultado_.realProperty(), new NumberStringConverter());
		Bindings.bindBidirectional(atxt2.textProperty(), resultado_.imaginarioProperty(), new NumberStringConverter());

		// HBox operaciones2
		HBox operaciones2 = new HBox();
		operaciones2.setAlignment(Pos.CENTER);
		operaciones2.setSpacing(5);
		operaciones2.setDisable(true);
		operaciones2.getChildren().addAll(ptxt2, new Label("+"), atxt2, new Label("i"));

		VBox medio = new VBox();
		medio.setSpacing(5);
		medio.setAlignment(Pos.CENTER);
		medio.getChildren().addAll(operaciones, operaciones1, new Separator(), operaciones2);

		// HBox encabezado
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
