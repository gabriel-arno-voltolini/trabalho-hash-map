package ordenacao;

import arvores.ArvoreBST;
import arvores.NoArvoreBinaria;
import lineares.ListaEstatica;

public class Tree<T extends Comparable<T>> implements Sort<T> {

    private ListaEstatica<T> lista = new ListaEstatica<>();

    @Override
    public void sort(T[] vetor) {
        ArvoreBST<T> arvBusca = new ArvoreBST<>();

        for (T item : vetor) {
            arvBusca.inserir(item);
        }

        order(arvBusca.getRaiz());

        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = lista.pegar(i);
        }
    }

    public NoArvoreBinaria<T> order(NoArvoreBinaria<T> no) {
        if (no.getEsq() != null) {
            order(no.getEsq()).getInfo();
        }

        lista.inserir(no.getInfo());

        if (no.getDir() != null) {
            order(no.getDir()).getInfo();
        }

        return no;
    }
}
