package com.example.jogopedrapapeltesoura;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selecionarPedra(View view){
        this.opcaoSelecionada("pedra");
    }

    public void selecionarPapel(View view){
        this.opcaoSelecionada("papel");
    }

    public void selecionarTesoura(View view){
        this.opcaoSelecionada("tesoura");
    }

    public void opcaoSelecionada(String opcaoUsuario){

        ImageView selecaoMaquina = findViewById(R.id.selecaoMaquina);
        TextView textoResultado = findViewById(R.id.textoResultado);

        int numero = new Random() .nextInt(3); // 0,1 e 2
        String[] opcoes = {"pedra", "papel", "tesoura"};
        String opcaoApp = opcoes[numero];

        switch ( opcaoApp ){
            case "pedra" :
                selecaoMaquina.setImageResource(R.drawable.pedra);
                break;
            case "papel" :
                selecaoMaquina.setImageResource(R.drawable.papel);
                break;
            case "tesoura" :
                selecaoMaquina.setImageResource(R.drawable.tesoura);
                break;
    }

    if((opcaoApp == "tesoura" && opcaoUsuario == "papel") || (opcaoApp == "papel" && opcaoUsuario == "pedra") || (opcaoApp == "pedra" && opcaoUsuario == "tesoura")){ //App ganhador
        textoResultado.setText("Você perdeu!");
    }else if((opcaoUsuario == "tesoura" && opcaoApp == "papel") || (opcaoUsuario == "papel" && opcaoApp == "pedra") || (opcaoUsuario == "pedra" && opcaoApp == "tesoura")){ //Usuário ganhador
        textoResultado.setText("Você Ganhou!");
    }else //Empate
        textoResultado.setText("Empatamos!");
    }
}