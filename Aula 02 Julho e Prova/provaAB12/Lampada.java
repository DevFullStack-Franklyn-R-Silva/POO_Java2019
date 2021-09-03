package provaAB12;

/*
 * Escreva uma classe "Lâmpada", que deve ter o atributo
 * estado, o qual deve indicar se a lâmpada se encontra ligada 
 * ou desligada. A classe deve ter um construtor que crie uma 
 * lâmpada inicialmente desligada, e os métodos acende(), que 
 * altera o estado da lâmpada para "ligada", apaga(), que altera
 * o estado da lâmpada para "desligada", e "exibeEstado()", que
 * informa se ela se encontra "ligada" ou "desligada".
 */
public class Lampada {

	private boolean estado;
	
	public Lampada() {
		this.estado = false;
	}
	
	public void acende() {
		this.estado = true;
	}
	
	public void apaga() {
		this.estado = false;
	}
	
	public String exibeEstado() {
		if (this.estado) {
			return "ligada";
		} else {
			return "desligada";
		}
	}

}
