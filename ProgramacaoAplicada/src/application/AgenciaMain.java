package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class AgenciaMain extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			//elemento principal do layout, elemento inicial do xml.
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("AgenciaForm.fxml"));
			//responsavel por mostrar os elementos do layout
			Scene scene = new Scene(root);
			//folha de estilo (css) para formatcao dos elementos na tela
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			//preparacao do stage para mostrar o conteudo da scene
			primaryStage.setScene(scene);
			//mostra a tela para o usuario
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
			
}
