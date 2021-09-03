package banco;

import java.util.HashSet;

public class Cliente {

	// Atributos
	private String nome;
	private HashSet<Conta> contas;

	// Construtor
	public Cliente(String nome) {
		this.nome = nome;
		this.contas = new HashSet<Conta>();
	}

	// Metodos, getters e setters
	public String getNome() {
		return nome;
	}
	
	public String toString() {
		return getNome();
	}
	
	public void adicionaConta(Conta conta) {
		contas.add(conta);
	}
	
	public boolean removeConta(String numero) {
		Conta conta = buscaContaPorNumero(numero);
		if (conta != null) {
			return contas.remove(conta);
		}
		return false;
	}	
	
	public Conta buscaContaPorNumero(String numero) {
		for (Conta conta : contas) {
			if (conta.getNumero().equals(numero)) {
				return conta;
			}
		}
		return null;
	}
	
	public HashSet<Conta> getContas() {
		return contas;		
	}

}
