package com.example.atividade1.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.atividade1.R;
import com.example.atividade1.model.Pix;
import com.example.atividade1.tools.Globais;

import java.text.NumberFormat;

public class PixActivity extends AppCompatActivity {

    Button btnPagar, btnReceber;
    EditText txtValor;
    TextView lblChave, lblSaldo;
    Pix contaPix;
    SharedPreferences sharedPreferences;

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pix);

        sharedPreferences = getSharedPreferences(getString(R.string.pref_key), Context.MODE_PRIVATE);

        contaPix = new Pix();
        contaPix.setChave(sharedPreferences.getString("chavePix",""));
        float saldo = sharedPreferences.getFloat("saldoPix",0);
        contaPix.setSaldo(saldo);
        contaPix.setCheque_especial(-2500);

        txtValor = findViewById(R.id.txtValor_pix);
        btnPagar = findViewById(R.id.btnPagar_pix);
        btnReceber = findViewById(R.id.btnReceber_pix);
        lblChave = findViewById(R.id.lblChave_pix);
        lblSaldo = findViewById(R.id.lblSaldo_pix);

        context = PixActivity.this;

        btnPagar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try{
                    if(!txtValor.getText().toString().trim().equals("")) {
                        float valor = Float.parseFloat(txtValor.getText().toString());
                        float saldo = contaPix.getSaldo() - valor;
                        float chequeEspecial = contaPix.getCheque_especial();

                        if(valor > 0) {
                            if (saldo > chequeEspecial) {
                                contaPix.setSaldo(saldo);
                                atualizarDados();
                            } else {
                                exibirToast("Cheque especial ultrapassado, operação não será concluída");
                                atualizarDados();
                            }
                        }else{
                            Globais.exibirMensagem(context, "Valor precisa ser maior que 0");
                        }
                    }else{
                        Globais.exibirMensagem(context, "Informe um valor valido");
                    }
                }catch (Exception ex){
                    Globais.exibirMensagem(context, ex.getMessage());
                }
            }
        });

        btnReceber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float valor = Float.parseFloat(txtValor.getText().toString());
                float saldo = contaPix.getSaldo() + valor;
                contaPix.setSaldo(saldo);

                atualizarDados();
            }
        });

        atualizarDados();

    }

    private void atualizarDados(){
        try{

            NumberFormat numberFormat = NumberFormat.getCurrencyInstance();
            String testeValor = numberFormat.format(contaPix.getSaldo());

            lblSaldo.setText(testeValor);
            lblChave.setText(contaPix.getChave());
            txtValor.setText("");

        }catch (Exception ex){
            Globais.exibirMensagem(context, ex.getMessage());
        }
    }

    private void exibirToast(String texto){
        try {
            Toast.makeText(context, texto, Toast.LENGTH_LONG).show();

        } catch (Exception ex) {

        }
    }

}