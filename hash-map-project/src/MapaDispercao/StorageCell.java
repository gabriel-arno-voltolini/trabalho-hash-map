package MapaDispercao;

public class StorageCell<Key, T> {
    private Key key;
    private T value;

    public StorageCell(Key key, T value) {
        this.key = key;
        this.value = value;
    }

    public Key getKey() {
        return key;
    }

    public T getValue() {
        return value;
    }
}
