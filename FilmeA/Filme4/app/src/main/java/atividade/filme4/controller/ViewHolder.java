package Atividade.filme4.controller;

import android.media.ImageWriter;
import android.widget.ImageView;
import android.widget.TextView;

public class ViewHolder {

    private ImageView fotoFilme;
    private TextView nomeFilme, detalhesFilme;

    public ViewHolder(ImageView fotoFilme, TextView nomeFilme, TextView detalhesFilme) {
        this.fotoCerveja = fotinhoCerveja;
        this.nomeFilme = nomeFilme;
        this.detalhesFilme = detalhesFilme;
    }
    public ImageView getFotoFilme() {
        return fotoFilme;
    }

    public void setFotoFilme(ImageView fotoFilme) {
        this.fotoFilme = fotoFilme;
    }

    public TextView getNomeFilme() {
        return nomeFilme;
    }

    public void setNomeFilme(TextView nomeFilme) {
        this.nomeFilme = nomeFilme;
    }

    public TextView getDetalhesFilme() {
        return detalhesFilme;
    }

    public void setDetalhesFilme(TextView detalhesFilme) {
        this.detalhesFilme = detalhesFilme;
    }
}
