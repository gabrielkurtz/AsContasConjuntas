import java.util.HashSet;

public class Conta {

	public int numero;
	public HashSet<String> titulares;
	
	public Conta(int numero) {
		this.numero = numero;
		titulares = new HashSet<String>();
	}
	
	public void addTitular(String nome) {
		titulares.add(nome);
	}
	
}
