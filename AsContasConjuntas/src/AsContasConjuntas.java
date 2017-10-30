import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class AsContasConjuntas {
	public static void main(String args[]) {
		
		Scanner in = new Scanner(System.in);
		
		System.out.print("--- Pontificia Universidade Catolica do Rio Grande do Sul ---"
				+ "\n--- Bacharelado em Engenharia de Software ---"
				+ "\n--- Disciplina de Algoritmos e Estruturas de Dados II ---"
				+ "\n--- Prof. Joao Batista Oliveira ---"
				+ "\n--- Gabriel Ferreira Kurtz ---"
				+ "\n\n-------------------------------------------------------------------"
				+ "\n--- ALGORITMO DE MENOR CAMINHO EM ESTRUTURA DE CONTAS CONJUNTAS ---"
				+ "\n-------------------------------------------------------------------"
				+ "\n\nInsira o nome do arquivo de dados a ser processado:"
				+ "\n> ");

		String arquivo = in.nextLine();
		Path input = Paths.get(arquivo);

		long startTime = System.nanoTime();
		
		System.out.println("\n--- Iniciando Cronômetro ---");

		HashSet<Conta> contas = new HashSet<Conta>();
		HashMap<String, Pessoa> pessoas = new HashMap<String, Pessoa>();
		ArrayDeque<Pessoa> fila = new ArrayDeque<Pessoa>();
		String nome1="", nome2="";
		
		
		try (BufferedReader br = Files.newBufferedReader(input, Charset.forName("utf8")))
		{
			String linha = br.readLine();
			Scanner sc = new Scanner(linha).useDelimiter(" ");
			
			int totalContas = sc.nextInt();
			System.out.println("Total de Contas Correntes: " + totalContas);

			while((linha = br.readLine()) != null) {
				sc = new Scanner(linha).useDelimiter(" ");

				//Populando set de contas
				if(sc.hasNextInt()) {
					Conta contaNova = new Conta(sc.nextInt());
					contaNova.addTitular(sc.next());
					contaNova.addTitular(sc.next());
					contas.add(contaNova);
				}
				//Gravando nome de pessoas da transferencia
				else {
					nome1 = sc.next();
					nome2 = sc.next();
				}
			}
		}
		catch (IOException x) {
			System.err.format("Erro de E/S: %s%n", x);
		}

		//Iterando set de Contas
		for(Conta c : contas) {
			//Iterando titulares da Conta
			for(String titular : c.titulares) {
				//Se for a primeira conta da pessoa, cria a pessoa no dicionario e acrescenta conta conjunta
				if(!pessoas.containsKey(titular)) {
					Pessoa novaPessoa = new Pessoa(titular);
					for(String titular2 : c.titulares) {
						if(titular2 != titular) {
							novaPessoa.addConjunta(titular2);
						}
					}
					pessoas.put(titular, novaPessoa);
				}
				//Se já tiver conta, simplesmente acrescenta a conjunta
				else {
					for(String titular2 : c.titulares) {
						if(titular2 != titular) {
							pessoas.get(titular).addConjunta(titular2);
						}
					}
				}
			}
		}
		
		System.out.println("\n--- Inicializando Estrutura de Contas para arquivo " + arquivo + " ---"
				+ "\nPessoas:" + pessoas.size() + "   ---   Contas: " + contas.size()
				+ "\nOrigem: " + nome1 + "   ---   Destino: " + nome2);

		Pessoa pessoa1 = pessoas.get(nome1);
		Pessoa pessoa2 = pessoas.get(nome2);
		
		pessoa2.distancia = 1;
		pessoa2.anterior = pessoa2.nome;
		
		fila.add(pessoa2);
		
		int count = 0;
		while(!fila.isEmpty()) {
			Pessoa p = fila.remove();

			for(String v : p.conjuntas) {
				Pessoa vizinho = pessoas.get(v);
				if(vizinho.distancia<0) {
					vizinho.distancia = p.distancia + 1;
					vizinho.anterior = p.nome;
					fila.add(vizinho);
				}
			}
			count++;
		}
		
		System.out.println(count);
		
		Pessoa ant = pessoas.get(pessoa1.anterior);
		for(Conta c : contas) {

		}
		
		long endTime = System.nanoTime();
		double duration = ((endTime*1.0 - startTime)/1000000000);
		duration = (Math.round(duration*100)/100.0);
		System.out.println("--- Tempo Total de Execução: " + duration + " segundos ---");
		
	}
}
	
/*	public boolean processaVizinhos(Pessoa p) {
		boolean ret = false;
		for(String vizinho : p.conjuntas) {
			pessoas.get(vizinho).distancia = p.distancia + 1;
			pessoas.get(vizinho).anterior = p.nome;
		}
		return ret;
	}
	*/	

