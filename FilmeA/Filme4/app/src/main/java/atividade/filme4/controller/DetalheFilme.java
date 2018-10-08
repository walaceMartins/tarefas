package atividade.filme4.controller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import atividade.filme4.R;
import atividade.filme4.model.Filme;

public class DetalheFilme extends Activity {
    private TextView nomeGenero, descricao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_genero);
        nomeGenero = findViewById(R.id.txt_nome);
        descricao = findViewById(R.id.txt_descricao);
        Intent intent = getIntent();
        Genero genero = (Genero)intent.getSerializableExtra(ListaGeneroActivity.GENERO1);
        nomeGenero.setText(genero.getNome().toString());
        descricao.setText(genero.getDescricao().toString());
    }
}
