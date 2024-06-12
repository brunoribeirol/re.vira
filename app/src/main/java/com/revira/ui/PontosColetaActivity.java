package com.revira.ui;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import com.revira.MainActivity;
import com.revira.R;

public class PontosColetaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pontos_coleta);
    }

    @Override
    public void onBackPressed() {
        // Voltar para a MainActivity quando o botão de voltar for pressionado
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish(); // Finalizar a PontosColetaActivity, mas manter a MainActivity intacta
    }
}
