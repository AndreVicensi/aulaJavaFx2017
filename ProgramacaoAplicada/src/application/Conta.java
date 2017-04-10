package application;

public class Conta {

	private Integer numero;
	private Cliente cliente;
	private Double saldo;
	
	public Conta(){
		saldo = 0.0;
	}
	
	public Conta(Integer numero, Cliente cliente) {
		super();
		this.numero = numero;
		this.cliente = cliente;
		saldo = 0.0;
	}

	public void depositar(Double valor){
		saldo += valor;
	}
	
	public boolean sacar(Double valor){
		if(saldo >= valor){
		saldo -= valor;
		return true;
		} else {
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
	
}
