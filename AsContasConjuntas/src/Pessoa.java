import java.util.HashSet;

public class Pessoa {

	public String nome;
	public HashSet<String> conjuntas;
	public String anterior;
	public int distancia;
	
	public Pessoa(String nome) {
		this.nome = nome;
		conjuntas = new HashSet<String>();
		distancia = -1;
	}
	
	
	
}
