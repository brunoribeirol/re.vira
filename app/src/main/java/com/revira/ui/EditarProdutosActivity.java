package com.revira.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.revira.R;

public class EditarProdutosActivity extends AppCompatActivity {

    private EditText edtProduct1, edtProduct2, edtProduct3, edtProduct4, edtProduct5;
    private Button btnSave, btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_produtos_empresa);

        // Inicializa os campos de texto
        edtProduct1 = findViewById(R.id.edtProduct1);
        edtProduct2 = findViewById(R.id.edtProduct2);
        edtProduct3 = findViewById(R.id.edtProduct3);
        edtProduct4 = findViewById(R.id.edtProduct4);
        edtProduct5 = findViewById(R.id.edtProduct5);

        // Inicializa os botões
        btnSave = findViewById(R.id.btnSave);
        btnCancel = findViewById(R.id.btnCancel);

        // Define o comportamento do botão "Salvar"
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveProducts();
            }
        });

        // Define o comportamento do botão "Cancelar"
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancelEditing();
            }
        });
    }

    private void saveProducts() {
        // Pega os valores dos campos de texto
        String product1 = edtProduct1.getText().toString();
        String product2 = edtProduct2.getText().toString();
        String product3 = edtProduct3.getText().toString();
        String product4 = edtProduct4.getText().toString();
        String product5 = edtProduct5.getText().toString();

        // Implementa a lógica para salvar os produtos
        // Por exemplo, pode salvar em um banco de dados, enviar para um servidor, etc.
        // Aqui apenas mostra uma mensagem de confirmação
        Toast.makeText(this, "Produtos salvos com sucesso!", Toast.LENGTH_SHORT).show();

        // Finaliza a activity após salvar
        finish();
    }

    private void cancelEditing() {
        // Apenas finaliza a activity sem salvar
        Toast.makeText(this, "Edição cancelada", Toast.LENGTH_SHORT).show();
        finish();
    }
}
