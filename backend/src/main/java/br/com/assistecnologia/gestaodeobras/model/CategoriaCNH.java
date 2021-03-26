package br.com.assistecnologia.gestaodeobras.model;

public enum CategoriaCNH {
    categoria_A("A"),
    categoria_B("B"),
    categoria_C("C"),
    categoria_D("D"),
    categoria_E("E");

    private String categoria;

    CategoriaCNH(String categoria) {
        this.categoria =categoria;
    }

    public String getCategoria() {
        return categoria;
    }
}
