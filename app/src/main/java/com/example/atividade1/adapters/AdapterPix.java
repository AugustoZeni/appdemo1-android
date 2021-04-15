package com.example.atividade1.adapters;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.atividade1.R;
import com.example.atividade1.model.Pix;
import com.example.atividade1.tools.Globais;

import java.util.ArrayList;
import java.util.List;

public class AdapterPix extends BaseAdapter {

    private final List<Pix> listaPix;
    private final Activity act;

    public AdapterPix(List<Pix> listaPix, Activity act){
        this.listaPix = listaPix;
        this.act = act;
    }

    @Override
    public int getCount() {
        return listaPix.size();
    }

    @Override
    public Object getItem(int position) {
        return listaPix.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View contentView, ViewGroup parent) {

        Pix objeto = listaPix.get(position);
        View view = act.getLayoutInflater().inflate(R.layout.item_pix, parent, false);

        TextView chave = view.findViewById(R.id.lblChave_item_pix);
        TextView nome = view.findViewById(R.id.lblNome_item_pix);

        chave.setText(objeto.getChave());
        nome.setText(objeto.getNome());

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Globais.exibirMensagem(act, "Clicou no " + objeto.getNome());
            }
        });

        return view;
    }
}
