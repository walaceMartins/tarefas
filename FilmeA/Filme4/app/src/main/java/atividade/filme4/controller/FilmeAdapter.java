package atividade.filme4.controller;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.ArrayList;

import atividade.filme4.R;
import atividade.filme4.model.Filme;
import atividade.filme4.model.Util;

public class FilmeAdapter extends BaseAdapter{

    Genero[] generos;
    Context context;
    Object[] sectionHeaders;
    Hashtable<Integer, Integer> positionForSectionMap;
    Hashtable<Integer, Integer> sectionForPositionMap;

    public GeneroAdapter(Genero[] generos, Context context){
        this.generos = generos;
        this.context = context;
        sectionHeaders = SectionIndexBuilder.BuildSectionHeaders(generos);
        positionForSectionMap = SectionIndexBuilder.BuildPositionForSectionMap(generos);
        sectionForPositionMap = SectionIndexBuilder.BuildSectionForPositionMap(generos);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //o list view recicla os layouts para melhor performance
        //o layout reciclado vem no parametro convert view
        View view = convertView;
        //se nao recebeu um layout para reutilizar deve inflar um
        if(view == null) {
            //um inflater transforma um layout em uma view
            LayoutInflater inflater = (LayoutInflater) context.getSystemService
                    (Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.linha_genero, parent, false);

            ImageView fotoFilme = (ImageView)view.findViewById(R.id.fotoFilmeImageView);
            TextView nomeFilme = (TextView)view.findViewById(R.id.nomeFilmeTextView);
            TextView detalhesFilme = (TextView)view.findViewById(R.id.detalhesFilmeTextView);
            //faz cache dos widgets instanciados na tag da view para reusar quando houver reciclagem
            view.setTag(new ViewHolder(fotoFilme, nomeFilme, detalhesFilme));
        }
        //usa os widgets cacheados na view reciclada
        ViewHolder holder = (ViewHolder)view.getTag();
        //carrega os novos valores
        Drawable drawable = Util.getDrawable(context, cervejas[position].getCor());
        holder.getfotoFilme().setImageDrawable(drawable);
        Locale locale = new Locale("pt", "BR");
        NumberFormat formatter = NumberFormat.getCurrencyInstance(locale);
        holder.getNomeFilme().setText(Filmes[position].getNome());
        holder.getDetalhesFilme().setText(String.format("%s - %s", filmes[position].getGenero()));

        return view;
    }
//metodos da interface SectionIndexer


    @Override
    public Object[] getSections() {
        return sectionHeaders;
    }

    @Override
    public int getPositionForSection(int sectionIndex) {
        return positionForSectionMap.get(sectionIndex).intValue();
    }

    @Override
    public int getSectionForPosition(int position) {
        return sectionForPositionMap.get(position).intValue();
    }
}
