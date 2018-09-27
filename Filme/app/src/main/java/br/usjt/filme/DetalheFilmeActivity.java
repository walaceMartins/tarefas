package br.usjt.filme;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.Locale;

public class DetalheCervejaActivity extends ActionBarActivity {
    TextView cervejaNome;
    ImageView cervejaImageView;
    TextView cervejaPreco;
    TextView cervejaEstilo;
    TextView cervejaCor;
    TextView cervejaPais;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_cerveja);

        Intent intent = getIntent();
        Serializable obj = intent.getSerializableExtra(ListaFilmeActivity.CERVEJA);
        Filme filme = (Filme)obj;
        setupViews(filme);

    }

    private void setupViews(Filme filme) {
        filmeNome = (TextView) findViewById(R.id.txt_cerveja_nome);
        filmeNome.setText(filme.getNome());
        filmeImageView = (ImageView) findViewById(R.id.filme_image_view);
        Drawable drawable = Util.getDrawable(this, filme.getImagem());
        filmeImageView.setImageDrawable(drawable);
        filmePreco = (TextView) findViewById(R.id.txt_filme_preco);
        Locale locale = new Locale("pt", "BR");
        NumberFormat formatter = NumberFormat.getCurrencyInstance(locale);
        filmePreco.setText(""+formatter.format(cerveja.getPreco()));
        filmeEstilo = (TextView) findViewById(R.id.txt_cerveja_estilo);
        filmeEstilo.setText(cerveja.getEstilo());
        filmeCor = (TextView) findViewById(R.id.txt_filme_cor);
        filmeCor.setText(filme.getCor());
        filmePais = (TextView) findViewById(R.id.txt_filme_pais);
        filmePais.setText(filme.getPais());
    }

}
