package br.usjt.filme;

import android.widget.ImageView;
import android.widget.TextView;


public class ViewHolder {
    private ImageView fotinhoFilme;
    private TextView nomeFilme, detalhesFilme;

    public ViewHolder(ImageView fotinhoFilme, TextView nomeFilme, TextView detalhesFilme) {
        this.fotinhoFilme = fotinhoFilme;
        this.nomeFilme = nomeFilme;
        this.detalhesFilme = detalhesFilme;
    }

    public ImageView getFotinhoFilme() {
        return fotinhoFilme;
    }

    public void setFotinhoFilme(ImageView fotinhoFilme) {
        this.fotinhoFilme = fotinhoFilme;
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
