package banco;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class MainConsole {

	private ArrayList<Cliente> clientes;
	private ArrayList<Conta> contas;
	private Conta contaAtual;
	
	public MainConsole() {
		clientes = new ArrayList<Cliente>();
		contas = new ArrayList<Conta>();
	}
	
	public int menuSelecao() {
		Scanner sc = new Scanner(System.in);
		System.out.println("1) Cliente");
		System.out.println("2) Gerente");
		System.out.println("3) Sair");
		System.out.println("Digite sua opção: ");
		int opcao = sc.nextInt();
		return opcao;
	}
	
	public int menuGerente() {
		Scanner sc = new Scanner(System.in);
		System.out.println("1) Adicionar cliente");
		System.out.println("2) Remover cliente");
		System.out.println("3) Criar conta");
		System.out.println("4) Voltar");
		System.out.println("Digite sua opção: ");
		int opcao = sc.nextInt();
		return opcao;
	}
	
	public Conta menuCliente() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Digite o numero da conta: ");
		String numero = sc.nextLine();
		System.out.println("Digite a senha: ");
		String senha = sc.nextLine();
		return null;
	}
	
	public int menuConta() {
		Scanner sc = new Scanner(System.in);
		System.out.println("1) Saldo");
		System.out.println("2) Deposito");
		System.out.println("3) Saque");
		System.out.println("4) Voltar");
		System.out.println("Digite sua opção: ");
		int opcao = sc.nextInt();
		return opcao;
	}

	private String dataAtual() {
		Date data = new Date();
		SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
		return formatador.format(data);	
	}
	
	private void saldo() {
		System.out.println("===================================");
		System.out.println("Saldo da conta em: " + dataAtual());
		System.out.println("Conta: " + contaAtual.getNumero());
		System.out.println("Saldo: R$ " + contaAtual.saldo());
		System.out.println("===================================");
	}
	
	private void saque() {
		Scanner sc = new Scanner(System.in);
		System.out.println("===================================");
		System.out.println("Conta: " + contaAtual.getNumero() + " Saldo: R$" + contaAtual.saldo());
		System.out.println("Digite o valor para saque: R$ ");
		float valor = sc.nextFloat();
		if (contaAtual.saque(valor)) {
			System.out.println("Saque realizado com sucesso!");
		} else {
			System.out.println("Não foi possível realizar o saque com o valor solicitado!");
		}
		System.out.println("===================================");
	}
	
	private void deposito() {
		Scanner sc = new Scanner(System.in);
		System.out.println("===================================");
		System.out.println("Digite o valor para depósito: R$ ");
		float valor = sc.nextFloat();
		if (contaAtual.deposito(valor)) {
			System.out.println("Depósito realizado com sucesso!");
		} else {
			System.out.println("Não foi possível realizar o depósito para o valor informado!");
		}
		System.out.println("===================================");
	}

	public static void main(String[] args) {
		MainConsole mainConsole = new MainConsole();
		boolean continuar = true;
		do {
			int opcao = 0;
			opcao = mainConsole.menuSelecao();
			if (opcao == 1) { // cliente
				mainConsole.mainCliente();
			} else if (opcao == 2) { // gerente
				mainConsole.mainGerente();
			} else if (opcao == 3) { // sair
				continuar = false;
			} else {
				System.out.println("opção inválida!");
			}
			
		} while (continuar);
	}

	private void mainGerente() {
		int opcao = 0;
		boolean continuar = true;
		do {
			opcao = menuGerente();
			switch (opcao) { 
			    case 1: // Adicionar cliente
			    	adicionarCliente();
			    	break;
			    case 2: // Remover cliente
			    	removerCliente();
			    	break;
			    case 3: // Criar conta
			    	criarConta();
			    	break;
			    case 4: // Voltar
			    	continuar = false;
			    	break;
			    default:
			    	System.out.println("Opção inválida!");
			}
		} while (continuar);
	}

	private void criarConta() {
		Cliente cliente = selecionarCliente();
		Scanner sc = new Scanner(System.in);
		System.out.println("1) Nova conta corrente");
		System.out.println("2) Nova conta poupança");
		System.out.println("Digite sua opção: ");
		int opcao = sc.nextInt();
		
		sc.nextLine();

		System.out.println("Digite a senha da conta: ");
		String senha = sc.nextLine();

		Conta novaConta = null;
		if (opcao == 1) {
			novaConta = new ContaCorrente("42" + contas.size(), senha, cliente);
			System.out.println("Conta Corrente " + novaConta + "foi criada com sucesso!");
		} else {
			novaConta = new ContaPoupanca("42" + contas.size(), senha, cliente);
			System.out.println("Conta Poupança " + novaConta + "foi criada com sucesso!");
		}
		contas.add(novaConta);
	}

	private Cliente selecionarCliente() {
		listarClientes();
		Scanner sc = new Scanner(System.in);
		System.out.println("Digite o código do cliente: ");
		int index = sc.nextInt();
		return clientes.get(index-1);
	}

	private void listarClientes() {
		System.out.println("=== Clientes ===");
		int codigo = 1;
		for (Cliente c : clientes) {
			System.out.println(codigo + " " + c);
			codigo++;
		}
		System.out.println("================");
	}

	private void removerCliente() {
		System.out.println("Não implementado ainda!");
	}

	private void adicionarCliente() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Digite o nome: ");
		String nome = sc.nextLine();
		
		Cliente novoCliente = new Cliente(nome);
		clientes.add(novoCliente);
	}

	private void mainCliente() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Digite o numero da conta: ");
		String numero = sc.nextLine();
		
		Conta c = selecionaContaPorNumero(numero);
		
		System.out.println("Digite a senha da conta: ");
		String senha = sc.nextLine();
		if (c.verificaConta(senha)) {
			this.contaAtual = c;
			mainConta();
		} else {
			System.out.println("Senha incorreta!");
		}
	}

	private Conta selecionaContaPorNumero(String numero) {
		for (Conta c : contas) {
			if (c.getNumero().equals(numero)) {
				return c;
			}
		}
		return null;
	}

	private void mainConta() {
		int opcao = 0;
		boolean continuar = true;
		do {
			opcao = menuConta();
			switch (opcao) {
			case 1:
				saldo();
				break;
			case 2:
				deposito();
				break;
			case 3:
				saque();
				break;
			case 4:
				this.contaAtual = null;
				continuar = false;
				break;
			default:
				System.out.println("Opção inválida!");
				break;
			}
		} while (continuar);
	}
	
}
