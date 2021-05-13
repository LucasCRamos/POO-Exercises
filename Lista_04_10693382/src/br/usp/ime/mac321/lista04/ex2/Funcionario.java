package br.usp.ime.mac321.lista04.ex2;

public class Funcionario {
	
	private String primeiroNome;
	private String segundoNome;
	private String setor;
	private double salario;
	private boolean funcionarioAtivo = true;
	
	public Funcionario(String primeiroNome, String segundoNome, String setor, double salario) {
		
		this.primeiroNome = primeiroNome;
		this.segundoNome = segundoNome;
		this.setor = setor;
		this.salario = salario;
				
	}
	
	String nomeCompletoFormatado() {
		
		return primeiroNome + " " + segundoNome;
	}
	
	String salarioFormatado() {
	
		String salarioString = String.format("%.2f", salario);

		return "R$"+salarioString;
	}
	
	void aumentarSalario(double valor) {
		
		if (valor >= 0) salario = salario+valor;
		
	}
	
	boolean trocarDepartamento(String novoCodigo) {
		
		if (novoCodigo.length() != 3) {
			
			return false;
		}
		
		else
			
			setor = novoCodigo;
			return true;
	}
	
	String departamentoFormatado() {
		
		return "Departamento " + setor;
	}
	
	String informacoesFormatadas() {
		
		return nomeCompletoFormatado() + ", " + salarioFormatado() + ", " + departamentoFormatado(); 
	}
	
	boolean ativo() {
		
		if (funcionarioAtivo == true) return true;
		
		else return false;
		
	}
	
	void demitirFuncionario() {
		
		funcionarioAtivo = false;
		
	}
	
	
}
