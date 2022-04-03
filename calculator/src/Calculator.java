import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Calculator extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {        
		Scene scene = new Scene(new CalculatorPane(), 350, 450);
		primaryStage.setTitle("Calculator");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}