package atividade.filme4.controller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;


public class MainActivity extends Activity  {

    Spinner spinner;
    Button btnBuscar;
    String genero;
    ArrayList<Genero> generos;
    GeneroRequester requester;
    ProgressBar mProgress;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupViews();

    }

    private void setupViews(){
        genero = "";
        btnBuscar = (Button) findViewById(R.id.botao_enviar);
        spinner = (Spinner) findViewById(R.id.spinner_generos);
        spinner.setOnItemSelectedListener(new GeneroSelecionado());
        mProgress = (ProgressBar) findViewById(R.id.carregando);
        mProgress.setVisibility(View.INVISIBLE);
    }



    //Constante para identificar a mensagem
    public final static String GENERO = "atividade.filme4.controller.filme";

    public void buscarGenero(View view){
        Intent intent = new Intent(this, ListaGeneroActivity.class);

        intent.putExtra(GENERO, genero);
        startActivity(intent);

    }


    private class GeneroSelecionado implements OnItemSelectedListener {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view,int position, long id) {

            genero = (String) parent.getItemAtPosition(position);
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }



}
