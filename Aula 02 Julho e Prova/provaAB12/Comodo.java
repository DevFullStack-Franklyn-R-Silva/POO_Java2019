package provaAB12;

public class Comodo {

	private String nome;
	private Lampada lampada;

	public Comodo(String nome) {
		this.nome = nome;
		this.lampada = new Lampada();
	}

	public String getNome() {
		return nome;
	}

	public void acende() {
		this.lampada.acende();
	}
	
	public void apaga() {
		this.lampada.apaga();
	}

}
