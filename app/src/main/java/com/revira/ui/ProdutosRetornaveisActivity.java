package com.revira.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.revira.R;

public class ProdutosRetornaveisActivity extends AppCompatActivity {

    private EditText edtCategory, edtProduct1, edtProduct2, edtProduct3, edtProduct4, edtProduct5;
    private Button btnEnviar, btnVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produtos_empresa);

        edtCategory = findViewById(R.id.edtCategory);
        edtProduct1 = findViewById(R.id.edtProduct1);
        edtProduct2 = findViewById(R.id.edtProduct2);
        edtProduct3 = findViewById(R.id.edtProduct3);
        edtProduct4 = findViewById(R.id.edtProduct4);
        edtProduct5 = findViewById(R.id.edtProduct5);
        btnEnviar = findViewById(R.id.btnEnviar);
        btnVoltar = findViewById(R.id.btnVoltar);

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitForm();
            }
        });

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Voltar para a activity CadastrarEmpresaActivity
                Intent intent = new Intent(ProdutosRetornaveisActivity.this, CadastrarEmpresaActivity.class);
                startActivity(intent);
                finish(); // Encerra a atividade atual para evitar voltar para ela com o botão de retorno
            }
        });
    }

    private void submitForm() {
        String category = edtCategory.getText().toString();
        String product1 = edtProduct1.getText().toString();
        String product2 = edtProduct2.getText().toString();
        String product3 = edtProduct3.getText().toString();
        String product4 = edtProduct4.getText().toString();
        String product5 = edtProduct5.getText().toString();

        if (TextUtils.isEmpty(category) || TextUtils.isEmpty(product1)) {
            Toast.makeText(this, "Preencha pelo menos a categoria e o primeiro produto", Toast.LENGTH_SHORT).show();
            return;
        }

        // Aqui você pode adicionar a lógica para lidar com os dados, como salvar no banco de dados ou enviar para um servidor

        Toast.makeText(this, "Dados enviados com sucesso", Toast.LENGTH_SHORT).show();

        // Abre a HomePageActivity
        Intent intent = new Intent(ProdutosRetornaveisActivity.this, HomePageActivity.class);
        startActivity(intent);

        // Limpar os campos após o envio
        edtCategory.setText("");
        edtProduct1.setText("");
        edtProduct2.setText("");
        edtProduct3.setText("");
        edtProduct4.setText("");
        edtProduct5.setText("");
    }
}
