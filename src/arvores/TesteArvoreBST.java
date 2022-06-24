package arvores;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JOptionPane;

public class TesteArvoreBST {

	public static void main(String[] args) {
		ArvoreBST<String> arvBusca = new ArvoreBST<>();
		arvBusca.inserir("Joana");
		arvBusca.inserir("Joao");
		arvBusca.inserir("Carlos");
		arvBusca.inserir("Zeca");
		arvBusca.inserir("Ana");
		arvBusca.inserir("Danilo");
		arvBusca.inserir("Yuri");
		arvBusca.inserir("José");
		arvBusca.inserir("Patricia");
		arvBusca.inserir("Maria");

		System.out.println("Null->" + arvBusca.buscar("Pedro"));
		System.out.println("Danilo ->" + arvBusca.buscar("Danilo").getInfo());
		System.out.println("Maria ->" + arvBusca.buscar("Maria").getInfo());
		System.out.println(arvBusca);

		geraArvore();
	}

	public static void geraArvore() { // contribuição do Nadir
		int tamanho = Integer.parseInt(JOptionPane.showInputDialog("Digite o tamanho da árvore."));
		ArvoreBST<Integer> arvore = new ArvoreBST<Integer>();
		Random inteiro = new Random();
		List<Integer> inteiros = new ArrayList<>();
		for (int i = 0; i < tamanho; i++) {
			int adicionar = inteiro.nextInt(1000);
			arvore.inserir(adicionar);
			inteiros.add(adicionar);
			System.out.println(arvore);
		}

		for (int j = 0; j < tamanho; j++) {
			Integer i = inteiros.get(j);
			System.out.println("Antecessor de " + i + " = " + arvore.antecessor(i));
		}

		for (int j = 0; j < tamanho; j++) {
			Integer i = inteiros.get(j);
			System.out.println("Sucessor de " + i + " = " + arvore.sucessor(i));
		}
		
		System.out.println(arvore.toStringOrdered());
		
		System.out.println(inteiros);
		for (int i = 0; i < tamanho; i++) {
			int itemARetirar = inteiro.nextInt(inteiros.size());

			System.out.println("Retirando: " + inteiros.get(itemARetirar));

			arvore.retirar(inteiros.get(itemARetirar));
			inteiros.remove(itemARetirar);
			System.out.println("Lista: " + inteiros);
			System.out.println("Árvore: " + arvore);
		}
	}

}
