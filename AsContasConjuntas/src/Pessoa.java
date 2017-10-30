import java.util.HashSet;

public class Pessoa {

	public String nome;
	public HashSet<String> conjuntas;
	public String anterior;
	public int distancia;
	
	public Pessoa(String nome) {
		this.nome = nome;
		this.conjuntas = new HashSet<String>();
		this.anterior = "";
		this.distancia = -1;
	}
	
	public void addConjunta(String nome) {
		conjuntas.add(nome);
	}
	
}
