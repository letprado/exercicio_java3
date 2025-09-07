package org.example.service;

import org.example.dominios.GrupoEstudo;
import org.example.dominios.Usuario;
import org.example.dominios.publicacao.Publicacao;

import java.util.*;

public class FeedService {
    public List<Publicacao> feedGlobal(List<Publicacao> publicacoes){
        List<Publicacao> publicacoesFinal = new ArrayList<>(publicacoes);
        ordenarPorDataHoraDesc(publicacoesFinal);
        return publicacoesFinal;
    }
    public List<Publicacao> feedDoUsuario(Usuario usuario){
        List<Publicacao> feed = new ArrayList<>();
        //publicacoes dos que usuario esta seguindo
        List<Usuario> usuariosSeguindos = List.copyOf(usuario.getSeguindo());

        // for each mais dinamico
        for(Usuario seguido : usuariosSeguindos) {
            for(Publicacao publicacao : coletarPublicacoesdeUsuario(seguido)) {
                feed.add(publicacao);
            }
        }
        // for tradicional para usar como comparacao
        //for(int i = 0; i < usuariosSeguindos.size(); i++){
        //    List<Publicacao> publicaoList = coletarPublicacoesdeUsuario(usuariosSeguindos.get(i));
        //    for(int j = 0; j < publicaoList.size(); j++){
        //        feed.add(publicaoList.get(j));
        //    }
        //}
        //publicacoes do grupos de estudo que ele participa

        for (GrupoEstudo grupoEstudo : usuario.getGrupos()) {
            feed.addAll(grupoEstudo.getPublicacoes());
        }
        ordenarPorDataHoraDesc(feed);
        return feed;
    }
    private void ordenarPorDataHoraDesc(List<Publicacao> publicacoesFinal) {
        //faz a ordenacao por hora inversa
        Collections.sort(publicacoesFinal, Comparator.comparing(Publicacao::getHoraPulicacao).reversed());
    }
    private List<Publicacao> coletarPublicacoesdeUsuario(Usuario seguido) {
        List<Publicacao> resultado = new ArrayList<>();
        for(GrupoEstudo grupoEstudo : seguido.getGrupos()) {
            for(Publicacao publicacao : grupoEstudo.getPublicacoes()) {
                if(publicacao.getUsuario().equals(seguido)) {
                    resultado.add(publicacao);
                }
            }
        }
        return resultado;
    }
}