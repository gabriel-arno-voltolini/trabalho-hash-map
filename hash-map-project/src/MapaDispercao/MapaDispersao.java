// Gabriel Arno Voltolini
// Lucas Mota de Oliveira
// Victor do Amaral
package MapaDispercao;

//TODO: Deve-se usar o enderecamento fechado (varias listas dentro de cada posicao do vetor)
// as listas devem ser encadeadas (feitas em sala)
public class MapaDispersao<Key, T> implements IMapaDispersao<Key, T> {
    private int[] mapa;

    public MapaDispersao(int quantidade) {
        int mapaLength = nextPrime(quantidade * 2);
        this.mapa = new int[mapaLength];
    }

    public boolean inserir(Key chave, T valor) {
        int hash = calcularHash(chave);
        return false;
    }

    public T remover(Key chave) {
        // TODO: Implementar
        return null;
    }

    public T buscar(Key chave) {
        // TODO: Implementar
        return null;
    }

    public int quantosElementos() {
        // TODO: Implementar
        return 0;
    }

    public int[] getMapa() {
        return mapa;
    }

    private int nextPrime(int number) {
        if (!isPrime(number))
            number = nextPrime(++number);
        return number;
    }

    private boolean isPrime(int number) {
        for (int i = 2; i <= Math.sqrt(number); i++)
            if (number % i == 0)
                return false;
        return true;
    }

    private int calcularHash(Key chave) {
        return chave.hashCode() % mapa.length;
    }
}
