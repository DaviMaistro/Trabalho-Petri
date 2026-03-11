public class ListaDinamica implements ListaOperacoes{
    No inicio;

    public ListaDinamica() {
        this.inicio = new No(null);
        System.out.println("Lista dinâmica criada com sucesso!");
    }

    public void adicionarElemento(String elemento) {

        if(inicioEstaVazio()) {
            this.inicio.setConteudo(elemento);
            System.out.println("Elemento " + elemento + " adicionado como primeiro da lista.");
        } else {
            No aux = this.inicio;
            No novoNo = new No(elemento);
            while(aux.getProx() != null) {
                aux = aux.getProx();
            }
            aux.setProx(novoNo);
            System.out.println("Elemento " + elemento + " adicionado ao final da lista.");
        }
    }

    public void exibir() {
        if(inicioEstaVazio()) {
            System.out.println("Não existem elementos na lista dinâmica.");
        } else {
            System.out.println("Elementos da lista:");
            No aux = this.inicio;
            while(aux != null) {
                System.out.println(aux.getConteudo());
                aux = aux.getProx();
            }
        }
    }

    private boolean inicioEstaVazio() {
        return this.inicio.getConteudo() == null;
    }


    public int removerTodas(String elemento) {

        if(inicioEstaVazio()) {
            System.out.println("Não há elementos para remover.");
            return 0;
        }

        int removidos = 0;

        while(inicio != null && inicio.getConteudo().equals(elemento)) {
            System.out.println("Elemento " + elemento + " removido.");
            inicio = inicio.getProx();
            removidos++;
        }

        No aux = inicio;

        while(aux != null && aux.getProx() != null) {

            if(aux.getProx().getConteudo().equals(elemento)) {
                System.out.println("Elemento " + elemento + " removido.");
                aux.setProx(aux.getProx().getProx());
                removidos++;
            } else {
                aux = aux.getProx();
            }
        }

        System.out.println(removidos + " ocorrências removidas.");

        return removidos;
    }

    public int contar() {

        if(inicioEstaVazio()) {
            System.out.println("A lista está vazia.");
            return 0;
        }

        int contador = 0;

        No aux = inicio;

        while(aux != null) {
            contador++;
            aux = aux.getProx();
        }

        System.out.println("A lista possui " + contador + " elementos.");

        return contador;
    }

    public int adicionarVarios(String[] elementos) {

        int adicionados = 0;

        for(int i = 0; i < elementos.length; i++) {
            adicionarElemento(elementos[i]);
            adicionados++;
        }

        System.out.println(adicionados + " elementos adicionados à lista.");

        return adicionados;
    }

    public String obter(int indice) {

        if(indice < 0) {
            System.out.println("Índice inválido.");
            return null;
        }

        int contador = 0;

        No aux = inicio;

        while(aux != null) {

            if(contador == indice) {
                System.out.println("Elemento encontrado na posição " + indice + ": " + aux.getConteudo());
                return aux.getConteudo();
            }

            contador++;
            aux = aux.getProx();
        }

        System.out.println("Índice fora do tamanho da lista.");
        return null;
    }

    public boolean inserir(int indice, String elemento) {

        if(indice < 0) {
            System.out.println("Índice inválido.");
            return false;
        }

        if(indice == 0) {

            No novo = new No(elemento);
            novo.setProx(inicio);
            inicio = novo;

            System.out.println("Elemento " + elemento + " inserido na posição 0.");

            return true;
        }

        int contador = 0;

        No aux = inicio;

        while(aux != null) {

            if(contador == indice - 1) {

                No novo = new No(elemento);
                novo.setProx(aux.getProx());
                aux.setProx(novo);

                System.out.println("Elemento " + elemento + " inserido na posição " + indice + ".");

                return true;
            }

            contador++;
            aux = aux.getProx();
        }

        System.out.println("Não foi possível inserir. Índice fora da lista.");

        return false;
    }
    public String removerPorIndice(int indice) {

        if(indice < 0 || inicioEstaVazio()) {
            System.out.println("Não foi possível remover. Índice inválido ou lista vazia.");
            return null;
        }

        if(indice == 0) {

            String removido = inicio.getConteudo();
            inicio = inicio.getProx();

            System.out.println("Elemento " + removido + " removido da posição 0.");

            return removido;
        }

        int contador = 0;

        No aux = inicio;

        while(aux != null && aux.getProx() != null) {

            if(contador == indice - 1) {

                String removido = aux.getProx().getConteudo();
                aux.setProx(aux.getProx().getProx());

                System.out.println("Elemento " + removido + " removido da posição " + indice + ".");

                return removido;
            }

            contador++;
            aux = aux.getProx();
        }

        System.out.println("Índice fora do tamanho da lista.");

        return null;
    }

    public void limpar() {

        inicio = new No(null);

        System.out.println("Todos os elementos da lista foram removidos.");

    }

    public int ultimoIndiceDe(String elemento) {

        int indice = 0;
        int ultimo = -1;

        No aux = inicio;

        while(aux != null) {

            if(aux.getConteudo().equals(elemento)) {
                ultimo = indice;
            }

            indice++;
            aux = aux.getProx();
        }

        if(ultimo == -1) {
            System.out.println("Elemento " + elemento + " não encontrado.");
        } else {
            System.out.println("Última ocorrência de " + elemento + " está na posição " + ultimo + ".");
        }

        return ultimo;
    }

    public int contarOcorrencias(String elemento) {

        int contador = 0;

        No aux = inicio;

        while(aux != null) {

            if(aux.getConteudo().equals(elemento)) {
                contador++;
            }

            aux = aux.getProx();
        }

        System.out.println("O elemento " + elemento + " aparece " + contador + " vezes.");

        return contador;
    }

    public int substituir(String antigo, String novo) {

        int substituidos = 0;

        No aux = inicio;

        while(aux != null) {

            if(aux.getConteudo().equals(antigo)) {
                aux.setConteudo(novo);
                substituidos++;
            }

            aux = aux.getProx();
        }

        System.out.println(substituidos + " ocorrências de " + antigo + " foram substituídas por " + novo + ".");

        return substituidos;
    }
}