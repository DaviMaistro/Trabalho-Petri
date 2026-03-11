public class Main {
    public static void main(String[] args) {
        ListaSimples listaSimples = new ListaSimples(5);

        String[] nomes = {"Davi", "Raul", "Alex", "João"};

        listaSimples.adicionarElemento("Gabriel");
        listaSimples.adicionarElemento("Luís");
        listaSimples.adicionarElemento("Davi");
        listaSimples.adicionarElemento("Raul");
        listaSimples.adicionarElemento("Luís");

        listaSimples.exibirElementos();

        listaSimples.buscarElemento("Davi");
        listaSimples.removerElemento("Davi");
        listaSimples.buscarElemento("Davi");
        listaSimples.exibirElementos();

        listaSimples.contar();

        listaSimples.removerTodas("Luís");
        listaSimples.exibirElementos();
        listaSimples.contar();

        listaSimples.adicionarVarios(nomes);
        listaSimples.exibirElementos();

        listaSimples.obter(3);
        listaSimples.removerPorIndice(4);

        listaSimples.exibirElementos();
        listaSimples.inserir(4,"Gabriel");

    }
}