package br.usjt.filme;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.SectionIndexer;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.Hashtable;
import java.util.Locale;

public class FilmeAdapter extends BaseAdapter implements SectionIndexer
{
    Activity context;
    Filme[] filmes;
    Object[] sectionHeaders;
    Hashtable<Integer, Integer> positionForSectionMap;
    Hashtable<Integer, Integer> sectionForPositionMap;

    public FilmeAdapter(Activity context, Filme[] filmes){
        this.context = context;
        this.filmes = filmes;
        sectionHeaders = SectionIndexBuilder.BuildSectionHeaders(filmes);
        positionForSectionMap = SectionIndexBuilder.BuildPositionForSectionMap(filmes);
        sectionForPositionMap = SectionIndexBuilder.BuildSectionForPositionMap(filmes);

    }
    @Override
    public int getCount() {
        return filmes.length;
    }

    @Override
    public Object getItem(int position) {
        if(position >= 0 && position < filmes.length)
            return filmes[position];
        else
            return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
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
            view = inflater.inflate(R.layout.linha_cerveja, parent, false);

            ImageView fotinhoFilme = (ImageView)view.findViewById(R.id.fotinhoFilmeImageView);
            TextView nomeFilme = (TextView)view.findViewById(R.id.nomeFilmeTextView);
            TextView detalhesFilme = (TextView)view.findViewById(R.id.detalhesFilmeTextView);
            //faz cache dos widgets instanciados na tag da view para reusar quando houver reciclagem
            view.setTag(new ViewHolder(fotinhoFilme, nomeFilme, detalhesFilme));
        }
        //usa os widgets cacheados na view reciclada
        ViewHolder holder = (ViewHolder)view.getTag();
        //carrega os novos valores
        Drawable drawable = Util.getDrawable(context, filmes[position].getImagem());
        holder.getFotinhoFilme().setImageDrawable(drawable);
        Locale locale = new Locale("pt", "BR");
        NumberFormat formatter = NumberFormat.getCurrencyInstance(locale);
        holder.getNomeFilme().setText(filmes[position].getNome());
        holder.getDetalhesFilme().setText(String.format("%s - %s", filmes[position].getEstilo(),
                formatter.format(filmes[position].getPreco())));

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
