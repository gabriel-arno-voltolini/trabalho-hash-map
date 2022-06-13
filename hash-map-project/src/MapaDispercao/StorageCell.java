// Gabriel Arno Voltolini
// Lucas Mota de Oliveira
// Victor do Amaral

package MapaDispercao;

public class StorageCell<K, T> {
    private K key;
    private T value;

    public StorageCell(K key, T value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public T getValue() {
        return value;
    }
}
