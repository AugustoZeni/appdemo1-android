package com.example.atividade1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {

    Button btnBotoes, btnToast;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        btnBotoes = findViewById(R.id.btnBotoes);
        btnToast = findViewById(R.id.btnToast);

        context = MenuActivity.this;

        btnToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exibirToast("TOAST");
            }
        });

        btnBotoes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tela = new Intent(context, BotoesActivity.class);
                startActivity(tela);
                finish();
            }
        });
    }
    private void exibirToast(String texto){
        try {
            Toast.makeText(context, texto, Toast.LENGTH_LONG).show();

        } catch (Exception ex) {

        }
    }
}