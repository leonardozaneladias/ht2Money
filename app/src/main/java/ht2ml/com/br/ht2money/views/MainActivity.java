package ht2ml.com.br.ht2money.views;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AlphaAnimation;

import ht2ml.com.br.ht2money.R;
import ht2ml.com.br.ht2money.controllers.BankController;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, NavigationView.OnNavigationItemSelectedListener {

    private FloatingActionButton fabMain, fabExpenses, fabEarning;
    private Boolean fabsHide = true;
    private Toolbar mToolBar;
    private DrawerLayout dl;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NavigationView navigationView = findViewById(R.id.navigationMenu);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.bringToFront();


        mToolBar = findViewById(R.id.mainTool);
        setSupportActionBar(mToolBar);

        dl = findViewById(R.id.drawerMain);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, dl, mToolBar, R.string.open_drawer, R.string.close_drawer);
        dl.addDrawerListener(toggle);
        toggle.syncState();

        //Carregando fragmento principal
        getSupportFragmentManager().beginTransaction().add(R.id.fragmentContainer, new MainFragment()).commit();

        //Carrega os fabs
        fabMain = findViewById(R.id.fabMain);
        fabMain.setOnClickListener(this);

        fabExpenses = findViewById(R.id.fabExpenses);
        fabExpenses.setOnClickListener(this);

        fabEarning = findViewById(R.id.fabEarnings);
        fabEarning.setOnClickListener(this);


    }

    private void closeDrawer(){
        if(dl.isDrawerOpen(GravityCompat.START)){
            dl.closeDrawer(GravityCompat.START);
        }
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.fabMain){
            showHideFabs();
        }
        else if(view.getId() == R.id.fabExpenses){
            loadExpenseForm();
        }else if(view.getId() == R.id.fabEarnings){
            loadEarnigForm();
        }
    }

    private void loadEarnigForm() {

        changeActionBarTitle(R.string.actionbar_earning_form, true);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new EarningsFormFragment()).commit();
        showHideFabs();
    }

    private void loadExpenseForm() {

        changeActionBarTitle(R.string.actionbar_expenses_form, true);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new ExpenseFormFragment()).commit();
        showHideFabs();
    }

    private void changeActionBarTitle(Integer stringId, boolean isNotHome) {
        getSupportActionBar().setTitle(stringId);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(isNotHome);
        //getSupportActionBar().setDisplayShowHomeEnabled(isNotHome);
    }

    @SuppressLint("RestrictedApi")
    private void showHideFabs(){

        //Define a animação
        AlphaAnimation fadeAnimation = new AlphaAnimation(0,1);
        // Duração
        fadeAnimation.setDuration(500);
        //Atraso
        fadeAnimation.setStartOffset(50);


        //Define a animação
        AlphaAnimation hideAnimation = new AlphaAnimation(1,0);
        // Duração
        hideAnimation.setDuration(200);
        //Atraso
        hideAnimation.setStartOffset(20);


        if(fabsHide){

            fabExpenses.setVisibility(View.VISIBLE);
            fabEarning.setVisibility(View.VISIBLE);

            fabExpenses.setAnimation(fadeAnimation);
            fabEarning.setAnimation(fadeAnimation);
        }else{

            fabExpenses.setVisibility(View.GONE);
            fabEarning.setVisibility(View.GONE);

            fabExpenses.setAnimation(hideAnimation);
            fabEarning.setAnimation(hideAnimation);

//            fabExpenses.clearAnimation();
//            fabEarning.clearAnimation();
        }



        fabsHide = !fabsHide;


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            backToHome();
        }

        return super.onOptionsItemSelected(item);
    }

    private void backToHome() {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new MainFragment()).commit();
        changeActionBarTitle(R.string.app_name, false);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){

            case R.id.drawerMenuMain:
                backToHome();
                break;
            case R.id.drawerMenuBank:
                if(BankController.get() != null){
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new BankInfoFragment()).commit();
                }else{
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new NoBankFragment()).commit();
                }
                break;

        }
        closeDrawer();
        return false;
    }
}
