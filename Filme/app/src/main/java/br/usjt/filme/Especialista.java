package br.usjt.filme;


import java.util.ArrayList;
import java.util.TreeSet;

public class Especialista {
    private static final ArrayList<Filme> filme = cadastroDeFilmes();

    public Especialista() {

    }

    private Filme buscarNome(String nome) {
        for (Filme filme : filmes) {
            if (nome.equals(filme.getNome())) {
                return filme;
            }
        }
        return null;
    }

    public TreeSet<Filme> listarGenero(String genero, String pais) {
        TreeSet<Filme> genero = new TreeSet<Filme>();

        if (genero.length() > 0 && pais.length() > 0) {
            genero = buscarGeneroPais(genero, pais);
        } else if (genero.length() > 0) {
            genero = buscarGenero(genero);
        } else if (pais.length() > 0) {
            genero = buscarPais(pais);
        } else {
            genero = todas();
        }

        return genero;
    }

    private TreeSet<Filme> buscarEstilo(String genero) {
        TreeSet<Filme> lista = new TreeSet<Filme>();
        for (Filme filme : filmes) {
            if (genero.equals(filme.getGenero())) {
                lista.add(filme);
            }
        }
        return lista;
    }

    private TreeSet<Filme> buscarPais(String pais) {
        TreeSet<Filme> lista = new TreeSet<Filme>();
        for (Filme filme : filmes) {
            if (pais.equals(filme.getPais())) {
                lista.add(filme);
            }
        }
        return lista;
    }

    private TreeSet<Filme> buscarGenero(String genero) {
        TreeSet<Filme> lista = new TreeSet<Filme>();
        for (Filme filme : filmes) {
            if (genero.equals(filme.getGenero())) {
                lista.add(filme);
            }
        }
        return lista;
    }

    private TreeSet<Filme> buscarGeneroPais(String genero, String pais) {
        TreeSet<Filme> lista = new TreeSet<Filme>();
        for (Filme filme : filmes) {
            if (estilo.equals(filme.getGenero())
                    && pais.equals(filme.getPais())) {
                lista.add(filme);
            }
        }
        return lista;
    }

    private TreeSet<Filme> todas() {
        TreeSet<Filme> lista = new TreeSet<Filme>();
        for (Filme filme : filmes) {
            lista.add(filme);
        }
        return lista;
    }

    private static ArrayList<Filme> cadastroDeFilmes() {
        ArrayList<Filme> filmes = new ArrayList<Filme>();
        filmes.add(new Filme("Escócia", "IT a coisa", 22.99));
        filmes.add(new Filme("Brasil", "velozes e fuiosos", 16.90));
        filmes.add(new Filme("Estados Unidos", "velozes e fuiosos2", 21.90));
        filmes.add(new Filme("Dinamarca", "Vingadores", 27.90));
        filmes.add(new Filme("Brasil", "Tropa de elite2", 19.90));
        filmes.add(new Filme("Japão""Vingadores3", 11.99));
        filmes.add(new Filme("Alemanha", "Vizinhos", 10.99));
        filmes.add(new Filme("Alemanha", "Vingadores2", 14.90));
        filmes.add(new Filme("Uruguai", "A bruxa", 11.90));
        filmes.add(new Filme("Brasil", "Tropa de elite", 8.99));

        return filmes;
    }
}
