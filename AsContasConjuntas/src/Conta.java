import java.util.HashSet;

public class Conta {

	public int numero;
	public HashSet<String> titulares;
	
	public Conta(int numero, String nome) {
		this.numero = numero;
		titulares = new HashSet<String>();
	}
	
	
}
