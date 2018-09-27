package br.usjt.filme;

/**
 * Created by asbonato on 9/5/15.
 */
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

    public TreeSet<Filme> listarGenero(String estilo, String pais) {
        TreeSet<Filme> genero = new TreeSet<Filme>();

        if (estilo.length() > 0 && pais.length() > 0) {
            genero = buscarEstiloPais(estilo, pais);
        } else if (estilo.length() > 0) {
            genero = buscarEstilo(estilo);
        } else if (pais.length() > 0) {
            genero = buscarPais(pais);
        } else {
            genero = todas();
        }

        return genero;
    }

    private TreeSet<Filme> buscarEstilo(String estilo) {
        TreeSet<Filme> lista = new TreeSet<Filme>();
        for (Filme filme : filmes) {
            if (estilo.equals(filme.getEstilo())) {
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

    private TreeSet<Filme> buscarEstilo(String estilo) {
        TreeSet<Filme> lista = new TreeSet<Filme>();
        for (Filme filme : filmes) {
            if (estilo.equals(filme.getEstilo())) {
                lista.add(filme);
            }
        }
        return lista;
    }

    private TreeSet<Filme> buscarEstiloPais(String estilo, String pais) {
        TreeSet<Filme> lista = new TreeSet<Filme>();
        for (Filme filme : filmes) {
            if (estilo.equals(filme.getEstilo())
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
        filmes.add(new Filme("Brewdog Punk IPA", "Escócia", "cerveja001", 22.99));
        filmes.add(new Filme("Schornstein IPA","Brasil", "cerveja002", 16.90));
        filmes.add(new Filme("Speakeasy Big Daddy IPA", "Estados Unidos", "cerveja003", 21.90));
        filmes.add(new Filme("Mikkeller Simcoe Single Hop", "Dinamarca", "cerveja004", 27.90));
        filmes.add(new Filme("Dortmund The White IPA", "Brasil", "cerveja005", 19.90));
        filmes.add(new Filme("Bear Beer Premium Lager", "cerveja006", 11.99));
        filmes.add(new Filme("Fürstenberg Premium Lager","Alemanha", "cerveja007", 10.99));
        filmes.add(new Filme("Insana Gold", "Brasil", "cerveja008", 14.90));
        filmes.add(new Filme("Norteña", "Uruguai", "cerveja009", 11.90));
        filmes.add(new Filme("Rasen Bier Pilsen","Brasil", "cerveja010", 8.99));
        filmes.add(new Filme("Alhambra 1925 Reserva",
                "Espanha", "cerveja011", 9.90));
        filmes.add(new Filme("Bamberg Natural Pilsen",
                 "Brasil", "cerveja012", 11.99));
        filmes.add(new Filme("Colorado Cauim",
                "Brasil", "cerveja013", 14.99));
        filmes.add(new Filme("Invicta German Pilsener", "Brasil", "cerveja014", 11.40));
        filmes.add(new Filme("Dama Pilsen",
                "Brasil", "cerveja015", 9.90));
        filmes.add(new Filme("Colorado Demoiselle",
                "Brasil", "cerveja016", 12.99));


        return filmes;
    }
}
