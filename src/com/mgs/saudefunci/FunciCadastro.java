package com.mgs.saudefunci;

public class FunciCadastro {
	private FunciBasicos dadosBasicos;
	private FunciSaude dadosSaude;
	
	public FunciCadastro(FunciBasicos dadosBasicos, FunciSaude dadosSaude) {
		this.dadosBasicos = dadosBasicos;
		this.dadosSaude = dadosSaude;
	}
	
	public FunciBasicos getDadosBasicos() {
		return dadosBasicos;
	}
	
	public FunciSaude getDadosSaude() {
		return dadosSaude;
	}
	
	public int getCodigo() {
		return dadosBasicos.getCodigo();
	}
	
	@Override //Sugestão chatGPT para garantir a substituição do método
	public String toString() {
		return dadosBasicos.toString() + "\n" + dadosSaude.toString();
	}
}
