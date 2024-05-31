package com.revira;

import android.content.Intent;
import android.os.Bundle;
import android.os.strictmode.WebViewMethodCalledOnWrongThreadViolation;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.revira.R;
import com.revira.ui.CadastrarEmpresaActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onCadastrarEmpresaClick(View view) {
        Intent intent = new Intent(this, CadastrarEmpresaActivity.class);
        startActivity(intent);
    }

}
