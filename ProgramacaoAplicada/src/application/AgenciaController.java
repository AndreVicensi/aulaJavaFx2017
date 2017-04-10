package application;


import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class AgenciaController {

    @FXML
    private TextField tfagencia;

    @FXML
    private TextField tfnumero;

    @FXML
    private Button dtnsalvar;
    
    @FXML
    private Button dtnexcluir;

    @FXML
    private Button dtnnovo;

    private Agencia agencia;
    @FXML
    private ListView<Agencia> lvagencia;
    private boolean editando;
    
    @FXML
    public void initialize(){
    	lvagencia.setItems(FXCollections.observableArrayList());
    	novo();
    }
    
    private void novo(){
    	editando = false;
    	 agencia= new Agencia();
    	limparCampos();
    }
    
    private void limparCampos(){
    	tfagencia.setText("");
    	tfnumero.setText("");
    }
    

    @FXML
    void onEditar(MouseEvent event) {
    	if(event.getEventType().equals(MouseEvent.MOUSE_CLICKED)){
    	agencia =  lvagencia.getSelectionModel().getSelectedItem();
    	tfagencia.setText(agencia.getagencia());
    	tfnumero.setText(agencia.getNumero());
    	editando = true;
    	}
    }

    @FXML
    void onexcluir(ActionEvent event) {
        	lvagencia.getItems().remove(agencia);
        	limparCampos();
    }

    @FXML
    void onnovo(ActionEvent event) {
    	novo();
    }

    @FXML
    void onsalvar(ActionEvent event) {
    	agencia.setagencia(tfagencia.getText());
    	agencia.setNumero(tfnumero.getText());
    	if(editando){
    		lvagencia.refresh();
    	} else {
    		lvagencia.getItems().add(agencia);
    	}
    	novo();
    }

}
