package br.usjt.filme;

import java.io.Serializable;

/**
 * Created by asbonato on 9/5/15.
 */
public class Filme implements Comparable<Filme>, Serializable{
    private String nome;
    private String imagem;
    private double preco;
    private String estilo;
    private String pais;
    public static final String NAO_ENCONTRADA = "Não encontrada.";

    public Filme(String nome, String estilo, String cor, String pais, String imagem, double preco) {
        this.nome = nome;
        this.imagem = imagem;
        this.preco = preco;
        this.estilo = estilo;
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

    public String getEstilo() {
        return estilo;
    }

    public String getPais() {
        return pais;
    }

    @Override
    public String toString() {
        return "br.usjt.cervejap1.Cerveja{" +
                "nome='" + nome + '\'' +
                ", imagem='" + imagem + '\'' +
                ", preco='" + preco + '\'' +
                ", estilo='" + estilo + '\'' +
                ", pais='" + pais + '\'' +
                '}';
    }

    @Override
    public int compareTo(Filme filme) {
        if (nome.equals(filme.getNome())
                && estilo.equals(filme.getEstilo())
                && pais.equals(filme.getPais())) {
            return 0;
        }
        return this.getNome().compareTo(filme.getNome());
    }
}
