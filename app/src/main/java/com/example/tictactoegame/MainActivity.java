package com.example.tictactoegame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    // player presentation
    // 0 - X
    // 1 - O
    // 2 - NULL
    int activePlayer = 0;
    boolean gameActive = true;
    int[] gameState = {2,2,2,2,2,2,2,2,2};
    int[][] winPositions = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};

    public void ticTac_Clicked(View view){
        ImageView img = (ImageView) view;
        int tappedImage = Integer.parseInt(img.getTag().toString());

        if(!gameActive){
            reset(view);
        }

        if(gameState[tappedImage] == 2 && gameActive){
            gameState[tappedImage] = activePlayer;
            img.setTranslationY(-1000f);
            if(activePlayer == 0){
                img.setImageResource(R.drawable.x);
                TextView status = findViewById(R.id.txtStatus);
                status.setText("O's Turn, Tap to Play!!");
                activePlayer = 1;
            }
            else {
                img.setImageResource(R.drawable.o);
                TextView status = findViewById(R.id.txtStatus);
                status.setText("X's Turn, Tap to Play!!");
                activePlayer = 0;
            }
            img.animate().translationYBy(1000f).setDuration(300);
        }
        for(int[] winPos : winPositions){
            if((gameState[winPos[0]] == gameState[winPos[1]]) &&
                    (gameState[winPos[1]] == gameState[winPos[2]]) && gameState[winPos[0]] != 2 ){
                String winStr;
                if(gameState[winPos[0]] == 0){
                    winStr = "X has Won the Game!!";
                }
                else{
                    winStr = "O has Won the Game!!";
                }
                TextView status = findViewById(R.id.txtStatus);
                status.setText(winStr);
                gameActive = false;
            }
        }
    }

    public void reset(View view){
        gameActive = true;
        activePlayer = 0;
        for(int i = 0;i<gameState.length;i++){
            gameState[i] = 2;
        }
        ((ImageView) findViewById((R.id.imageView1))).setImageResource(0);
        ((ImageView) findViewById((R.id.imageView2))).setImageResource(0);
        ((ImageView) findViewById((R.id.imageView3))).setImageResource(0);
        ((ImageView) findViewById((R.id.imageView4))).setImageResource(0);
        ((ImageView) findViewById((R.id.imageView5))).setImageResource(0);
        ((ImageView) findViewById((R.id.imageView6))).setImageResource(0);
        ((ImageView) findViewById((R.id.imageView7))).setImageResource(0);
        ((ImageView) findViewById((R.id.imageView8))).setImageResource(0);
        ((ImageView) findViewById((R.id.imageView9))).setImageResource(0);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}