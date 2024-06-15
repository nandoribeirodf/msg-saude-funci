package com.mgs.saudefunci;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Esse modulo controlador pretende regrar interatividade do usuario com o cadastro de funcionarios em tempo real para acessar informacoes de saude
//Esse modulo pedente de acesso privilegiado, por se tratar de informações de saude, consideradas sensiveis pela LGPD do Brasil

public class FunciController {

	// Lista de funcis
	private ArrayList<FunciCadastro> funcis = new ArrayList<FunciCadastro>();

	// adiciona funcis ao cadastro
	public void adicionarFunci(FunciCadastro funci) {
		funcis.add(funci);
	}

	// busca um funci no cadastro conforme codigo
	public FunciCadastro buscarFunci(int codigo) {
		// busca o codigo na lista de funcis
		for (FunciCadastro f : funcis) {
			if(f.getCodigo() == codigo) {
				return f;
			}
		}
		//se nao encontrar retorna nulo #sugestão chatGPT
		return null;
	}
	
	private void carregaFuncisExemplo() {
		FunciBasicos basico1 = new FunciBasicos(101010, "João", "Silva", 11987654321L, "joao.silva@example.com"); //Dica do chatGPT: usar o L ao fim do telefone para mostrar tipo long
		FunciSaude saude1 = new FunciSaude(Arrays.asList("Poeira", "Pólen"), Arrays.asList("Asma")); //Dica do chatGPT: usar o L ao fim do telefone para mostrar tipo long
		FunciBasicos basico2 = new FunciBasicos(202020, "Maria", "Santos", 11987654322L, "maria.santos@example.com");
		FunciSaude saude2 = new FunciSaude(Arrays.asList("Pólen"), Arrays.asList("Diabetes", "Hipertensão"));
		FunciBasicos basico3 = new FunciBasicos(303030, "Pedro", "Alves", 11987654323L, "pedro.alves@example.com");
		FunciSaude saude3 = new FunciSaude(Arrays.asList("Glúten"), Arrays.asList("Hipertensão"));

		adicionarFunci(new FunciCadastro(basico1, saude1));
		adicionarFunci(new FunciCadastro(basico2, saude2));
		adicionarFunci(new FunciCadastro(basico3, saude3));
	}
	public void listaFuncis() {
		if (funcis.isEmpty()) {
			System.out.println("Nenhum funcionário cadastrado!");
		} else {
			System.out.println("Lista de funcionários cadastrados:");
			for (FunciCadastro f : funcis) {
				System.out.println(f);
				System.out.println("===========");
			}
		}
	}
	
	// metodo principal
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scannerMenu = new Scanner(System.in);
		FunciController sistema = new FunciController();
		
		//Carregar dados de exemplo
		sistema.carregaFuncisExemplo();
		
		//Menu Inicial
		while(true) {
			System.out.println("1 Adicionar Funcionário");
			System.out.println("2 Exibir Funcionário");
			System.out.println("3 Exibir Todos os Funcionários");
			System.out.println("4 Sair");
			int selecao = scannerMenu.nextInt(); //chatGPT para Scanner e nextInt()
			scannerMenu.nextLine();
			
			if (selecao == 1) {
				//cadastra novo funci 
				System.out.println("Digite o codigo do novo funci:");
				int codigo = scannerMenu.nextInt();
				scannerMenu.nextLine();
				
				System.out.println("Digite o sobrenome do novo funci:");
				String sobrenome = scannerMenu.nextLine();
				
				System.out.println("Digite o nome do novo funci:"); //A inversao de nome e sobrenome é para evitar que o nome completo seja digitado no primeiro campo
				String nome = scannerMenu.nextLine();
				
				System.out.println("Digite as alergias do novo funci, separadas por vírgula:"); //Exemplo do chatGPT para construcao dessa implementacao.
				List<String> alergias = new ArrayList<String>();
				String alergiasInseridas = scannerMenu.nextLine();
				for (String alergia : alergiasInseridas.split(",")) {
					alergias.add(alergia.trim()); //uso do TRIM para limpar espaços excessivos no texto
				}
				
				System.out.println("Digite as questões médicas importantes do novo funci, separadas por vírgula:");
				List<String> questoesMedicas = new ArrayList<String>();
				String questoesMedicasInseridas = scannerMenu.nextLine();
				for (String questaoMedica : questoesMedicasInseridas.split(",")) {
					questoesMedicas.add(questaoMedica.trim());
				}
				
				//Coleta e valida o telefone
				long telefone = 0;
				while(true) {
					System.out.println("Digite o telefone com 11 dígitos:");
					String telefoneInserido = scannerMenu.nextLine();
					if ( telefoneInserido.matches("\\d{11}")) {
						//chatGPT para construção dessa verificação
						telefone = Long.parseLong(telefoneInserido);
						break;
					} else {
						System.out.println("Telefone deve conter 11 dígitos. Informe:");
					}
				}
					
				System.out.println("Digite o email do novo funci:");
				String email = scannerMenu.nextLine();
				
				//Cria o novo funcionario
				FunciBasicos dadosBasicos = new FunciBasicos(codigo, nome, sobrenome, telefone, email);
				FunciSaude dadosSaude = new FunciSaude(alergias, questoesMedicas);
				FunciCadastro f = new FunciCadastro(dadosBasicos, dadosSaude);
				sistema.adicionarFunci(f);

			} else if (selecao == 2) {
				// Esse item retorna os dados do funci a partir do codigo informado
				System.out.println("Informe o codigo do funcionário para pesquisar:");
				int codigo = scannerMenu.nextInt();
				scannerMenu.nextLine();
				FunciCadastro f = sistema.buscarFunci(codigo);
				if (f == null) {
					System.out.println("Funci de código " + codigo + " não foi encontrado");
				} else {
					System.out.println(f);
				}
			} else if (selecao == 3) {
				// Lista todos os funcis
				sistema.listaFuncis();
			} else if (selecao == 4) {
				break;
			}
		}
		scannerMenu.close();
	}
}
