package com.example.l3;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class BoasVindas extends AppCompatActivity implements View.OnClickListener {

    private TextView tvnome;
    private String nome;
    private String welcome;
    private EditText veiculo;
    private Button btenviar;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boas_vindas);

        tvnome = (TextView) findViewById(R.id.tvnome);
        veiculo = (EditText) findViewById(R.id.veiculo);

        btenviar = (Button) findViewById(R.id.btenviar);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            nome = extras.getString("Nome");
            welcome = "Bem-vindx, "+nome+"!";
            tvnome.setText(welcome);

        }

        btenviar.setOnClickListener(this);


    }

    public void onClick(View view){
        if(view.getId()==R.id.btenviar){
        Intent intent = new Intent();
        intent.putExtra("Resultado",veiculo.getText().toString());
        setResult(78, intent);
        finish();
        }


    }


}