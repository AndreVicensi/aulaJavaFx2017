package application;


import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
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
    private TableView<Agencia> tblAgencia;
    private boolean editando;
    
    @FXML
    private TableColumn<Agencia, String> tbcNumero;
    
    @FXML
    private TableColumn<Agencia, String> tbcNome;
    
    
    @FXML
    public void initialize(){
    	
    	tbcNumero.setCellValueFactory(new PropertyValueFactory<>("numero"));
    	tbcNome.setCellValueFactory(new PropertyValueFactory<>("agencia"));
    	tblAgencia.setItems(FXCollections.observableArrayList(SimuladorDB.getAgencias()));
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
    	agencia =  tblAgencia.getSelectionModel().getSelectedItem();
    	tfagencia.setText(agencia.getAgencia());
    	tfnumero.setText(agencia.getNumero());
    	editando = true;
    	}
    }

    @FXML
    void onexcluir(ActionEvent event) {
        	tblAgencia.getItems().remove(agencia);
        	SimuladorDB.remover(agencia);
        	limparCampos();
    }

    @FXML
    void onnovo(ActionEvent event) {
    	novo();
    }

    @FXML
    void onsalvar(ActionEvent event) {
    	agencia.setAgencia(tfagencia.getText());
    	agencia.setNumero(tfnumero.getText());
    	if(editando){
    		tblAgencia.refresh();
    	} else {
    		SimuladorDB.insert(agencia);
    		tblAgencia.getItems().add(agencia);
    	}
    	novo();
    }

}
