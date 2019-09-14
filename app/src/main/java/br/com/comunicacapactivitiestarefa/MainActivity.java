package br.com.comunicacapactivitiestarefa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText inputNome;
    private TextInputEditText inputSobrenome;
    private TextInputEditText inputIdade;
    private Button btnEnviar;

    public static final String NOME_KEY = "nome";
    public static final String SOBRENOME_KEY = "sobrenome";
    public static final String IDADE_KEY = "idade";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputNome = findViewById(R.id.textInputLayoutNome);
        inputSobrenome = findViewById(R.id.textInputLayoutSobrenome);
        inputIdade = findViewById(R.id.textInputLayoutIdade);
        btnEnviar = findViewById(R.id.buttonEnviar);


        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nome = inputNome.getEditText().getText().toString();
                String sobrenome = inputSobrenome.getEditText().getText().toString();
                String idade = inputIdade.getEditText().getText().toString();

                if (!nome.isEmpty() && !sobrenome.isEmpty()){
                    //Mando para outra activity os dados

                    //Criando uma nova instancia do tipo Intent
                    Intent intent = new Intent(MainActivity.this, BoasVindas.class);

                    //Criando uma nova instancia do Bundle
                    Bundle bundle = new Bundle();

                    //Passando os dados para o bundle
                    bundle.putString(NOME_KEY, nome);
                    bundle.putString(SOBRENOME_KEY, sobrenome);
                    bundle.putString(IDADE_KEY, idade);

                    //Passo bundle para a intent
                    intent.putExtras(bundle);

                    //Passo a intent para o startActivity
                    startActivity(intent);

                }else{
                    inputNome.setError("Preencha o campo nome!");
                    inputSobrenome.setError("Preencha o campo sobrenome!");
                    inputIdade.setError("Preencha o campo idade!");

                }

            }
        });










    }
}
