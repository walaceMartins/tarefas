package br.usjt.filme;

import java.io.Serializable;


public class Filme implements Comparable<Filme>, Serializable{
    private String nome;
    private String imagem;
    private String descricao;
    private String genero;
    private String pais;
    public static final String NAO_ENCONTRADA = "Não encontrada.";

    public Filme(String nome, String genero,String pais, String imagem, String descricao) {
        this.nome = nome;
        this.imagem = imagem;
        this.descricao = descricao;
        this.genero = genero;
        this.pais = pais;
    }

    public String getNome() {
        return nome;
    }

    public String getImagem() {
        return imagem;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getGenero() {
        return genero;
    }

    public String getPais() {
        return pais;
    }

    @Override
    public String toString() {
        /*  return possivel erro */
        return "br.usjt.filme.Filme{" +
                "nome='" + nome + '\'' +
                ", imagem='" + imagem + '\'' +
                ", descricao='" + descricao + '\'' +
                ", genero='" + genero + '\'' +
                ", pais='" + pais + '\'' +
                '}';
    }

    @Override
    public int compareTo(Filme filme) {
        if (nome.equals(filme.getNome())
                && genero.equals(filme.getGenero())
                && pais.equals(filme.getPais())) {
            return 0;
        }
        return this.getNome().compareTo(filme.getNome());
    }
}
