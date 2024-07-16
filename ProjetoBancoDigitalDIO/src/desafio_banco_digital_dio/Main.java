package desafio_banco_digital_dio;

//import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {	
		
		Scanner scan = new Scanner(System.in);
		
		
		ContaCorrente cc = new ContaCorrente();	
		ContaPoupanca cp = new ContaPoupanca();
			
		System.out.println("*---*---*---*---*---*---*---*---*");
		System.out.println("Seja bem-vindo ao Banco DIO!");
		System.out.println("*---*---*---*---*---*---*---*---*");
		System.out.println("Deseja abrir uma conta?\n" + "[1] Para Sim\n" + "[0] Para Sair");
		int resposta = scan.nextInt();
		if(resposta == 1) { //se a condição for verdadeira, ele vai execultar a lógica do método cadastrarCliente lá da classe conta corrente
			cc.cadastrarClienteCc(); // aqui será realizado a abertura da CC, o código para abertura conta está no método: cadastrarClienteCc()
			cp.abrirContaPoupanca(); // aqui será gerado o número da conta poupança lá no método abrirContaPoupanca()
		}else {
			System.out.println("Obrigado por acessar o Banco DIO, até logo!");
		}
		if(resposta == 1) { // aqui é para entrar no menu de opções mesmo após a abertura da conta sem o depósito inicial
			int opcao = 9;	 
			do {
			System.out.println("                    ");	//para da uma separação entre as frases
			System.out.println("O que deseja fazer? ");
			System.out.println("                    ");	
			System.out.println("[1] Depositar\n" + "[2] Sacar\n" + "[3] Resgatar\n" + "[4] Aplicar\n" + "[5] Exibir Dados\n" + "[6] Exibir Saldo\n" + "[0] Sair\n");			
			 opcao = scan.nextInt();		 
			if(opcao == 1) {
				System.out.println("Digite o valor do depósito:");
				cc.depositar(scan.nextDouble());
			}else if(opcao == 2) {
				System.out.println("Digite o valor do saque:");
				cc.saqueCC(scan.nextDouble()); // aqui o método saque recebe o scanner no seu parâmetro que seria o valor do saque
			}else if(opcao == 3) {
				System.out.println("Digite o valor do Resgate:");
				cp.resgatePoupanca(scan.nextDouble(), cc); //esse acanner é o valor do parâmetro lá na classe poupança
			}else if(opcao == 4) {
				System.out.println("Digite o valor da Aplicação:");
				cc.aplicarNaPoupanca(scan.nextDouble(), cp); //esse scanner é o valor do parâmetro lá da classe conta corrente
			}else if(opcao == 5) {
				cc.exibirDados(); //esse método faz exibir nome do titular e número da conta corrente
				System.out.println("Número conta poupança: " + cp.getNumConta());// exibir o número da conta poupança
			}else if(opcao == 6) {
				cc.exibirSaldo(cc, cp);
			}else if(opcao == 0) {
				System.out.println("Obrigado por acessar o Banco DIO, até logo!");
			}																						
			}while (opcao != 0);					 					 					 					
		}
		
		
		
	}

}
