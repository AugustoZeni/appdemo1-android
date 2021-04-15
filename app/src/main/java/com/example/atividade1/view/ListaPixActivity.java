package com.example.atividade1.view;

import android.content.Context;
import android.os.Bundle;

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
    ArrayList<String> objLista;

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

        fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try{

                    objLista.add("Nove Item");
                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1, objLista);

                    listaContasView.setAdapter(adapter);

                }catch (Exception ex){
                    Globais.exibirMensagem(context, ex.getMessage());
                }

            }
        });
    }
}