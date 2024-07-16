package desafio_banco_digital_dio;

public abstract class Conta {

	private String nomeTitular;
	private int numConta;
	private double saldo;
	
	
	public String getNomeTitular() {
		return nomeTitular;
	}
	public void setNomeTitular(String nomeTitular) {
		this.nomeTitular = nomeTitular;
	}
	public int getNumConta() {
		return numConta;
	}
	public void setNumConta(int numConta) {
		this.numConta = numConta;
	}	
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	public void exibirDados() {
		
	}
		
	public void exibirSaldo(ContaCorrente cc, ContaPoupanca cp ) {
		
	}
	
	public abstract void depositar(double valor);		
		
	
			
	

	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
}
