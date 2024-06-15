package com.mgs.saudefunci;

public class FunciBasicos {
	private int codigo;
	private String nome;
	private String sobrenome;
	private long telefone; //campo numérico de 11 digitos (11)922334455
	private String email; //versão futura: verificar se eh formato esperado de email
	
	// construtor da classe Funci
	public FunciBasicos(int codigo, String nome, String sobrenome,  
			long telefone, String email) {
				this.codigo = codigo;
				this.nome = nome;
				this.sobrenome = sobrenome;
				this.telefone = telefone;
				this.email=email;	
	}
	
	//Codigo
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	//Nome
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	//Sobrenome
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	
	//Telefone
	public long getTelefone() {
		return telefone;
	}
	public void setTelefone(long telefone) {
		this.telefone = telefone;
	}
	
	//e-mail
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	//retorna dados basicos do funci
	public String toString() {
		return "Código: " + codigo + "\nNome: " + nome + " " + sobrenome + 
				"\nTelefone: " + telefone + "\nEmail: " + email;
	}
	
		
}
