package aula09.agenda1;

import java.util.ArrayList;

public class Agenda {

	private ArrayList<Contato> contatos;
	
	public Agenda() {
		this.contatos = new ArrayList<Contato>();
	}
	
	public void adicionarContato(Contato contato) {
		this.contatos.add(contato);
	}
	
	public ArrayList<Contato> getContatos() {
		return this.contatos;
	}
	
	public String toString() {
		String s = "=== Contatos ===\n";
		for (Contato contato : contatos) {
			s = s + contato + "\n";
		}
		s = s + "================";
		return s;
	}
	
	public Contato buscaContatoPorNome(String nome) {
		for (Contato contato : contatos) {
			if (nome.equals(contato.getNome())) {
				return contato;
			}
		}
		return null; // pode ser melhorada!
	}
	
	public void removerContato(Contato contato) {
		this.contatos.remove(contato);
	}
	
	public void removerContatoPorNome(String nome) {
		Contato contato = this.buscaContatoPorNome(nome);
		if (contato != null) {
			removerContato(contato);
		}
	}
	
}






