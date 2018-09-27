package br.usjt.filme;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;

public class ListaCervejaActivity extends ActionBarActivity {
    ListView listView;
    Activity atividade;
    public final static String FILME = "br.usjt.CERVEJA";
    Filme[] filmes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_Filme);
        atividade = this;

        Especialista especialista = new Especialista();
        //pega a mensagem do intent
        Intent intent = getIntent();
        String pais = intent.getStringExtra(MainActivity.PAIS);
        String estilo = intent.getStringExtra(MainActivity.ESTILO);
        String modo = intent.getStringExtra(MainActivity.MODO);

        filmes = especialista.listarGenero(estilo, pais).toArray(new Filme[0]);
        String[] lista = null;

        if(modo.equals(MainActivity.SIMPLES)) {
            lista = new String[filmes.length];

            for (int i = 0; i < filmes.length; i++) {
                lista[i] = filmes[i].getNome();
            }
        }
        //cria a lista de cervejas
        listView = (ListView) findViewById(R.id.view_lista_cerveja);
        BaseAdapter adapter;
        if(modo.equals(MainActivity.SIMPLES)) {
            adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, lista);
        } else {
            adapter = new FilmesAdapter(this, filmess);
        }
        listView.setAdapter(adapter);

        // listener de click em um item do listview

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                // manda para a tela de detalhe
                Intent intent = new Intent(atividade, DetalheFilmeActivity.class);
                intent.putExtra(FILME, filmes[position]);

                startActivity(intent);

            }

        });
    }

}