package ordenacao;

import arvores.ArvoreBST;

public class Tree<T extends Comparable<T>> implements Sort<T> {

    @Override
    public void sort(T[] vetor) {
		ArvoreBST<T> arvBusca = new ArvoreBST<>();
        
        for (T item : vetor) {
            arvBusca.inserir(item);
        }

        System.out.println(arvBusca.toStringOrdered());
    }
}
