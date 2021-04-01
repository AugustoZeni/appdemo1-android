package com.example.atividade1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {

    Button btnBotoes, btnToast, btnLogout;
    TextView lblUsuario;

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        SharedPreferences sharedPreferences = getSharedPreferences(getString(R.string.pref_key), Context.MODE_PRIVATE);

        btnBotoes = findViewById(R.id.btnBotoes);
        btnToast = findViewById(R.id.btnToast);
        btnLogout = findViewById(R.id.btnLogout_menu);
        lblUsuario = findViewById(R.id.lblUsuario_menu);

        context = MenuActivity.this;

        String nome_usuario = sharedPreferences.getString("usuario", "");
        lblUsuario.setText("Bem Vindo " + nome_usuario);

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

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{

                    sharedPreferences.edit().clear().commit();

                    Intent tela = new Intent(context, MainActivity.class);
                    startActivity(tela);
                    finish();

                }catch (Exception ex){
                    Toast.makeText(context, "Erro", Toast.LENGTH_SHORT).show();
                }
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