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

        ordenarArvore(arvBusca.getRaiz());

        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = lista.pegar(i);
        }
    }

    public NoArvoreBinaria<T> ordenarArvore(NoArvoreBinaria<T> no) {
        if (no.getEsq() != null) {
            ordenarArvore(no.getEsq()).getInfo();
        }

        lista.inserir(no.getInfo());

        if (no.getDir() != null) {
            ordenarArvore(no.getDir()).getInfo();
        }

        return no;
    }
}
