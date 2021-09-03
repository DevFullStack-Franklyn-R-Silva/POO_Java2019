package provaAB12;

import java.util.ArrayList;

public class Casa {

	public static final String SALA     = "Sala";
	public static final String COZINHA  = "Cozinha";
	public static final String QUARTO   = "Quarto";
	public static final String BANHEIRO = "Banheiro";
	
	private ArrayList<Comodo> comodos;
	
	public Casa() {
		comodos = new ArrayList<Comodo>();
		Comodo c = new Comodo(SALA);
		comodos.add(c);
		c = new Comodo(COZINHA);
		comodos.add(c);
		c = new Comodo(QUARTO);
		comodos.add(c);
		c = new Comodo(BANHEIRO);
		comodos.add(c);
	}
	
	public void acende(String nomeComodo) {
		Comodo c = getComodoPorNome(nomeComodo);
		c.acende();
	}
	
	public void apaga(String nomeComodo) {
		Comodo c = getComodoPorNome(nomeComodo);
		c.apaga();
	}

	private Comodo getComodoPorNome(String nomeComodo) {
		for (Comodo comodo : comodos) {
			if (comodo.getNome().equals(nomeComodo)) {
				return comodo;
			}
		}

		return null;
	}
	
}
