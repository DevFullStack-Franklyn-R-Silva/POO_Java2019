package banco;

public abstract class Conta {

	// Atributos
	private Cliente cliente;
	private String senha;
	private String numero;
	private float saldo;

	// Construtores
	public Conta(String numero, String senha, Cliente cliente) {
		this.cliente = cliente;
		this.numero = numero;
		this.senha = senha;
		this.saldo = 0.0f;
	}

	// Métodos, getters e setters
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNumero() {
		return this.numero;
	}
	
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	public float saldo() {
		return this.saldo;
	}
	
	protected void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	
	public abstract boolean saque(float valor);
	
	public boolean deposito(float valor) {
		if (valor > 0) {
			this.saldo = this.saldo + valor;
			return true;
		}
		return false;
	}
	
	public boolean verificaConta(String senha) {
		if (this.senha.equals(senha)) {
			return true;
		}
		return false;
	}

	public String toString() {
		return getNumero() + " R$" + saldo() + " ";
	}
	
}
