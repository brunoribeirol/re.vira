package com.revira;

import android.content.Intent;
import android.os.Bundle;
import android.os.strictmode.WebViewMethodCalledOnWrongThreadViolation;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.revira.R;
import com.revira.ui.CadastrarEmpresaActivity;
import com.revira.ui.HomePageActivity;
import com.revira.ui.PerfilActivity;
import com.revira.ui.PontosColetaActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnCadastrar(View view) {
        Intent intent = new Intent(this, CadastrarEmpresaActivity.class);
        startActivity(intent);
    }

    public void btnLogin(View view) {
        Intent intent = new Intent(this, HomePageActivity.class);
        startActivity(intent);
    }

    public void btnDescarte(View view) {
        Intent intent = new Intent(this, PontosColetaActivity.class);
        startActivity(intent);
    }
}