package org.example.dominios.publicacao;

import org.example.dominios.Usuario;

import java.time.LocalDateTime;
import java.util.*;

public abstract class Publicacao {

    private UUID id;
    private Usuario usuario;
    private LocalDateTime horaPulicacao;
    private Set<Usuario> curtidas;
    private List<Comentario> comentarios;


    public Publicacao(Usuario autor) {
        this.id = UUID.randomUUID();
        this.usuario = autor; //autor
        this.horaPulicacao = LocalDateTime.now();
        this.curtidas = new HashSet<>();
        this.comentarios = new ArrayList<>();
    }


    public void curtir(Usuario usuario) {
        Objects.requireNonNull(usuario,"Usuario nao pode ser nulo.");
        if(!curtidas.add(usuario)){
            throw new IllegalStateException("Usuario já curtiu esse publicacao");
        }
    }

    public void comentar(String texto, Usuario autorComentario) {
        Objects.requireNonNull(autorComentario,"autorComentario nao pode ser nulo.");
        if(texto == null || texto.trim().isEmpty()){
            throw new IllegalStateException("Texto do comentario nao pode ser nulo.");
        }
        Comentario comentario = new Comentario(autorComentario,texto.trim());
        comentarios.add(comentario);
    }

    public abstract String renderizar();

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public LocalDateTime getHoraPulicacao() {
        return horaPulicacao;
    }

    public void setHoraPulicacao(LocalDateTime horaPulicacao) {
        this.horaPulicacao = horaPulicacao;
    }

    public Set<Usuario> getCurtidas() {
        return curtidas;
    }

    public void setCurtidas(Set<Usuario> curtidas) {
        this.curtidas = curtidas;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }
}
