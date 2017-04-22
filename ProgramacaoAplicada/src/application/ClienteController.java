package application;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class ClienteController {

    @FXML
    private TextField tfnome;

    @FXML
    private TextField tfcpf;

    @FXML
    private DatePicker dtdatanascimento;

    @FXML
    private Button dtnsalvar;
    
    @FXML
    private ListView<Cliente> lvCliente;
    private Cliente cliente;
    private boolean editando;
    
    @FXML
    private ComboBox<Agencia> cbxAgencia;
    
    @FXML
    public void initialize(){
    	lvCliente.setItems(FXCollections.observableArrayList());
    	cbxAgencia.setItems(FXCollections.observableArrayList(SimuladorDB.getAgencias()));
    	novo();
    }
    
    private void novo(){
    	editando = false;
    	cliente = new Cliente();
    	limparCampos();
    }
    
    private void limparCampos(){
    	tfnome.setText("");
    	tfcpf.setText("");
    	dtdatanascimento.setValue(null);
    }
    
    @FXML
    void onsalvar(ActionEvent event) {
    	cliente.setNome(tfnome.getText());
    	cliente.setCpf(tfcpf.getText());
    	cliente.setData_nascimento(dtdatanascimento.getValue());
    	cliente.setAgenciaPreferencial(cbxAgencia.getValue());
    	if(editando){
    		lvCliente.refresh();
    	} else {
    		SimuladorDB.insert(cliente);
    		lvCliente.getItems().add(cliente);
    	}
    	novo();
    }
    
    @FXML
    void onEditar(MouseEvent event){
    	if(event.getEventType().equals(MouseEvent.MOUSE_CLICKED)){
    	cliente =  lvCliente.getSelectionModel().getSelectedItem();
    	tfnome.setText(cliente.getNome());
    	tfcpf.setText(cliente.getCpf());
    	dtdatanascimento.setValue(cliente.getData_nascimento());
    	// pega do objeto e coloca no combobox
    	cbxAgencia.setValue(cliente.getAgenciaPreferencial());
    	editando = true;
    	}
    }
    
}
