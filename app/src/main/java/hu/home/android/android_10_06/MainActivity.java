package hu.home.android.android_10_06;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button btnPlusz;
    private Button btnMinusz;
    private Button btnTipp;
    private ImageView hp_1;
    private ImageView hp_2;
    private ImageView hp_3;
    private ImageView hp_4;
    private TextView tippErtek;
    private ImageView[] eletek;

    private int tipp;
    private int gondoltSzam;
    private Random rnd;
    private int elet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        addListeners();
    }

    private void addListeners() {
        btnPlusz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tipp < 10){
                    tipp ++;
                    tippErtek.setText(String.valueOf(tipp));
                }else {
                    Toast.makeText(MainActivity.this, "A gondolt szám nem lehet nagyobb 10-nél", Toast.LENGTH_SHORT).show();
                }

            }
        });
        btnMinusz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tipp > 1){
                    tipp --;
                    tippErtek.setText(String.valueOf(tipp));
                }else {
                    Toast.makeText(MainActivity.this, "A gondolt szám nem lehet kisebb 1-nél", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnTipp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tipp > gondoltSzam){
                    eletCsokkent();
                    //eletCsokkentSwitchCase();
                    Toast.makeText(MainActivity.this, "A gondolt szám kisebb", Toast.LENGTH_SHORT).show();

                } else if (tipp < gondoltSzam){
                    eletCsokkent();
                    //eletCsokkentSwitchCase();
                    Toast.makeText(MainActivity.this, "A gondolt szám nagyobb", Toast.LENGTH_SHORT).show();
                } else {
                    //TODO: győzelem
                }
            }
        });
    }

    private void eletCsokkent() {
        if (elet > 0){
            elet --;
        }

        eletek[elet].setImageResource(R.drawable.heart1);

        if (elet == 0){
            //TODO: vereseg
        }
    }

    private void eletCsokkentSwitchCase() {
        elet--;
        switch (elet){
            case 3:
                hp_4.setImageResource(R.drawable.heart1);
                break;
            case 2:
                hp_3.setImageResource(R.drawable.heart1);
                break;
            case 1:
                hp_2.setImageResource(R.drawable.heart1);
                break;
            case 0:
                hp_1.setImageResource(R.drawable.heart1);
                break;
        }
        if (elet == 0){
            //TODO: vereseg
        }
    }

    private void init(){
        btnPlusz = findViewById(R.id.btnPlusz);
        btnMinusz = findViewById(R.id.btnMinusz);
        btnTipp = findViewById(R.id.btnTipp);
        hp_1 = findViewById(R.id.hp_1);
        hp_2 = findViewById(R.id.hp_2);
        hp_3 = findViewById(R.id.hp_3);
        hp_4 = findViewById(R.id.hp_4);
        tippErtek = findViewById(R.id.tippErtek);
        eletek = new ImageView[] {hp_1, hp_2, hp_3, hp_4};

        rnd = new Random();
        gondoltSzam = rnd.nextInt(10) + 1;
        tipp = 1;
        elet = 4;
        Log.d("gondolt", String.valueOf(gondoltSzam));
    }
}