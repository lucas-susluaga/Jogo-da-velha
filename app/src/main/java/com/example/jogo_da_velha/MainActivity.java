package com.example.jogo_da_velha;


import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    //variáveis bonitinhas
    private Button[] arrayBotoes = new Button[10];
    private String opcao = "X"; //será criado um alerta para definir qual é a vez que o usuário escolher
    private int jogadas = 0;
    private String[] posicoes = new String[10]; //posições do tabuleiro no jogo
    private Button botaoRestart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //botao resetar jogo
        botaoRestart = findViewById(R.id.botaoRestart);
        botaoRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetarJogo();
            }
        });

        arrayBotoes[1] = findViewById((R.id.botao1));
        arrayBotoes[2] = findViewById((R.id.botao2));
        arrayBotoes[3] = findViewById((R.id.botao3));
        arrayBotoes[4] = findViewById((R.id.botao4));
        arrayBotoes[5] = findViewById((R.id.botao5));
        arrayBotoes[6] = findViewById((R.id.botao6));
        arrayBotoes[7] = findViewById((R.id.botao7));
        arrayBotoes[8] = findViewById((R.id.botao8));
        arrayBotoes[9] = findViewById((R.id.botao9));
        ativarBotoes();
        escolherForma();


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
    //ainda será implementado um alerta que substituirá a opção X como escolha padrão aqui ness método
    private void jogada(int x){
        if(posicoes[x] == ""){
            posicoes[x] = opcao;
            jogadas++;
            if (opcao == "X"){
                opcao = "O";
            }else{
                opcao = "X";
            }
        }
        exibirJogadas();
        verifica();
    }

    //método para atualizar o jogo
    private void exibirJogadas(){
        for (int x = 1; x<10;x++){
            arrayBotoes[x].setText(posicoes[x]);
        }
    }

    //método para exibir o alerta do resultado do jogo
    private void verificaGanhador(String ganhador){
        //Inicia com a criação de um alerta que mostra quem ganhou ...
        AlertDialog.Builder builder = new
                AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Resultado");
        if (ganhador.equals("")){
            builder.setMessage("Empate");
        }else{
            if (ganhador.equals("X")){
                builder.setMessage("\"X\" é o vencedor");

            }else{
                builder.setMessage("\"O\" é o vencedor");
            }
        }
        /*...após mostra uma opção para começar um novo jogo que reseta as informações
        das posições e jogadas */
        builder.setPositiveButton("Novo jogo", new
                DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        jogadas = 0;
                        for (int x = 1;x<10;x++){
                            posicoes[x]="";
                        }
                        exibirJogadas();
                        escolherForma();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();

    }

    /*método que verifica as posições das jogadas e utiliza o método verificaGanhador
     para exibir quem ganhou
     */
    private void verifica(){
        //ganhador 1ª linha
        if(posicoes[1].equals(posicoes[2]) &&
                posicoes[1].equals(posicoes[3]) && posicoes[1].toString() != ""){
            verificaGanhador(posicoes[1]);

            return;
        }
        //ganhador 2ª linha
        if(posicoes[4].equals(posicoes[5]) &&
                posicoes[4].equals(posicoes[6]) && posicoes[4].toString() != ""){
            verificaGanhador(posicoes[4]);

            return;
        }
        //ganhador 3ª linha
        if(posicoes[7].equals(posicoes[8]) &&
                posicoes[7].equals(posicoes[9]) && posicoes[7].toString() != ""){
            verificaGanhador(posicoes[7]);

            return;
        }
        //ganhador 1ª coluna
        if(posicoes[1].equals(posicoes[4]) &&
                posicoes[1].equals(posicoes[7]) && posicoes[1].toString() != ""){
            verificaGanhador(posicoes[1]);

            return;
        }
        //ganhador 2ª coluna
        if(posicoes[2].equals(posicoes[5]) &&
                posicoes[2].equals(posicoes[8]) && posicoes[2].toString() != ""){
            verificaGanhador(posicoes[2]);

            return;
        }
        //ganhador 3ª coluna
        if(posicoes[3].equals(posicoes[6]) &&
                posicoes[3].equals(posicoes[9]) && posicoes[3].toString() != ""){
            verificaGanhador(posicoes[3]);

            return;
        }
        //ganhador diagonal principal
        if(posicoes[1].equals(posicoes[5]) &&
                posicoes[1].equals(posicoes[9]) && posicoes[1].toString() != ""){
            verificaGanhador(posicoes[1]);

            return;
        }
        //ganhador diagonal secundária
        if(posicoes[3].equals(posicoes[5]) &&
                posicoes[3].equals(posicoes[7]) && posicoes[3].toString() != ""){
            verificaGanhador(posicoes[3]);

            return;
        }
        //Em caso de empate - todos campos preenchidos
        if (jogadas == 9){
            verificaGanhador("");

            return;
        }
    }

    //método do alert para escolher
    private void escolherForma(){
        androidx.appcompat.app.AlertDialog.Builder alerta = new androidx.appcompat.app.AlertDialog.Builder(this);
        alerta.setTitle("Escolha sua forma => Player 1");
        // alerta.setIcon(android.R.drawable.ic_input_add);

        //EditText etForma = new EditText(this);
        //etForma.setHint("Primeiro Jogador:");

        //alerta.setView(etForma);

        alerta.setNeutralButton("X", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                opcao="X";
            }
        });

        alerta.setPositiveButton("0", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                opcao="O";
            }
        });
        alerta.show();
    }


    private void resetarJogo(){
        jogadas = 0;
        for (int x = 1;x<10;x++){
            posicoes[x]="";
        }
        exibirJogadas();
        escolherForma();

    }
}