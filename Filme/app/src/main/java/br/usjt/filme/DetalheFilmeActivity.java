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

public class DetalheFilmeActivity extends ActionBarActivity {
    TextView filmeNome;
    ImageView filmeImageView;
    TextView filmeDescricao;
    TextView filmeGenero;
    TextView filmePais;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_filme);

        Intent intent = getIntent();
        Serializable obj = intent.getSerializableExtra(ListaFilmeActivity.FILME);
        Filme filme = (Filme)obj;
        setupViews(filme);

    }

    private void setupViews(Filme filme) {
        filmeNome = (TextView) findViewById(R.id.txt_filme_nome);
        filmeNome.setText(filme.getNome());
        filmeImageView = (ImageView) findViewById(R.id.filme_image_view);
        Drawable drawable = Util.getDrawable(this, filme.getImagem());
        filmeImageView.setImageDrawable(drawable);
        filmeDescricao = (TextView) findViewById(R.id.txt_filme_descricao );
        Locale locale = new Locale("pt", "BR");
        NumberFormat formatter = NumberFormat.getCurrencyInstance(locale);
        filmeDescricao= (TextView) findViewById(R.id.txt_filme_genero);
        filmeGenero.setText(filme.getGenero());
        filmeGenero = (TextView) findViewById(R.id.txt_filme_genero);
        filmeGenero.setText(filme.getGenero());
        filmePais = (TextView) findViewById(R.id.txt_filme_pais);
        filmePais.setText(filme.getPais());
    }

}
