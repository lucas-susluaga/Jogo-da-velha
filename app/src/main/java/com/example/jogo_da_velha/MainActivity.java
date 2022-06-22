package com.example.jogo_da_velha;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button[] arrayBotoes = new Button[10];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        arrayBotoes [1] = findViewById((R.id.botao1));
        arrayBotoes [2] = findViewById((R.id.botao2));
        arrayBotoes [3] = findViewById((R.id.botao3));
        arrayBotoes [4] = findViewById((R.id.botao4));
        arrayBotoes [5] = findViewById((R.id.botao5));
        arrayBotoes [6] = findViewById((R.id.botao6));
        arrayBotoes [7] = findViewById((R.id.botao7));
        arrayBotoes [8] = findViewById((R.id.botao8));
        arrayBotoes [9] = findViewById((R.id.botao9));
    }
}