public class ListaSimples implements ListaOperacoes{
    String[] lista;

    public ListaSimples(int tamanho) {
        this.lista = new String[tamanho];
        System.out.println("Lista criada com sucesso! Existem " + tamanho + " posições disponíveis.");
    }

    public void adicionarElemento(String elemento) {
        if (!this.estaCheia()) {
            this.lista[encontrarPosicao()] = elemento;
            System.out.println("Elemento " + elemento + "  adicionado com sucesso!");
        }
    }

    public boolean estaCheia() {
        for (int i = 0; i < this.lista.length; i++) {
            if (this.lista[i] == null) {
                return false;
            }
        }
        System.out.println("Não há espaço disponível na lista.");
        return true;
    }

    public boolean estaVazia() {
        for (int i = 0; i < this.lista.length; i++) {
            if (this.lista[i] != null) {
                return false;
            }
        }
        return true;
    }

    private int encontrarPosicao() {
        int i;
        for (i = 0; i < this.lista.length; i++) {
            if (this.lista[i] == null) {
                break;
            }
        }
        return i;
    }

    public void exibirElementos() {
        for (int i = 0; i < this.lista.length; i++) {
            System.out.println("Lista[" + i + "] = " + this.lista[i]);
        }
    }

    public void removerElemento(String elemento) {
        boolean removido = false;
        if (!estaVazia()) {
            for (int i = 0; i < this.lista.length; i++) {
                if (this.lista[i] != null && this.lista[i].equals(elemento)) {
                    this.lista[i] = null;
                    removido = true;
                }
            }
        }
        if (removido) {
            System.out.println("O elemento " + elemento + " foi removido com sucesso!");
        } else {
            System.out.println("O elemento " + elemento + " não existe na lista.");
        }
    }

    public void buscarElemento(String elemento) {
        boolean encontrado = false;
        if (!estaVazia()) {
            for (int i = 0; i < this.lista.length; i++) {
                if (this.lista[i] != null && this.lista[i].equals(elemento)) {
                    encontrado = true;
                }
            }
        }
        if (encontrado) {
            System.out.println("O elemento " + elemento + " existe na lista!");
        } else {
            System.out.println("O elemento " + elemento + " não existe na lista.");
        }
    }

    public int removerTodas(String elemento) {
        int quantidade = 0;
        for (int i = 0; i < this.lista.length; i++) {
            if (this.lista[i] != null && this.lista[i].equals(elemento)) {
                this.lista[i] = null;
                quantidade++;
            }
        }
        System.out.println("Foram removidas " + quantidade + " ocorrências de " + elemento + ".");
        return quantidade;
    }

    public int contar() {
        int quantidade = 0;
        for (int i = 0; i < this.lista.length; i++) {
            if (this.lista[i] != null) {
                quantidade++;
            }
        }
        System.out.println("A lista possui " + quantidade + " de itens na lista.");
        return quantidade;
    }

    public int adicionarVarios(String[] elementos) {
        int adicionados = 0;
        for (int i = 0; i < elementos.length; i++) {
            if (!this.estaCheia()) {
                this.lista[encontrarPosicao()] = elementos[i];
                adicionados++;
            }
        }
        System.out.println("Foram adicionados " + adicionados + " elementos na lista.");
        return adicionados;
    }

    public String obter(int indice) {
        if (indice < 0 || indice >= this.lista.length) {
            System.out.println("Índice inválido.");
            return null;
        }
        System.out.println("O elemento no índice " + indice + " é " + this.lista[indice]);
        return this.lista[indice];
    }

    public boolean inserir(int indice, String elemento) {
        if (indice < 0 || indice >= this.lista.length) {
            System.out.println("Índice inválido.");
            return false;
        }
        if (this.estaCheia()) {
            return false;
        }
        for (int i = this.lista.length - 1; i > indice; i--) {
            this.lista[i] = this.lista[i - 1];
        }
        this.lista[indice] = elemento;
        System.out.println("Elemento " + elemento + " inserido na posição " + indice + " com sucesso!");
        return true;
    }

    public String removerPorIndice(int indice) {
        if (indice < 0 || indice >= this.lista.length || this.lista[indice] == null) {
            System.out.println("Índice inválido.");
            return null;
        }
        String removido = this.lista[indice];
        for (int i = indice; i < this.lista.length - 1; i++) {
            this.lista[i] = this.lista[i + 1];
        }
        this.lista[this.lista.length - 1] = null;
        System.out.println("Elemento " + removido + " removido com sucesso!");
        return removido;
    }
}