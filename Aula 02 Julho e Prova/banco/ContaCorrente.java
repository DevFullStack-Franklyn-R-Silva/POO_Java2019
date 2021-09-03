package banco;

public class ContaCorrente extends Conta {

	private final float TAXA = 5.0f; 
	
	public ContaCorrente(String numero, String senha, Cliente cliente) {
		super(numero, senha, cliente);
	}
	
	public boolean saque(float valor) {
		if (valor > 0) {
			if (valor <= saldo()) {
				setSaldo(saldo() - valor);
				return true;
			} else {
				setSaldo(saldo() - valor - TAXA);
				return true;
			}
		}
		return false;
	}
	
}



