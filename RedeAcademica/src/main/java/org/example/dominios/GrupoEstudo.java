package org.example.dominios;

import org.example.dominios.publicacao.Publicacao;

import java.util.*;

public class GrupoEstudo {

    private UUID id;
    private String nome;
    private Professor professor;
    private Set<Usuario> membros;
    private List<Publicacao> publicacoes;

    public GrupoEstudo(String nome, Professor professor) {
        if(nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("");
        }
        this.nome = nome.trim();
        this.professor = Objects.requireNonNull(professor,"Obrigatorio professor");
        this.membros = new HashSet<>();
        this.publicacoes = new ArrayList<>();
        adicionarMembro(professor);
    }

    public void adicionarMembro(Usuario usuario) {
        Objects.requireNonNull(usuario,"membro nao pode ser nulo");
        membros.add(usuario);
        usuario.entrarGrupo(this);
    }

    public void postar(Publicacao publicacao) {
        Objects.requireNonNull(publicacao,"publicacao nao pode ser nula");
        if(!membros.contains(publicacao.getUsuario())) {
            throw new IllegalArgumentException("usuario nao é membro do grupo");
        }
        publicacoes.add(publicacao);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Set<Usuario> getMembros() {
        return membros;
    }

    public void setMembros(Set<Usuario> membros) {
        this.membros = membros;
    }

    public List<Publicacao> getPublicacoes() {
        return publicacoes;
    }

    public void setPublicacoes(List<Publicacao> publicacoes) {
        this.publicacoes = publicacoes;
    }
}
