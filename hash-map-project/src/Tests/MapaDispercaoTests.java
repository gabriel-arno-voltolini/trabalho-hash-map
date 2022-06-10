// Gabriel Arno Voltolini
// Lucas Mota de Oliveira
// Victor do Amaral
package Tests;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import MapaDispercao.MapaDispersao;

public class MapaDispercaoTests {
  @Test
  public void inserir_deve_retornar_true() {
    MapaDispersao<String, String> mapa = new MapaDispersao<String, String>(10);
    boolean result = mapa.inserir("chave", "valor");
    int count = mapa.quantosElementos();
    assertEquals(true, result);
    assertEquals(1, count);
  }

  @Test
  public void inserir_deve_retornar_false_quando_chave_ja_existe() {
    MapaDispersao<String, String> mapa = new MapaDispersao<String, String>(10);
    mapa.inserir("chave", "valor1");
    boolean result = mapa.inserir("chave", "valor");
    int count = mapa.quantosElementos();
    assertEquals(false, result);
    assertEquals(1, count);
  }

  @Test
  public void remover_deve_retornar_valor_removido() {
    MapaDispersao<String, String> mapa = new MapaDispersao<String, String>(10);
    mapa.inserir("chave1", "valor");
    mapa.inserir("chave", "valor");
    String result = mapa.remover("chave");
    int count = mapa.quantosElementos();
    assertEquals("valor", result);
    assertEquals(1, count);
  }

  @Test
  public void remover_deve_retornar_null_quando_chave_nao_existe() {
    MapaDispersao<String, String> mapa = new MapaDispersao<String, String>(10);
    mapa.inserir("chave", "valor");
    String result = mapa.remover("chave2");
    int count = mapa.quantosElementos();
    assertEquals(null, result);
    assertEquals(1, count);
  }

  @Test
  public void buscar_deve_retornar_valor_encontrado() {
    MapaDispersao<String, String> mapa = new MapaDispersao<String, String>(10);
    mapa.inserir("chave", "valor");
    String result = mapa.buscar("chave");
    assertEquals("valor", result);
  }

  @Test
  public void buscar_deve_retornar_null_quando_chave_nao_existe() {
    MapaDispersao<String, String> mapa = new MapaDispersao<String, String>(10);
    mapa.inserir("chave", "valor");
    String result = mapa.buscar("chave2");
    assertEquals(null, result);
  }

  @Test
  public void quantosElementos_deve_retornar_numero_total_de_elementos() {
    MapaDispersao<String, String> mapa = new MapaDispersao<String, String>(10);
    mapa.inserir("chave", "valor");
    mapa.inserir("chave1", "valor");
    mapa.inserir("chave2", "valor");
    mapa.inserir("chave3", "valor");
    int result = mapa.quantosElementos();
    assertEquals(4, result);
  }

  @Test
  public void quantosElementos_deve_retornar_0_quando_nao_existem_elementos() {
    MapaDispersao<String, String> mapa = new MapaDispersao<String, String>(10);
    int result = mapa.quantosElementos();
    assertEquals(0, result);
  }
}
