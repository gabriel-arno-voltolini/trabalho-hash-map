// Gabriel Arno Voltolini
// Lucas Mota de Oliveira
// Victor do Amaral
package Lista;

public class ListaEncadeada<T> implements ILista<T> {
    private NoLista<T> primeiro;
    private NoLista<T> ultimo;
    private int qtdElementos;

    public void inserir(T valor) {
        NoLista<T> novo = new NoLista<>();
        novo.setInfo(valor);
        if (this.estaVazia()) {
            primeiro = novo;
        } else {
            ultimo.setProx(novo);
        }
        ultimo = novo;
        qtdElementos++;
    }

    public String exibir() {
        String resultado = "[";
        NoLista<T> p = primeiro;
        while (p != null) {
            resultado += p.getInfo() + ", ";
            p = p.getProx();
        }
        return resultado + "]";
    }

    public int buscar(T valor) {
        int indice = 0;
        NoLista<T> p = primeiro;
        while (p != null) {
            if (p.getInfo().equals(valor)) {
                return indice;
            }
            p = p.getProx();
            indice++;
        }
        return -1;
    }

    public boolean estaVazia() {
        return primeiro == null;
    }

    public void retirar(T valor) {
        NoLista<T> anterior = null;
        NoLista<T> p = primeiro;

        while (p != null && !p.getInfo().equals(valor)) {
            anterior = p;
            p = p.getProx();
        }
        if (p != null) {
            if (anterior == null) {
                primeiro = p.getProx();
            } else {
                anterior.setProx(p.getProx());
            }
            if (ultimo == p) {
                ultimo = anterior;
            }
            qtdElementos--;
        }
    }

    public ILista<T> copiar() {
        ILista<T> listaCopia = new ListaEncadeada<>();
        NoLista<T> p = primeiro;
        while (p != null) {
            T valor = p.getInfo();
            listaCopia.inserir(valor);
            p = p.getProx();
        }
        return listaCopia;
    }

    public void concatenar(ILista<T> outra) {
        for (int i = 0; i < outra.getTamanho(); i++) {
            inserir(outra.pegar(i));
        }
    }

    public int getTamanho() {
        return this.qtdElementos;
    }

    public ILista<T> dividir2() {
        ILista<T> nova = new ListaEncadeada<>();
        NoLista<T> iterador = primeiro;
        int metade = qtdElementos / 2;

        for (int idx = 0; idx < metade; ++idx) {
            nova.inserir(iterador.getInfo());
            iterador = iterador.getProx();
        }

        primeiro = iterador;
        qtdElementos = qtdElementos - metade;
        return nova;
    }

    public ILista<T> dividir() {
        int qtd = getTamanho() / 2;
        ListaEncadeada<T> novaLista = new ListaEncadeada<>();
        NoLista<T> p = primeiro;
        int contador = 0;

        while (p != null) {
            ++contador;
            if (contador > qtd)
                novaLista.inserir(p.getInfo());

            if (contador == qtd) {
                ultimo = p;
            }

            p = p.getProx();
        }
        ultimo.setProx(null);
        qtdElementos = qtd;
        return novaLista;
    }

    public T pegar(int posicao) {
        if (posicao < 0 || posicao >= qtdElementos) {
            throw new IndexOutOfBoundsException("Index:" + posicao + " Size:" + qtdElementos);
        }
        int contador = 0;
        NoLista<T> p = primeiro;
        while (p != null) {
            if (contador == posicao) {
                return p.getInfo();
            }
            contador++;
            p = p.getProx();
        }
        return null;
    }
}