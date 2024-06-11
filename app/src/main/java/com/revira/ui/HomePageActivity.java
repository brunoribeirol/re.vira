package com.revira.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.revira.R;

public class HomePageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        Button btnNomeEmpresa = findViewById(R.id.btnNomeEmpresa);
        btnNomeEmpresa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Redirecionar para a tela do perfil (PerfilActivity)
                Intent intent = new Intent(HomePageActivity.this, PerfilActivity.class);
                startActivity(intent);
            }
        });
    }
}
