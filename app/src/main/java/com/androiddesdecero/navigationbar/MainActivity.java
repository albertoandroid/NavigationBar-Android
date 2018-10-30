package com.androiddesdecero.navigationbar;

import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/*
    Navigation Bar -> Barra de Navegación
    La navigation bar son tres botones que nos permiten movernos por el dispositivo.
    Mientras que los terminales antiguos eran botones reales, en los nuevos terminales han pasado
    a ser parte de la pantalla lo que nos permite hacer los mismos cambios que con la status bar.
*/

public class MainActivity extends AppCompatActivity {

    private Button darkenIconsColorNavigationBar;
    private Button lightIconsColorNavigationBar;
    private Button changeColorNavigationBar;
    private Button hideNavigationBar;
    private int numeroColor = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Ocultar Action Bar
        getSupportActionBar().hide();
        //Poner el Backgroun con un Gradiente
        getWindow().setBackgroundDrawableResource(R.drawable.gradient);

        setUpNavigationBar();
    }

    private void setUpNavigationBar(){
        /*
        1 -> Oscurecer Iconos Navigation Bar
        */
        darkenIconsColorNavigationBar = findViewById(R.id.darkenIconsColorNavigationBar);
        darkenIconsColorNavigationBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                    getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR);
                }
            }
        });

        /*
        2 -> Aclarar Iconos Navigation Bar
        */
        lightIconsColorNavigationBar = findViewById(R.id.lightIconsColorNavigationBar);
        lightIconsColorNavigationBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                    getWindow().getDecorView().setSystemUiVisibility(0);
                }
            }
        });

        /*
        3 -> Cambiar Color Navigation Bar
        3.1 Transparent
        3.2 Color rojo
        3.3 Color Opaco
        */
        changeColorNavigationBar = findViewById(R.id.changeColorNavigationBar);
        changeColorNavigationBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
                    switch (numeroColor){
                        case 0:
                            getWindow().setNavigationBarColor(Color.TRANSPARENT);
                            break;
                        case 1:
                            getWindow().setNavigationBarColor(Color.RED);
                            break;
                        case 2:
                            getWindow().setNavigationBarColor(Color.parseColor("#BBFFFFFF"));
                            break;
                    }
                    if(numeroColor++ == 2)numeroColor=0;
                }
            }
        });

        /*
        4 -> Eliminar Navigation Bar
        */
        hideNavigationBar = findViewById(R.id.hideNavigationBar);
        hideNavigationBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View decorView = getWindow().getDecorView();
                int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
                decorView.setSystemUiVisibility(uiOptions);
            }
        });
    }
}
