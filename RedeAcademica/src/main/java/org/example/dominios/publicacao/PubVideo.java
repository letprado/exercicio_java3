package org.example.dominios.publicacao;

import org.example.dominios.Usuario;

public class PubVideo extends Publicacao {

    private String urlVideo;
    private int duracaoSegundos;

    public PubVideo(Usuario autor, String url, int duracaoSegundos) {
        super(autor);
        if(url == null || url.isEmpty()){
            throw new IllegalArgumentException("url nao pode ser nulo");
        }
        if(duracaoSegundos < 0){
            throw new IllegalArgumentException("duracao nao pode ser negativo");
        }
        this.urlVideo = url;
        this.duracaoSegundos = duracaoSegundos;
    }

    @Override //sobreescrevendo metodo da classe pai (Publicacao)
    public String renderizar() {
        return String.format("[VIDEO] %s - %s (%d segundos)",getUsuario().getNome(), urlVideo, duracaoSegundos);
    }

    public String getUrlVideo() {
        return urlVideo;
    }

    public void setUrlVideo(String urlVideo) {
        this.urlVideo = urlVideo;
    }

    public int getDuracaoSegundos() {
        return duracaoSegundos;
    }

    public void setDuracaoSegundos(int duracaoSegundos) {
        this.duracaoSegundos = duracaoSegundos;
    }
}
