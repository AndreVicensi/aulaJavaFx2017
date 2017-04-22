package application;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class ContaController {

   
    @FXML
    private TextField tfnumero;

    @FXML
    private Button dtnsalvar;

    @FXML
    private Button dtnexcluir;

    @FXML
    private Button dtnnovo;

    @FXML
    private TableView<Conta> tblConta;

    @FXML
    private TableColumn<Conta, String> tbcNumero;

    @FXML
    private TableColumn<Conta, String> tbcAgencia;

    @FXML
    private ComboBox<Agencia> cbAgencia;
    
    @FXML
    private ComboBox<Cliente> cbxCliente;
    
    private boolean editando;
    private Conta conta;
    
    @FXML
    public void initialize(){
    	tbcNumero.setCellValueFactory(new PropertyValueFactory<>("numero"));
    	tbcAgencia.setCellValueFactory(new PropertyValueFactory<>("agencia"));
    	cbAgencia.setItems(FXCollections.observableArrayList(SimuladorDB.getAgencias()));
    	cbxCliente.setItems(FXCollections.observableArrayList(SimuladorDB.getClientes()));
    	tblConta.setItems(FXCollections.observableArrayList(SimuladorDB.getContas()));
    	novo();
    }
    
    private void novo(){
    	editando = false;
    	conta = new Conta();
    	limparCampos();
    }

    private void limparCampos(){
    	tfnumero.setText("");
    }
    
    
    
    @FXML
    void onEditar(MouseEvent event) {
    	if(event.getEventType().equals(MouseEvent.MOUSE_CLICKED)){
        	conta =  tblConta.getSelectionModel().getSelectedItem();
        	cbxCliente.setValue(conta.getCliente());
        	tfnumero.setText(conta.getNumero().toString());
        	cbAgencia.setValue(conta.getAgencia());
        	editando = true;
        	}
    }

    @FXML
    void onexcluir(ActionEvent event) {
    	tblConta.getItems().remove(conta);
    	SimuladorDB.remover(conta);
    	limparCampos();
    }

    @FXML
    void onnovo(ActionEvent event) {
    	novo();
    }

    @FXML
    void onsalvar(ActionEvent event) {
    	conta.setAgencia(cbAgencia.getValue());
    	conta.setNumero(Integer.parseInt(tfnumero.getText()));
    	conta.setCliente(cbxCliente.getValue());
    	if(editando){
    		tblConta.refresh();
    	} else {
    		SimuladorDB.insert(conta);
    		tblConta.getItems().add(conta);
    	}
    	novo();
    }

}
