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

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText etsenha;
    private EditText etlogin;
    private Button btenviar;
    private String senha;
    private String login;
    private static final String TAG = "MainActivity";
    private TextView resultado;

    ActivityResultLauncher<Intent> activityLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    Log.d(TAG, "onActivityResult:");
                    if(result.getResultCode() == 78)
                    {
                        Intent intent = result.getData();
                        if(intent != null){
                            String data = intent.getStringExtra("Resultado");
                            resultado.setText(data);
                        }
                    }
                }
            }
    );
    protected void onSaveInstanceState(Bundle dados) {

        super.onSaveInstanceState(dados);
        dados.putString("Nome", login);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btenviar = (Button) findViewById(R.id.btenviar);
        etlogin = (EditText) findViewById(R.id.etlogin);
        etsenha = (EditText) findViewById(R.id.etsenha);
        btenviar.setOnClickListener(this);

        resultado = (TextView) findViewById(R.id.resultado);

        if(savedInstanceState!= null){
            login = savedInstanceState.getString("Nome");
            etlogin.setText(login);
        }





    }

    public void onClick(View view){
        if(view.getId()==R.id.btenviar){

            senha = etsenha.getText().toString().trim();
            login = etlogin.getText().toString().trim();


           if(senha.equals("12345") && login.equals("Lorenzo"))
            {

                Intent  intent2 = new Intent(MainActivity.this, BoasVindas.class);
                intent2.putExtra("Nome",login);
                activityLauncher.launch(intent2);


            }
            else{
               Toast.makeText(this, "LOGIN/EMAIL INCORRETOS", Toast.LENGTH_SHORT).show();
            }
        }


    }
}