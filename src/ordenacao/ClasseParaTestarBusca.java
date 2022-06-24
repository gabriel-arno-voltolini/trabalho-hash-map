package ordenacao;

import java.util.Arrays;
import java.util.Random;


class ClasseParaTestarBusca {

	private static Veiculo[] vetor;
	private static Integer[] vetorInts;
	private static String[] vetorStrings;
	private static int[] tamanhos = {100, 5000};
	
	public static void main(String[] args) {
		initializeClass();
		
		// a linha abaixo precisa ser alterada para a classe criada pela equipe
		Sort<Veiculo> meuAlgoritmo = new BubbleSort<>();

		long ultimoNanoTime, tempoExecucao;
		for (Integer i : tamanhos) {
			Veiculo[] vetorCopiado = Arrays.copyOf(vetor, i);
			System.out.println("Vetor com " + i + " ve�culos");
			//System.out.println(Arrays.toString(vetorCopiado));
			meuAlgoritmo.sort(vetorCopiado);
			System.out.println("Pesquisa COM sucesso:");
			ultimoNanoTime = System.nanoTime();
			int posicao = ClasseDeBusca.pesquisaBinaria(vetorCopiado,vetorCopiado[95]);
			tempoExecucao = System.nanoTime() - ultimoNanoTime;
			System.out.println("Posição = "+posicao+ " em "+tempoExecucao+" ns");
			System.out.println("Pesquisa SEM sucesso:");
			ultimoNanoTime = System.nanoTime();
			Veiculo veiculo = new Veiculo();
			veiculo.setPlaca("NAO-EXIS");
			posicao = ClasseDeBusca.pesquisaBinaria(vetorCopiado,veiculo);
			tempoExecucao = System.nanoTime() - ultimoNanoTime;
			System.out.println("Posição = "+posicao+ " em "+tempoExecucao+" ns");
		}

		// a linha abaixo precisa ser alterada para a classe criada pela equipe
		Sort<Integer> meuAlgoritmo2 = new BubbleSort<>();

		for (Integer i : tamanhos) {
			Integer[] vetorCopiado = Arrays.copyOf(vetorInts, i);
			System.out.println("Vetor com " + i + " inteiros");
			//System.out.println(Arrays.toString(vetorCopiado));
			meuAlgoritmo2.sort(vetorCopiado);
			ultimoNanoTime = System.nanoTime();
			int posicao = ClasseDeBusca.pesquisaBinaria(vetorCopiado,vetorCopiado[95]);
			tempoExecucao = System.nanoTime() - ultimoNanoTime;
			System.out.println("Posição = "+posicao+ " em "+tempoExecucao+" ns");
			System.out.println("Pesquisa SEM sucesso:");
			ultimoNanoTime = System.nanoTime();
			posicao = ClasseDeBusca.pesquisaBinaria(vetorCopiado,Integer.MIN_VALUE);
			tempoExecucao = System.nanoTime() - ultimoNanoTime;
			System.out.println("Posição = "+posicao+ " em "+tempoExecucao+" ns");
		}
		
		// a linha abaixo precisa ser alterada para a classe criada pela equipe
		Sort<String> meuAlgoritmo3 = new BubbleSort<>();

		for (Integer i : tamanhos) {
			String[] vetorCopiado = Arrays.copyOf(vetorStrings, i);
			System.out.println("Vetor com " + i + " Strings");
			//System.out.println(Arrays.toString(vetorCopiado));
			meuAlgoritmo3.sort(vetorCopiado);
			ultimoNanoTime = System.nanoTime();
			int posicao = ClasseDeBusca.pesquisaBinaria(vetorCopiado,vetorCopiado[90]);
			tempoExecucao = System.nanoTime() - ultimoNanoTime;
			System.out.println("Posição = "+posicao+ " em "+tempoExecucao+" ns");
			System.out.println("Pesquisa SEM sucesso:");
			ultimoNanoTime = System.nanoTime();
			posicao = ClasseDeBusca.pesquisaBinaria(vetorCopiado,"não existente");
			tempoExecucao = System.nanoTime() - ultimoNanoTime;
			System.out.println("Posição = "+posicao+ " em "+tempoExecucao+" ns");
		}
	}

	public static void initializeClass() {
		vetor = new Veiculo[tamanhos[tamanhos.length-1]];
		Veiculo veic;
		// gera��o dos dados
		String nome, placa, modelo;
		int ano;

		for (int i = 0; i < vetor.length; i++) {
			nome = GeradorAleatorio.geraNome() + " " + i;
			placa = GeradorAleatorio.geraPlaca();
			modelo = GeradorAleatorio.geraModelo();
			ano = GeradorAleatorio.geraAno();
			vetor[i] = new Veiculo(placa, modelo, ano, nome);
		}

		Random r = new Random();
		vetorInts = new Integer[vetor.length];
		for (int i = 0; i < vetorInts.length; i++) {
			vetorInts[i] = r.nextInt(vetorInts.length*1000);
		}
		
		vetorStrings = new String[vetor.length];
		for (int i = 0; i < vetorStrings.length; i++) {
			vetorStrings[i] = GeradorAleatorio.geraNome()+" "
								+GeradorAleatorio.geraModelo()+" "
								+GeradorAleatorio.geraNome();
		}
	}
}
