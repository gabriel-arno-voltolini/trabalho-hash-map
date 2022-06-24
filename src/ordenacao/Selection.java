//Rodrigo Kapulka Franco, Nicole Bauchspiess, Vinicius Matiola Tramontin 

package ordenacao;

public class Selection<T extends Comparable<T>> implements Sort<T> {

	@Override
	public void sort(T[] vetor) {
		int menor;
		for (int i = 0; i < vetor.length; i++) {
			menor = i;
			for (int j = i; j < vetor.length; j++) {
				if (vetor[j].compareTo(vetor[menor]) < 0) {
					menor = j;
				}
			}
			this.troca(vetor, i, menor);
		}

	}

	private void troca(T[] vetor, int um, int dois) {
		T temp = vetor[um];
		vetor[um] = vetor[dois];
		vetor[dois] = temp;
	}

}
