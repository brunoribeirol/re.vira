package com.revira.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.revira.MainActivity;
import com.revira.R;

public class PerfilActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        // Inicializar elementos de UI
        ImageView imgLogoEmpresa = findViewById(R.id.imgLogoEmpresa);
        TextView tvNomeEmpresa = findViewById(R.id.tvNomeEmpresa);
        TextView tvCnpjEmpresa = findViewById(R.id.tvCnpjEmpresa);
        TextView tvEnderecoEmpresa = findViewById(R.id.tvEnderecoEmpresa);
        TextView tvSaldoPropaganda = findViewById(R.id.tvSaldoPropaganda);
        TextView tvQuantidadePessoasAnuncio = findViewById(R.id.tvQuantidadePessoasAnuncio);
        TextView tvQuantidadePodio = findViewById(R.id.tvQuantidadePodio);
        TextView tvQuantidadeProdutosRecolhidos = findViewById(R.id.tvQuantidadeProdutosRecolhidos);
        Button btnVoltar = findViewById(R.id.btnVoltar);
        Button btnEditarProdutos = findViewById(R.id.btnEditarProdutos);
        Button btnExcluirEmpresa = findViewById(R.id.btnExcluirEmpresa);
        Button btnSair = findViewById(R.id.btnSair);

        // Definir comportamento dos botões
        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Voltar para a HomePageActivity
                Intent intent = new Intent(PerfilActivity.this, HomePageActivity.class);
                startActivity(intent);
                finish(); // Encerra a atividade atual para evitar voltar para ela com o botão de retorno
            }
        });


        btnEditarProdutos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Implementar ação de editar produtos
            }
        });

        btnExcluirEmpresa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Implementar ação de excluir empresa
            }
        });

        btnSair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Implementar ação de sair
                Intent intent = new Intent(PerfilActivity.this, MainActivity.class);
                startActivity(intent);
                finish(); // Encerra a atividade atual para evitar voltar para ela com o botão de retorno
            }
        });
    }
}
