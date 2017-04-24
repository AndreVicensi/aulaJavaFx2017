package application;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Conta {

	private Integer numero;
	private Cliente cliente;
	private Double saldo;
	private Agencia agencia;
	
	public Conta(){
		saldo = 0.0;
	}
	
	public Conta(Agencia agencia ,Integer numero, Cliente cliente) {
		super();
		this.numero = numero;
		this.cliente = cliente;
		this.agencia = agencia;
		saldo = 0.0;
	}

	public Agencia getAgencia() {
		return agencia;
	}

	public void setAgencia(Agencia agencia) {
		this.agencia = agencia;
	}

	public void depositar(Double valor){
		saldo += valor;
	}
	
	public boolean sacar(Double valor){
		if(saldo >= valor){
		saldo -= valor;
		return true;
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Erro ");
			alert.setHeaderText("Saldo insuficiente");
			alert.setContentText("Conta sem saldo!");
			alert.showAndWait();
			System.out.println("saldo insuficiente");
			return false;
		}
	}
	
	public boolean transferencia(Double valor,Conta destino){
		if(this.sacar(valor)){
			destino.depositar(valor);
			return true;
		}
		return false;
	}
	
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Double getSaldo() {
		return saldo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	@Override
	public String toString() {
		return numero + " " + agencia;
	}
	
	public void setNomeCliente(String nome){
		cliente.setNome(nome);
	}
	
	public String getNomeCliente(){
		return cliente.getNome();
	}
	
}
