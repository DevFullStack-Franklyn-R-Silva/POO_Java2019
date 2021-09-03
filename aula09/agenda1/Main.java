package aula09.agenda1;

import java.util.Scanner;

public class Main {
	
	private Agenda agenda;
	
	public Main() {
		agenda = new Agenda();
	}

	private int menu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("1) Cadastrar contato");
		System.out.println("2) Listar contatos");
		System.out.println("3) Remover contato");
		System.out.println("4) Sair");
		System.out.println("Digite sua opção: ");
		int opc = sc.nextInt();
		
		return opc;
	}
	
	private void executar() {
		Scanner sc = new Scanner(System.in);
		
		boolean continuar = true;
		while (continuar) {
			int opc = menu();
			switch (opc) {
				case 1:
					System.out.println("Nome: ");
					String nome = sc.nextLine();
					System.out.println("Email: ");
					String email = sc.nextLine();
					Contato contato = new Contato(nome, email);
					agenda.adicionarContato(contato);
					break;
				case 2:
					System.out.println(agenda);
					break;
				case 3:
					// exibindo contatos
					System.out.println(agenda);
					// solicitando o nome
					System.out.println("Nome: ");
					String nome1 = sc.nextLine();
					// removendo
					agenda.removerContatoPorNome(nome1);
					break;
				case 4:
					continuar = false;
					break;
				default:
					break;
			}
		}
	}
	
	public static void main(String[] args) {
		Main programa = new Main();
		programa.executar();
	}

}



