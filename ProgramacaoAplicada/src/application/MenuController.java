package application;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;


public class MenuController {
	 @FXML
	    private BorderPane bpPrincipal;

	    @FXML
	    private MenuItem mAgencia;

	    @FXML
	    private MenuItem mCliente;
	    
	    @FXML
	    private MenuItem mMovimento;
	    
	    
	    
	    @FXML
	    void onAgencia(ActionEvent event){
	    	FXMLLoader loader = new FXMLLoader();
	    	loader.setLocation(getClass().getResource("AgenciaForm.fxml"));
	    	try{
	    		AnchorPane agenciaView = (AnchorPane) loader.load();
	    		bpPrincipal.setCenter(agenciaView);
	    	} catch (IOException el) {
				el.printStackTrace();
			}
	    }
	    
	    @FXML
	    void onCliente(ActionEvent event){
	    	FXMLLoader loader = new FXMLLoader();
	    	loader.setLocation(getClass().getResource("ClienteForm.fxml"));
	    	try{
	    		AnchorPane clienteView = (AnchorPane) loader.load();
	    		bpPrincipal.setCenter(clienteView);
	    	} catch (IOException el) {
				el.printStackTrace();
			}
	    }
	    
	    @FXML
	    void onMovimento(ActionEvent event){
	    	FXMLLoader loader = new FXMLLoader();
	    	loader.setLocation(getClass().getResource("MovimentosForm.fxml"));
	    	try{
	    		AnchorPane movimentoView = (AnchorPane) loader.load();
	    		bpPrincipal.setCenter(movimentoView);
	    	} catch (IOException el) {
				el.printStackTrace();
			}
	    }
	    
	    @FXML
	    void onConta(ActionEvent event){
	    	FXMLLoader loader = new FXMLLoader();
	    	loader.setLocation(getClass().getResource("ContaForm.fxml"));
	    	try{
	    		AnchorPane movimentoView = (AnchorPane) loader.load();
	    		bpPrincipal.setCenter(movimentoView);
	    	} catch (IOException el) {
				el.printStackTrace();
			}
	    }
	    
}
