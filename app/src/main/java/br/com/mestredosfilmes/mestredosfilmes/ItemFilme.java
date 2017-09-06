package br.com.mestredosfilmes.mestredosfilmes;

import android.net.Uri;

import java.io.Serializable;

/**
 * Created by andre on 04/09/2017.
 */

public class ItemFilme implements Serializable {

    private String id;
    private String titulo;
    private String descricao;
    private String dataLancamento;
    private Uri imagem;
    private float avaliacao;

    public ItemFilme() {
    }

    public ItemFilme(String titulo, String descricao, String dataLancamento, float avaliacao) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataLancamento = dataLancamento;
        this.avaliacao = avaliacao;
    }


    public String getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(String dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Uri getImagem() {
        return imagem;
    }

    public void setImagem(Uri imagem) {
        this.imagem = imagem;
    }

    public float getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(float avaliacao) {
        this.avaliacao = avaliacao;
    }
}
