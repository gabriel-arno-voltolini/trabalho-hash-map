package lineares;

public class FilaLista<T> implements Fila<T> {
	private ListaEncadeada<T> lista;

	public FilaLista() {
		lista = new ListaEncadeada<>();
	}

	@Override
	public void inserir(T valor) {
		lista.inserir(valor);
	}

	@Override
	public T retirar() {
		T valor = this.peek();
		lista.retirar(valor);
		return valor;
	}

	@Override
	public T peek() {
		if (this.estaVazio()) {
			throw new RuntimeException("Fila está vazia");
		}
		return lista.pegar(0);
	}

	@Override
	public boolean estaVazio() {
		return (lista.getTamanho() == 0);
	}

	@Override
	public void liberar() {
		lista = new ListaEncadeada<>();
	}

	public String toString() {
		return lista.exibir();
	}

}
