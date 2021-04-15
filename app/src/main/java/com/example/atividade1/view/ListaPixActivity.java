package com.example.atividade1.view;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import com.example.atividade1.adapters.AdapterPix;
import com.example.atividade1.model.Pix;
import com.example.atividade1.tools.Globais;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.atividade1.R;

import java.util.ArrayList;
import java.util.List;

public class ListaPixActivity extends AppCompatActivity {

    FloatingActionButton fabAdd;
    ListView listaContasView;
    Context context;
    ArrayList<Pix> objLista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_pix);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fabAdd = findViewById(R.id.fabAdicionar_pix);
        listaContasView = findViewById(R.id.listViewContasPix_pix);

        context = ListaPixActivity.this;

        objLista = new ArrayList<>();

        Pix objeto = new Pix("Augusto", "035.911.590-00", 200, -2000);
        objLista.add(objeto);
        objeto = new Pix("Doga", "085.783.575-24", 600, -7000);
        objLista.add(objeto);

        fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try{

                    Pix objeto = new Pix("xxxxx", "xxx.xxx.xxx-xx", 200, -2000);

                    objLista.add(objeto);

                    //ArrayAdapter<Pix> adapter = new ArrayAdapter<Pix>(context, android.R.layout.simple_list_item_1, objLista);
                    AdapterPix adapter = new AdapterPix(objLista, (Activity) context);
                    listaContasView.setAdapter(adapter);

                }catch (Exception ex){
                    Globais.exibirMensagem(context, ex.getMessage());
                }

            }
        });
    }
}