package com.example.jogo_da_velha;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class PrimeiraTela extends AppCompatActivity {

    private Button botao_p_tela;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primeira_tela);

        botao_p_tela = findViewById(R.id.botao_p_tela);

        botao_p_tela.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (PrimeiraTela.this, MainActivity.class);
                intent.putExtra("acao","jogar");
                startActivity(intent);
            }
        });
    }
}
