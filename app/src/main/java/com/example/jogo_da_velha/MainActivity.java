package com.example.jogo_da_velha;


import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    //variáveis bonitinhas
    private Button[] arrayBotoes = new Button[10];
    private String vez = "X";
    private int jogadas = 0;
    private String[] posicoes = new String[10]; //posição do tabuleiro do jogo
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
        ativarBotoes();
    }
    //método para ativar os botões - onClickButtons
    private void ativarBotoes(){
        for (int i = 1; i<10;i++){
            int finalI = i;
            arrayBotoes[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    jogada(finalI);
                }
            });
            posicoes[i]=""; // ele inicializa os botoes como vazio para depois trocar
        }
    }

    private void jogada(int x){
        if(posicoes[x] == ""){
            posicoes[x] = vez;
            jogadas++;
            if (vez == "X"){
                vez = "O";
            }else{
                vez = "X";
            }
        }
        exibirJogadas();

    }

    //método para atualizar o jogo
    private void exibirJogadas(){
        for (int x = 1; x<10;x++){
            arrayBotoes[x].setText(posicoes[x]);
        }
    }


}