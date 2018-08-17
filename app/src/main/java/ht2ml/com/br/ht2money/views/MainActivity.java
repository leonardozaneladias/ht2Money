package ht2ml.com.br.ht2money.views;

import android.annotation.SuppressLint;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;

import ht2ml.com.br.ht2money.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private FloatingActionButton fabMain, fabExpenses, fabEarning;
    private Boolean fabsHide = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Carregando fragmento principal
        getSupportFragmentManager().beginTransaction().add(R.id.fragmentContainer, new MainFragment()).commit();

        //Carrega os fabs
        fabMain = findViewById(R.id.fabMain);
        fabMain.setOnClickListener(this);

        fabExpenses = findViewById(R.id.fabExpenses);
        fabExpenses.setOnClickListener(this);

        fabEarning = findViewById(R.id.fabEarnings);


    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.fabMain){
            showHideFabs();
        }
        else if(view.getId() == R.id.fabExpenses){
            loadExpenseForm();
        }
    }

    private void loadExpenseForm() {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new ExpenseFormFragment()).commit();
    }

    @SuppressLint("RestrictedApi")
    private void showHideFabs(){

        //Define a animação
        AlphaAnimation fadeAnimation = new AlphaAnimation(0,1);
        // Duração
        fadeAnimation.setDuration(1000);
        //Atraso
        fadeAnimation.setStartOffset(100);


        //Define a animação
        AlphaAnimation hideAnimation = new AlphaAnimation(1,0);
        // Duração
        hideAnimation.setDuration(1000);
        //Atraso
        hideAnimation.setStartOffset(100);


        if(fabsHide){

            fabExpenses.setVisibility(View.VISIBLE);
            fabEarning.setVisibility(View.VISIBLE);

            fabExpenses.setAnimation(fadeAnimation);
            fabEarning.setAnimation(fadeAnimation);
        }else{

            fabExpenses.setVisibility(View.INVISIBLE);
            fabEarning.setVisibility(View.INVISIBLE);

            fabExpenses.setAnimation(hideAnimation);
            fabEarning.setAnimation(hideAnimation);

//            fabExpenses.clearAnimation();
//            fabEarning.clearAnimation();
        }



        fabsHide = !fabsHide;


    }
}
