package application;

import java.util.ArrayList;
import java.util.List;

public class CalculadoraSaldo {
	
	List<Conta> contas = new ArrayList<Conta>();
	
	 public void adicionar(Conta conta){
		 contas.add(conta);
	 }
	
	 public Double calcular(){
		 /*
		 Double soma = 0.0;
		 
		 for(Conta conta: contas){
			 soma += conta.getSaldo();
		 }
		 */
		 return contas.stream().mapToDouble(Conta::getSaldo).sum();
	 }
	
}
