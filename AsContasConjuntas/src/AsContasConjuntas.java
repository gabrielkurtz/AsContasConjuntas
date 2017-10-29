import java.nio.file.Path;
import java.nio.file.Paths;
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
		
		System.out.println("\n--- Iniciando Cronômetro ---"
				+ "\n--- Inicializando Estrutura de Minas para arquivo " + arquivo + " ---");

	
	}
}
