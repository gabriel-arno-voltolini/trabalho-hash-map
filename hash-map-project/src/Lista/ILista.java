// Gabriel Arno Voltolini
// Lucas Mota de Oliveira
// Victor do Amaral
package Lista;

public interface ILista<T> {
    void inserir(T valor);

    String exibir();

    int buscar(T valor);

    boolean estaVazia();

    void retirar(T valor);

    ILista<T> copiar();

    void concatenar(ILista<T> outraLista);

    int getTamanho();

    ILista<T> dividir();

    T pegar(int posicao);
}
