package MapaDispercao;
// Gabriel Arno Voltolini

// Lucas Mota de Oliveira
// Victor do Amaral

//TODO: Deve-se usar o enderecamento fechado (varias listas dentro de cada posicao do vetor)
// as listas devem ser encadeadas (feitas em sala)
public class MapaDispersao<Key, T> implements IMapaDispersao<Key, T> {
    private int[] mapa;

    public MapaDispersao(int quantidade) {
        this.mapa = new int[quantidade * 2];
        // O construtor MapaDispersao(int quantidade) deve criar um mapa com vetor
        // encapsulado, cujo tamanho será calculado com base no argumento quantidade,
        // que é a
        // quantidade estimada de elementos a serem inseridos. Considere as boas
        // práticas para
        // determinar o tamanho deste vetor.
    }

    private int calcularHash(Key chave) {
        // deve delegar para a classe K o cálculo do hash,
        // reusando o método hashCode() do objeto recebido como argumento (chave).
        // Entretanto,
        // o método calcularHash() deverá compactar o valor retornado por hashCode()
        // para um
        // intervalo aceitável para ser armazenado no vetor tabela.
        return 0;
    }

    public boolean inserir(Key chave, T valor) {
        return false;
    }

    public T remover(Key chave) {
        return null;
    }

    public T buscar(Key chave) {
        return null;
    }

    public int quantosElementos() {
        return 0;
    }
}
