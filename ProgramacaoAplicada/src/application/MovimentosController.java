package application;


import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class MovimentosController {

    @FXML
    private TextField tfValor;

    @FXML
    private Button dtnsalvar;

    @FXML
    private TableView<Movimento> tblMovimentos;

    @FXML
    private TableColumn<Movimento, String> tbcTipo;

    @FXML
    private TableColumn<Movimento, String> tbcValor;

    @FXML
    private ComboBox<Conta> cbxConta;

    @FXML
    private RadioButton rdSaque;

    @FXML
    private RadioButton rdDeposito;

    @FXML
    private TextField tfNumero;

    @FXML
    private TextField tfCliente;

    @FXML
    private Label lbValor;
    private Movimento movimento;
    
    @FXML
    public void initialize(){
    	tbcTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
    	tbcValor.setCellValueFactory(new PropertyValueFactory<>("valor"));
    	cbxConta.setItems(FXCollections.observableArrayList(SimuladorDB.getContas()));
    	tblMovimentos.setItems(FXCollections.observableArrayList(SimuladorDB.getMovimento()));
    	novo();
    }
    
    private void novo(){
    	 movimento = new Movimento();
    	limparCampos();
    }

    private void limparCampos(){
    	tfCliente.setText("");
    	tfNumero.setText("");
    	tfValor.setText("");
    	tblMovimentos.refresh();
    	limparBotoes();
    }
    
    private void limparBotoes(){
    	rdDeposito.setSelected(false);
    	rdSaque.setSelected(false);
    }

    @FXML
    void onsalvar(ActionEvent event) {
    	movimento.setValor(Double.parseDouble(tfValor.getText()));
    	if(rdSaque.isSelected()){
    		cbxConta.getValue().sacar(movimento.getValor());
    		movimento.setTipo("Saque");
    	} else if (rdDeposito.isSelected()){
    		cbxConta.getValue().depositar(movimento.getValor());
    		movimento.setTipo("Deposito");
    	}
    	SimuladorDB.insert(movimento);
    	tblMovimentos.getItems().add(movimento);
    	lbValor.setText(cbxConta.getValue().getSaldo().toString());
    	novo();
    }
    
    @FXML
    void OnDeposito(ActionEvent event) {
    	if(rdDeposito.isSelected()){
    		rdSaque.setSelected(false);
    	}
    }

    @FXML
    void OnSaque(ActionEvent event) {
    	if(rdSaque.isSelected()){
    		rdDeposito.setSelected(false);
    	}
    }
  
}
