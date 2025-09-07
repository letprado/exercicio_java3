package org.example.dominios;

public class Professor extends Usuario {

    public Professor(String email, String nome) {
        super(email, nome); //chama construtor classe pai (nesse caso Usuario)
    }

    public GrupoEstudo criarGrupos(String nomeDoGrupo) {
        GrupoEstudo grupoEstudo = new GrupoEstudo(nomeDoGrupo, this);
        return grupoEstudo;
        //return new GrupoEstudo(nomeDoGrupo, this);
    }


}
