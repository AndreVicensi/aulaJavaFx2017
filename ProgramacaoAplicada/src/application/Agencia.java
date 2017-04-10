package application;

public class Agencia {
	private String agencia;
	private String numero;

	public Agencia() {
	}

	public String getagencia() {
		return agencia;
	}

	public void setagencia(String agencia) {
		this.agencia = agencia;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Agencia(String agencia, String numero) {
		super();
		this.agencia = agencia;
		this.numero = numero;
	}
	
	@Override
	public String toString() {
		return this.agencia + " " + numero;
	}
}
