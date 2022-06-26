package lineares;

public class TesteFilas {
	public static void main(String[] args) {
		Fila<Integer> f = new FilaLista<>();
		f.inserir(10);
		f.inserir(11);
		f.inserir(13);
		f.inserir(14);
		System.out.println("Fila Lista========");
		System.out.println(f);
		System.out.println(f.peek());
		System.out.println(f);
		System.out.println(f.retirar());
		System.out.println(f.retirar());
		System.out.println(f);
		f.inserir(140);
		System.out.println(f);
		
		f = new FilaVetor<>(4);
		f.inserir(10);
		f.inserir(11);
		f.inserir(13);
		f.inserir(14);
		System.out.println("Fila Vetor========");
		System.out.println(f);
		System.out.println(f.peek());
		System.out.println(f);
		System.out.println(f.retirar());
		System.out.println(f.retirar());
		System.out.println(f);
		f.inserir(140);
		System.out.println(f);
		
		
		System.out.println("Outros testes========");
	    FilaVetor<Integer> filaVetor = new FilaVetor<>(5);
	    FilaVetor<Integer> filaVetor2 = new FilaVetor<>(5);
	    filaVetor.inserir(13);
	    filaVetor.inserir(14);
	    filaVetor.inserir(15);
	    filaVetor.inserir(16);
	    filaVetor.inserir(12);
	    filaVetor.retirar();
	    filaVetor.retirar();
	    filaVetor.retirar();
	    filaVetor.retirar();
	    filaVetor.inserir(9);
	    filaVetor.inserir(3);
	    filaVetor2.inserir(25);
	    filaVetor2.inserir(30);
	    filaVetor2.inserir(35);
	    filaVetor2.inserir(40);
	    FilaVetor<Integer> concatenar = filaVetor.concatenar(filaVetor2);
	    System.out.println(filaVetor);
	    System.out.println(concatenar);
	}
}