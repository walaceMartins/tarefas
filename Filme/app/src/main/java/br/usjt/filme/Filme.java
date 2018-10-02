package br.usjt.filme;

import java.io.Serializable;


public class Filme implements Comparable<Filme>, Serializable{
    private String nome;
    private String imagem;
    private double preco;
    private String genero;
    private String pais;
    public static final String NAO_ENCONTRADA = "Não encontrada.";

    public Filme(String nome, String genero,String pais, String imagem, double preco) {
        this.nome = nome;
        this.imagem = imagem;
        this.preco = preco;
        this.genero = genero;
        this.pais = pais;
    }

    public String getNome() {
        return nome;
    }

    public String getImagem() {
        return imagem;
    }

    public double getPreco() {
        return preco;
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
                ", preco='" + preco + '\'' +
                ", genero='" + estilo + '\'' +
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
