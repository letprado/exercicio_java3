package org.example.dominios.publicacao;

import org.example.dominios.Usuario;

public class PubTexto extends Publicacao {

    private String texto;

    public PubTexto(String texto, Usuario autor) {
        super(autor);
        if(texto == null || texto.trim().isEmpty()) {
            throw new IllegalArgumentException("Texto nao pode ser nulo ou vazio");
        }
        this.texto = texto;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    @Override //sobreescrevendo metodo da classe pai (Publicacao)
    public String renderizar() {
        return String.format("[Texto] %s - %s",getUsuario().getNome(), texto);
    }
}
