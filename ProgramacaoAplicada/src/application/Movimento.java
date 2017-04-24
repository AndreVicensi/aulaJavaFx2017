package application;

public class Movimento {
	
	private Double valor;
	private String tipo;
	
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Movimento() {
		super();
	}
	
	@Override
	public String toString() {
		return tipo + " " + valor.toString();
	}
	
}
