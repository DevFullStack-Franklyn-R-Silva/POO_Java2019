package banco;

public class ContaPoupanca extends Conta {

	public ContaPoupanca(String numero, String senha, Cliente cliente) {
		super(numero, senha, cliente);
	}
	
	public boolean saque(float valor) {
		if (valor > 0 && valor <= saldo()) {
			setSaldo(saldo() - valor);
			return true;
		}
		return false;
	}
	
}
