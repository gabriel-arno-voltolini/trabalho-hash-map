package ordenacao;

public class ClasseDeBusca<T> { // contribuição do Rodrigo

	public static <T extends Comparable<T>> int pesquisaBinaria(T[] vetor, T valorBuscar) {
		int inicio = 0;
		int fim = vetor.length - 1;
		int meio;
		while (inicio <= fim) {
			meio = (inicio + fim) / 2;
			if (valorBuscar.compareTo(vetor[meio]) < 0) {
				fim = meio - 1;
			} else if (valorBuscar.compareTo(vetor[meio]) > 0) {
				inicio = meio + 1;
			} else {
				return meio;
			}
		}
		return -1;
	}
}
