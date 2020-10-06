package com.example.atividadeonibus;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class BusaoAdapter extends ArrayAdapter<Busao> {

    int rId;

    public BusaoAdapter(Context context, int resource, List<Busao> objects) {
        super(context, resource, objects);
        rId = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View mView = convertView;
        if (mView == null) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            mView = inflater.inflate(rId, null);
        }
        Busao onibus = getItem(position);// recupera o objeto na posiçao

        // recupera todos os atributos do objeto
        TextView textMarca = mView.findViewById(R.id.textMarca);
        TextView textModelo = mView.findViewById(R.id.textModelo);
        TextView textOrigemDestino = mView.findViewById(R.id.textOrigemDestino);
        TextView textTipo = mView.findViewById(R.id.textTipo);
        TextView textAssentosTotais = mView.findViewById(R.id.textAssentosTotais);
        TextView textAssentosOcupados = mView.findViewById(R.id.textAssentosOcupados);

        textMarca.setText(onibus.getMarca());
        textModelo.setText(onibus.getModelo());
        textOrigemDestino.setText(onibus.getOrigemDestino());
        textTipo.setText(onibus.getTipo());
        textAssentosTotais.setText(onibus.getAssentosTotais());
        textAssentosOcupados.setText(onibus.getAssentosOcupado());

        int total = Integer.parseInt(onibus.getAssentosTotais());
        int ocupado = Integer.parseInt(onibus.getAssentosOcupado());

        if (total == ocupado) {
            textAssentosTotais.setTextColor(getContext().getResources().getColor(R.color.ocupado));
        } else {
            textAssentosTotais.setTextColor(getContext().getResources().getColor(R.color.livre));
        }

        return mView;
    }


}