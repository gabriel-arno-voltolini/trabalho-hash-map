package lineares;

import java.util.Arrays;

public class FilaVetor<T> implements Fila<T> { // contribuição do Nadir

	private T info[];
	private int limite;
	private int tamanhoAtual;
	private int inicio;

	@SuppressWarnings("unchecked")
	public FilaVetor(int limite) {
		this.limite = limite;
		info = (T[]) new Object[limite];
		this.tamanhoAtual = 0;
		this.inicio = 0;
	}

	@Override
	public void inserir(T valor) {
		if (tamanhoAtual == this.limite) {
			throw new RuntimeException("Fila está cheia");
		}
		int posicaoInserir = (inicio + tamanhoAtual) % limite;
		info[posicaoInserir] = valor;
		tamanhoAtual++;
	}

	@Override
	public T retirar() {
		T valor = this.peek();
		info[inicio] = null;
		inicio = (inicio + 1) % limite;
		tamanhoAtual--;
		return valor;
	}

	@Override
	public T peek() {
		if (this.estaVazio()) {
			throw new RuntimeException("Fila está vazia");
		}
		return info[inicio];
	}

	@Override
	public boolean estaVazio() {
		return tamanhoAtual == 0;
	}

	@Override
	public void liberar() {
		info = (T[]) new Object[limite];
		this.tamanhoAtual = 0;
		this.inicio = 0;
	}

	public FilaVetor<T> concatenar(FilaVetor<T> fila2) {  // contribuição do Luiz, Julia e Bruna
		FilaVetor<T> fila3 = new FilaVetor<>(getLimite() + fila2.getLimite());

		for (int idx = 0; idx < getTamanho(); idx++)
			fila3.inserir(this.info[(idx + getInicio()) % getLimite()]);

		for (int idx = 0; idx < fila2.getTamanho(); idx++)
			fila3.inserir(fila2.getInfo()[(idx + fila2.getInicio()) % fila2.getLimite()]);

		return fila3;
	}

	private int getInicio() {
		return this.inicio;
	}

	private T[] getInfo() {
		return this.info;
	}

	private int getTamanho() {
		return this.tamanhoAtual;
	}

	private int getLimite() {
		return this.limite;
	}

	@Override
	public String toString() { // contribuição do Hiago
		String retorno = "";

		int posicao = inicio;
		for (int idx = 0; idx < tamanhoAtual; ++idx)// da pra usar o idx na soma e tirar posicao = inicio;
		{
			retorno += info[posicao] + ", ";
			posicao = (posicao + 1) % limite;
		}

		return retorno;
	}

	public String toString1() { // contribuição do José João
		if (this.tamanhoAtual == 0)
			return "";

		String fila = "";
		boolean primeiroElemento = true;

		for (int idxFila = 0; idxFila < this.tamanhoAtual; ++idxFila) {
			fila += primeiroElemento ? "" : ", " + this.info[(this.inicio + idxFila) % this.limite];
			primeiroElemento = false;
		}

		return fila;
	}

	public String toString2() {// contribuição do Bernardo e Vinicius
		String fila = "";
		for (int i = inicio; i != (inicio + tamanhoAtual) % limite; i = (i + 1) % limite) {
			fila += info[i] + ", ";
		}
		return "[ " + fila + " ]";

	}
}
