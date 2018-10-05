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
        filmes.add(new Filme("Escócia", "IT a coisa", " filme de um palhaço que se alimenta de criança"));
        filmes.add(new Filme("Brasil", "velozes e fuiosos", "os cara que  gosta de correr de carro"));
        filmes.add(new Filme("Estados Unidos", "velozes e fuiosos2", "os caras estão com pressa"));
        filmes.add(new Filme("Dinamarca", "Vingadores","uma galera com vontade de se vinga"));
        filmes.add(new Filme("Brasil", "Tropa de elite2","rotina de policiais"));
        filmes.add(new Filme("Japão""Vingadores3", " galera se uniram de novo para quebra o pau da barra"));
        filmes.add(new Filme("Alemanha", "Vizinhos"," vizinhos que nao gosta um do outro"));
        filmes.add(new Filme("Alemanha", "Vingadores2", "enfrenta um novo vilão"));
        filmes.add(new Filme("Uruguai", "A bruxa","galerinha nao gosta de  dia das  bruxa"));
        filmes.add(new Filme("Brasil", "Tropa de elite","pessoa  jogando merda no ventilador"));

        return filmes;
    }
}
