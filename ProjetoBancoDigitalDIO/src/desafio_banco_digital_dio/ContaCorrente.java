package desafio_banco_digital_dio;

import java.util.Random;
import java.util.Scanner;

public class ContaCorrente extends Conta {
	Scanner scan = new Scanner(System.in);
	Random aleatorio = new Random();
	
	public void cadastrarClienteCc() { //Método criado nesta Classe
		System.out.println("Digite seu nome completo: ");
		super.setNomeTitular(scan.nextLine());
		super.setNumConta(aleatorio.nextInt(99999)); //aqui usamos um random para gerar uma conta de 6 dígitos
		System.out.println("Deseja fazer algum depósito inicial?\n" + "[1] Sim\n" + "[0] Não");
		int escolha = scan.nextInt(); 
		if(escolha == 1) { // usamos uma condição para fazer um depósito inicial			
			System.out.println("Digite o valor do depósito inicial:");
			double valor_depo_inicial = scan.nextDouble(); // aqui o valor da variável é o valor do depósito inicial			
			if(valor_depo_inicial > 0) {
				super.setSaldo(valor_depo_inicial); //aqui o valor da variável está atribuindo valor ao método setSaldo() da CC
			}else { 
				while(valor_depo_inicial <= 0) { //Aqui faz com que se você colocar valor <= 0, entrará no laço até que seja depositado um valor positivo
					System.out.println("Impossível depositar valor menor ou igual a zero.");
					System.out.println("Digite o valor do depósito inicial, não pode ser valor menor ou igual a 0");
					valor_depo_inicial = scan.nextDouble();
					super.setSaldo(valor_depo_inicial);
				}
			}			
			System.out.println("Depósito inicial realizado. Seu saldo inicial é: " + super.getSaldo());
			System.out.println("Número da Conta Corrente: " + super.getNumConta());
		}else {
			System.out.println("Abertura efetuada com sucesso!");
			System.out.println("Número da Conta Corrente: " + super.getNumConta());
		}		
	}

	@Override
	public void exibirDados() { //método vindo da classe mãe
		//System.out.println("-----------------------");
		System.out.println("Dados da conta");
		System.out.println("Nome do titular: " + super.getNomeTitular());
		System.out.println("Número conta corrente: " + super.getNumConta());
		//System.out.println("-----------------------");
	}

	@Override
	public void depositar(double valor) {  //método vindo da classe mãe
		if(valor <= 0) {
			System.out.println("Impossível depositar valor menor ou igual a zero.");
		}else {
			super.setSaldo(getSaldo() + valor);
			System.out.println("Deposito realizado com sucesso. Seu novo saldo é: " + super.getSaldo());
		}				
	}

	//@Override
	public void exibirSaldo(ContaCorrente cc, ContaPoupanca cp) {  //método vindo da classe mãe
			System.out.println("Saldo Conta Corrente: " + cc.getSaldo());			
		   	System.out.println("Saldo Conta Poupança: " + cp.getSaldo());
	}

	public void saqueCC(double saque) {  //método criado nesta classe
		if(saque <= super.getSaldo()) { // O parâmetro "double saque" ganhará seu valor através de um Scanner na classe principal. 
			super.setSaldo(getSaldo() - saque); //aqui o valor do saque será deduzido do saldo da CC
			System.out.println("Saque autorizado. Seu saldo é: " + super.getSaldo());
		}else {
			System.out.println("Saque não Autorizado. Saldo Insuficiente");
		}
	}
	
	public void aplicarNaPoupanca(double valor, ContaPoupanca destino) {  //método criado nesta classe
		if(valor <= super.getSaldo()) {
			//destino.setSaldo(getSaldo() + valor); -> tentei fazer desta forma, somando o valor do aplicação diretamente no saldo da CP
			destino.depositar(valor); //aqui o saldo da conta poupança está recebendo o valor
			super.setSaldo(getSaldo() - valor); //aqui o valor aplicado tá saindo do saldo da conta corrente
			System.out.println("Aplicação de " + valor + " na conta "  + destino.getNumConta() + " realizada com sucesso."); //esse getNumConta() se refere ao objeto CP 
		}else {
			System.out.println("Saldo insuficiente para aplicação. Saldo: " + super.getSaldo()); } 			
		}
		
	
	
	
	
	
	

	

}
