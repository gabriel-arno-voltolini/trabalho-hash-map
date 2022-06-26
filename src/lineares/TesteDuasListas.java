package lineares;

public class TesteDuasListas {
    public static void main(String[] args){
        System.out.println("TESTE COM LISTAS DE AMBAS AS CLASSES");
        System.out.println("\nJoao e Maria vao ao supermercado, com uma �nica lista de compras.");
        Lista<String> lista = new ListaEncadeada<>();
        lista.inserir("arroz");
        lista.inserir("batata");
        lista.inserir("café");
        lista.inserir("detergente");
        System.out.println("Esperado arroz, batata, caf�, detergente = "+lista.exibir());
        System.out.println("\nMaria lembrou que tamb�m precisava de f�sforos e anotou na lista.");
        lista.inserir("f�sforos");
        System.out.println("Esperado arroz, batata, caf�, detergente, f�sforos = "+lista.exibir());

        System.out.println("Jo�o passou na frente da g�ndola dos cereais e verificou se arroz e feij�o estavam na lista");    
        int pos = lista.buscar("arroz");
        System.out.println("Esperado 0 = "+pos);
        pos = lista.buscar("feij�o");
        System.out.println("Esperado -1 = "+pos);
        System.out.println("Como arroz estava na lista, pegou arroz e riscou da lista.");    
        lista.retirar("arroz");
        System.out.println("Agora a lista tem (Esperado batata, caf�, detergente, f�sforos) = "+lista.exibir());
        
        System.out.println("\nMaria lembrou que j� havia outra lista de supermercado, que estava em seu bolso:");
        Lista<String> lista2 = new ListaEstatica<>();
        lista2.inserir("tomate");
        lista2.inserir("cebola");
        lista2.inserir("cenoura");
        System.out.println("Lista 2(Array) Esperado tomate,cebola,cenoura = "+lista2.exibir());
        System.out.println("Como estava na frente da g�ndola da cebola, j� pegou e tirou da lista, mas lembrou que tamb�m precisava de ovos:");
        lista2.retirar("cebola");
        lista2.inserir("ovos");
        System.out.println("Esperado tomate,cenoura,ovos = "+lista2.exibir());
        
        System.out.println("\nJo�o fez uma c�pia de sua lista");
        Lista<String> lista3, lista3A;
        lista3 = lista.copiar();
        System.out.println("Lista copiada de Jo�o Esperado batata,caf�,detergente,f�sforos = "+lista3.exibir());
        System.out.println("\nComo estavam com pressa, resolveram juntar as duas listas");
        lista.concatenar(lista2);
        System.out.println("Lista Jo�o+Maria Esperado batata,caf�,detergente,f�sforos,tomate,cenoura,ovos = "+lista.exibir());
        lista2.concatenar(lista3);
        System.out.println("Lista Maria+Jo�o Esperado tomate,cenoura,ovos,batata,caf�,detergente,f�sforos = "+lista2.exibir());

        System.out.println("E a� fizeram uma confus�o, juntando tudo de novo... \nEsperado tomate,cenoura,ovos,batata,caf�,detergente,f�sforos, batata,caf�,detergente,f�sforos,tomate,cenoura,ovos");
        lista2.concatenar(lista);
        System.out.println("Nova Lista = "+lista2.exibir());
        
        System.out.println("\nPara resolver o problema, dividiram a lista ");
        Lista<String> lista4, lista5;
        lista4 = lista2.dividir();
        System.out.println("Jo�o (dividida) Esperado = batata,caf�,detergente,f�sforos,tomate,cenoura,ovos\n"+lista4.exibir());
        System.out.println("Maria (divis�o da Nova lista) Esperado = tomate,cenoura,ovos,batata,caf�,detergente,f�sforos\n"+lista2.exibir());
        System.out.println("E Maria anotou mais uma coisa: ch�");
        lista2.inserir("ch�");
        System.out.println("Lista Maria Esperado = tomate,cenoura,ovos,batata,caf�,detergente,f�sforos,ch�\n"+lista2.exibir());

        System.out.println("E Maria entregou uma c�pia da lista para Jo�o Esperado = tomate,cenoura,ovos,batata,caf�,detergente,f�sforos,ch�");
        lista5 = lista2.copiar();
        System.out.println("Jo�o copiada de Maria = "+lista5.exibir());

        System.out.println("Por fim, Maria ainda acrescenta em sua lista mais um item: esponja\nEsperado = tomate,cenoura,ovos,batata,caf�,detergente,f�sforos,ch�,esponja");
        lista2.inserir("esponja");
        System.out.println("Lista Maria = "+lista2.exibir());
        System.out.println("Mas do Jo�o permanece a mesma\nEsperado = tomate,cenoura,ovos,batata,caf�,detergente,f�sforos,ch�,\n\t\t "+lista5.exibir());
        
    }
}
