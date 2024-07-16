package desafio_banco_digital_dio;

import java.util.Random;
import java.util.Scanner;

public class ContaPoupanca extends Conta{
	Scanner scan = new Scanner(System.in);
	Random aleatorio = new Random();

		
	public void resgatePoupanca(double valor, ContaCorrente destino) { //método criado nesta classe
		if(valor <= super.getSaldo()) {
			//destino.setSaldo(getSaldo() + valor); -> tentei fazer desta forma, somando o valor do resgate diretamente no saldo da CC.
			//											Não da erro, mas o valor vai dobrado, não entendi o porquê.
			destino.depositar(valor);	//Aqui o valor está sendo colocado no método depositar da CC e consequentemente caindo no saldo da CC. Em outras palavras, é um depósito na CC 				
			super.setSaldo(getSaldo() - valor);
			System.out.println("Resgate efetuado. Saldo Conta Poupança após o resgate: " + super.getSaldo());
		}else {
			System.out.println("Valor do resgate maior que o saldo disponível. Seu saldo é: " + super.getSaldo());
		}				
	}
	@Override
	public void depositar(double valor) { //esse método está sendo usando para receber valores de aplicação realizado na classe CC
		super.setSaldo(getSaldo() + valor);		
	}
	
	public void abrirContaPoupanca() {
		super.setNumConta(aleatorio.nextInt(99999)); 
		System.out.println("Número da Conta Poupança: " + super.getNumConta());// + "-" + NumAposDigito); //Concatenei número da conta + " - " + 
																								   //variável aleatória após o dígito
	}
	
	
	
	
	
}
