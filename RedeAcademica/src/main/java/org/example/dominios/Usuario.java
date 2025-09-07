package org.example.dominios;

import java.util.Objects;
import java.util.Set;
import java.util.UUID;

public abstract class Usuario {

    private UUID id;

    private String nome;

    private String email;

    private Set<Usuario> seguindo;
    private Set<GrupoEstudo> grupos;

    public Usuario(String nome,String email) {
        this.id = UUID.randomUUID();
        this.email = email;
        this.nome = nome;
    }

    public void seguir(Usuario outroUsuario) {
        Objects.requireNonNull(outroUsuario,"usuario nao pode ser nulo");
        if(outroUsuario.equals(this)) {
            throw new IllegalArgumentException("");
        }
        if(!seguindo.add(outroUsuario)) {
            throw new IllegalArgumentException("");
        }
    }

    public void entrarGrupo(GrupoEstudo grupoEstudo) {
        Objects.requireNonNull(grupoEstudo);
        grupos.add(grupoEstudo);
    }

    public UUID getId() {
        return id;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Usuario> getSeguindo() {
        return seguindo;
    }

    public void setSeguindo(Set<Usuario> seguindo) {
        this.seguindo = seguindo;
    }

    public Set<GrupoEstudo> getGrupos() {
        return grupos;
    }

    public void setGrupos(Set<GrupoEstudo> grupos) {
        this.grupos = grupos;
    }
}
