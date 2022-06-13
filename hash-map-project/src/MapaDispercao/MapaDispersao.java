// Gabriel Arno Voltolini
// Lucas Mota de Oliveira
// Victor do Amaral

package MapaDispercao;

import Lista.ListaEncadeada;
import Lista.NoLista;

public class MapaDispersao<K, T> implements IMapaDispersao<K, T> {
    private ListaEncadeada<StorageCell<K, T>>[] tabela;
    private ListaEncadeada<K> chaves;

    public MapaDispersao(int quantidade) {
        int mapaLength = Math.abs(nextPrime(quantidade * 2));
        this.tabela = new ListaEncadeada[mapaLength];
        this.chaves = new ListaEncadeada<K>();
    }

    public boolean inserir(K chave, T dado) {
        boolean success = false;
        int insertionIndex = calcularHash(chave);
        boolean canBeInserted = !keyAlreadyExists(chave);
        if (canBeInserted) {
            ListaEncadeada<StorageCell<K, T>> lista = tabela[insertionIndex];
            StorageCell<K, T> storageCell = new StorageCell<>(chave, dado);
            if (lista == null) {
                lista = new ListaEncadeada<StorageCell<K, T>>();
                tabela[insertionIndex] = lista;
            }
            success = true;
            lista.inserir(storageCell);
            this.chaves.inserir(chave);
        }
        return success;
    }

    public T remover(K chave) {
        T valorRemovido = null;
        boolean keyExists = keyAlreadyExists(chave);
        int removalIndex = 0;
        if (keyExists) {
            valorRemovido = buscar(chave);
            removalIndex = calcularHash(chave);
            StorageCell<K, T> cellToBeRemoved = new StorageCell<K, T>(chave, valorRemovido);
            ListaEncadeada<StorageCell<K, T>> lista = tabela[removalIndex];
            lista.retirar(cellToBeRemoved);
            this.chaves.retirar(chave);
        }
        return valorRemovido;
    }

    public T buscar(K chave) {
        T result = null;
        boolean keyExists = keyAlreadyExists(chave);
        if (keyExists) {
            result = getStorageCellByKey(chave).getValue();
        }
        return result;
    }

    public int quantosElementos() {
        int quantidadeElementos = 0;
        for (int i = 0; i < tabela.length; i++) {
            if (indexIsOccupied(i)) {
                quantidadeElementos += countStorageCellsAt(i);
            }
        }
        return quantidadeElementos;
    }

    private StorageCell<K, T> getStorageCellByKey(K chave) {
        StorageCell<K, T> result = null;
        NoLista<StorageCell<K, T>> noListaAtual = null;
        int index = calcularHash(chave);
        ListaEncadeada<StorageCell<K, T>> lista = tabela[index];
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

    private int calcularHash(K chave) {
        int hash = Math.abs(chave.hashCode());
        int index = hash % tabela.length;
        return index;
    }

    private boolean keyAlreadyExists(K chave) {
        return this.chaves.buscar(chave) != -1;
    }

    private int countStorageCellsAt(int index) {
        int count = 0;
        ListaEncadeada<StorageCell<K, T>> lista = null;
        if (indexIsOccupied(index)) {
            lista = tabela[index];
            count = lista.getTamanho();
        }
        return count;
    }

    private boolean indexIsOccupied(int index) {
        boolean hasCollision = false;
        if (tabela[index] != null) {
            hasCollision = !tabela[index].estaVazia();
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
}
