package com.cursodevandroid.pedrapapeloutesoura;

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

    public void selecionadoPedra(View view) {
        opcaoSelecionada("pedra");
    }

    public void selecionadoPapel(View view) {
        opcaoSelecionada("papel");
    }

    public void selecionadoTesoura(View view) {
        opcaoSelecionada("tesoura");
    }


    public void opcaoSelecionada(String opcaoSelecionada) {
        TextView texto = findViewById(R.id.resultado);
        ImageView imagemApp = findViewById(R.id.resultadoApp);
        int numero = new Random().nextInt(3);
        String[] opcoes = {"pedra", "papel", "tesoura"};
        String opcaoApp = opcoes[numero];

        switch (opcaoApp) {
            case "pedra":
                imagemApp.setImageResource(R.drawable.pedra);
                break;
            case "papel":
                imagemApp.setImageResource(R.drawable.papel);
                break;
            case "tesoura":
                imagemApp.setImageResource(R.drawable.tesoura);
                break;
        }

        if (opcaoSelecionada == opcaoApp) {
            texto.setText("Empate!");
        }
        else if ((opcaoSelecionada == "pedra" && opcaoApp == "tesoura") ||
                (opcaoSelecionada == "papel" && opcaoApp == "pedra") ||
                (opcaoSelecionada == "tesoura" && opcaoApp == "papel")) {
            texto.setText("Você venceu! (:");
        }

        else {
            texto.setText("Você perdeu! ):");
        }
    }
}
