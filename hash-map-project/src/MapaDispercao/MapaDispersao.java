// Gabriel Arno Voltolini
// Lucas Mota de Oliveira
// Victor do Amaral
package MapaDispercao;

import Lista.ListaEncadeada;
import Lista.NoLista;

//TODO: Deve-se usar o enderecamento fechado (varias listas dentro de cada posicao do vetor)
// as listas devem ser encadeadas (feitas em sala)
public class MapaDispersao<Key, T> implements IMapaDispersao<Key, T> {
    private ListaEncadeada<StorageCell<Key, T>>[] mapa;
    private ListaEncadeada<Key> chaves;

    public MapaDispersao(int quantidade) {
        int mapaLength = nextPrime(quantidade * 2);
        this.mapa = new ListaEncadeada[mapaLength];
        this.chaves = new ListaEncadeada<Key>();
    }

    public boolean inserir(Key chave, T valor) {
        boolean success = false;
        int insertionIndex = calcularHash(chave);
        boolean canBeInserted = !keyAlreadyExists(chave);
        if (canBeInserted) {
            ListaEncadeada<StorageCell<Key, T>> lista = mapa[insertionIndex];
            StorageCell<Key, T> storageCell = new StorageCell<>(chave, valor);
            if (lista == null) {
                lista = new ListaEncadeada<StorageCell<Key, T>>();
                mapa[insertionIndex] = lista;
            }
            success = true;
            lista.inserir(storageCell);
            this.chaves.inserir(chave);
        }
        return success;
    }

    public T remover(Key chave) {
        // TODO: Implementar
        return null;
    }

    public T buscar(Key chave) {
        T result = null;
        boolean keyExists = keyAlreadyExists(chave);
        if (keyExists) {
            result = getStorageCellByKey(chave).getValue();
        }
        return result;
    }

    public int quantosElementos() {
        // TODO: Implementar
        return 0;
    }

    private StorageCell<Key, T> getStorageCellByKey(Key chave) {
        StorageCell<Key, T> result = null;
        NoLista<StorageCell<Key, T>> noListaAtual = null;
        int index = calcularHash(chave);
        ListaEncadeada<StorageCell<Key, T>> lista = mapa[index];
        do {
            if (noListaAtual == null) {
                noListaAtual = lista.getPrimeiro();
            }
            if (noListaAtual.getInfo().getKey().equals(chave)) {
                result = noListaAtual.getInfo();
                break;
            } else {
                noListaAtual = noListaAtual.getProx();
            }

        } while (noListaAtual != null);
        return result;
    }

    private int calcularHash(Key chave) {
        int hash = chave.hashCode();
        int index = hash % mapa.length;
        return index;
    }

    private boolean keyAlreadyExists(Key chave) {
        return this.chaves.buscar(chave) != -1;
    }

    private boolean indexIsOccupied(int index) {
        boolean hasCollision = false;
        if (mapa[index] != null) {
            hasCollision = !mapa[index].estaVazia();
        }
        return hasCollision;
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

    /*
     * >> [X] O construtor MapaDispersao(int quantidade) deve criar um mapa com
     * vetor
     * encapsulado, cujo tamanho será calculado com base no argumento quantidade,
     * que é a quantidade estimada de elementos a serem inseridos. Considere as boas
     * práticas para determinar o tamanho deste vetor.
     * >> [X] O método privado calcularHash() deve delegar para a classe K o cálculo
     * do
     * hash, reusando o método hashCode() do objeto recebido como argumento (chave).
     * Entretanto, o método calcularHash() deverá compactar o valor retornado por
     * hashCode()
     * para um intervalo aceitável para ser armazenado no vetor tabela.
     * >> [X] O método inserir(K, T) deve armazenar o objeto T, fornecido como
     * argumento, no mapa
     * de dispersão de acordo com o valor da chave (K). O retorno do método é um
     * booleano: true caso a inserção seja bem sucedida; false caso já exista a
     * chave no mapa e por
     * isto não seja inserido o objeto T no mapa.
     * >> [] O método remover(K) deve remover do mapa de dispersão o objeto que
     * possui a mesma chave de busca da chave fornecida como argumento, retornando
     * este objeto.
     * Caso não localize, deve retornar null.
     * >> [] O método buscar(K) deve procurar no mapa de dispersão um objeto que
     * possua
     * chave de
     * busca igual à fornecida como argumento. Como resultado do seu processamento,
     * o método
     * deve retornar o objeto localizado ou null caso não localize.
     * >> [] O método quantosElementos() deve retornar a quantidade atual de
     * elementos
     * inseridos
     * no mapa.
     */
}
