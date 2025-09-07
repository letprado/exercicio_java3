package org.example.dominios.publicacao;

import org.example.dominios.Usuario;

public class PubImagem extends Publicacao {

    private String urlImagem;
    private String legenda;

    public PubImagem(Usuario autor,String urlImagem, String legenda) {
        super(autor);
        //validacoes urlIamge e da legenda
        this.urlImagem = urlImagem;
        this.legenda = legenda;
    }

    public String renderizar() {
        return String.format("[IMAGEM] %s - %s",getUsuario().getNome(), urlImagem);
    }

    public String getUrlImagem() {
        return urlImagem;
    }

    public void setUrlImagem(String urlImagem) {
        this.urlImagem = urlImagem;
    }

    public String getLegenda() {
        return legenda;
    }

    public void setLegenda(String legenda) {
        this.legenda = legenda;
    }
}
