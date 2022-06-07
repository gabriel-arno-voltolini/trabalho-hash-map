// Gabriel Arno Voltolini
// Lucas Mota de Oliveira
// Victor do Amaral
package MapaDispercao;

public interface IMapaDispersao<Key, T> {

    /**
     * <p>
     * O método inserir(Key, T) deve armazenar o objeto T, fornecido como argumento,
     * no mapa
     * de dispersão de acordo com o valor da chave (Key). O retorno do método é um
     * booleano: true
     * caso a inserção seja bem sucedida; false caso já exista a chave no mapa e por
     * isto não seja
     * inserido o objeto T no mapa.
     * 
     * @param chave valor de busca [unico]
     * @param valor T valor generico de insercao
     * @return boolean operacao bem sucedida
     * @see Image
     */
    boolean inserir(Key chave, T valor);

    /**
     * <p>
     * O método remover(Key) deve remover do mapa de dispersão o objeto que possui a
     * mesma chave (Key) que o objeto recebido como argumento. O retorno do método é
     * 
     * @param chave valor de busca [unico]
     * @return T valor removido ou null
     * @see Image
     */
    T remover(Key chave);

    /**
     * <p>
     * O método buscar(Key) deve procurar no mapa de dispersão um objeto que
     * possua
     * chave de busca igual à fornecida como argumento. Como resultado do seu
     * processamento, o método deve retornar o objeto localizado ou null caso não
     * localize.
     * 
     * @param chave valor de busca [unico]
     * @return T valor encontrado ou null
     * @see Image
     */
    T buscar(Key chave);

    /**
     * <p>
     * O método quantosElementos() deve retornar a quantidade atual de elementos
     * inseridos
     * no mapa.
     * 
     * @return int numero total de elementos armazenados no mapa
     * @see Image
     */
    int quantosElementos();
}
