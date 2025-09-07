package org.example.dominios.publicacao;

import org.example.dominios.Usuario;

import java.time.LocalDateTime;

public class Comentario {

    private Usuario autor;
    private String texto;
    private LocalDateTime dataHoraComentario;

    public Comentario(Usuario autor,String texto) {
        this.autor = autor;
        this.texto = texto;
        this.dataHoraComentario = LocalDateTime.now();
    }

    public Usuario getAutor() {
        return autor;
    }

    public void setAutor(Usuario autor) {
        this.autor = autor;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public LocalDateTime getDataHoraComentario() {
        return dataHoraComentario;
    }

    public void setDataHoraComentario(LocalDateTime dataHoraComentario) {
        this.dataHoraComentario = dataHoraComentario;
    }
}
