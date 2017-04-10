package application;

import java.time.LocalDate;

public class Main_conta {
	
	public static void main(String[] args) {
	
	CalculadoraSaldo calculo = new CalculadoraSaldo();
	LocalDate data = LocalDate.of(2017, 3, 6);
	Cliente cliente1 = new Cliente("cliente1","069",data);
	Cliente cliente2 = new Cliente("cliente2","088",data);	
	Conta conta = new Conta(1, cliente1);
	Conta conta2 = new Conta(2,cliente2);
	conta.depositar(500.00);
	conta2.depositar(200.00);
	System.out.println(conta.getSaldo());
	System.out.println(conta2.getSaldo());
	conta.transferencia(100.0, conta2);
	System.out.println(conta.getSaldo());
	System.out.println(conta2.getSaldo());
	calculo.adicionar(conta);
	calculo.adicionar(conta2);
	System.out.println(calculo.calcular());
	
	
	}
}
