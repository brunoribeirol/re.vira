package com.revira.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.revira.R;
import com.revira.models.Endereco;
import com.revira.models.Produto;
import com.revira.models.empresa.Empresa;
import com.revira.models.empresa.EmpresaMediator;
import com.revira.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class CadastrarEmpresaActivity extends AppCompatActivity {

    private EditText edtNomeEmpresa, edtSenha, edtCnpj, edtCep, edtCidade, edtLogradouro, edtBairro, edtNumero;
    private Button btnCadastrarEmpresa;

    private List<Produto> produtosList = new ArrayList<>();
    private EmpresaMediator empresaMediator;

    private static final String TAG = "CadastrarEmpresaActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_empresa);

        edtNomeEmpresa = findViewById(R.id.edtNomeEmpresa);
        edtCnpj = findViewById(R.id.edtCnpj);
        edtCep = findViewById(R.id.edtCep);
        edtSenha = findViewById(R.id.edtSenha);
        edtCidade = findViewById(R.id.edtCidade);
        edtLogradouro = findViewById(R.id.edtLogradouro);
        edtBairro = findViewById(R.id.edtBairro);
        edtNumero = findViewById(R.id.edtNumero);
        btnCadastrarEmpresa = findViewById(R.id.btnCadastrarEmpresa);

        empresaMediator = new EmpresaMediator(Empresa.class);

        btnCadastrarEmpresa.setOnClickListener(v -> cadastrarEmpresa());
    }

    private void cadastrarEmpresa() {
        Log.d(TAG, "Iniciando cadastro de empresa");

        String nomeEmpresa = edtNomeEmpresa.getText().toString();
        String cnpj = edtCnpj.getText().toString();
        String senha = edtSenha.getText().toString();
        String cep = edtCep.getText().toString();
        String cidade = edtCidade.getText().toString();
        String logradouro = edtLogradouro.getText().toString();
        String bairro = edtBairro.getText().toString();
        String numeroStr = edtNumero.getText().toString();

        if (TextUtils.isEmpty(nomeEmpresa) || TextUtils.isEmpty(cnpj) ||
                TextUtils.isEmpty(cep) || TextUtils.isEmpty(cidade) ||
                TextUtils.isEmpty(logradouro) || TextUtils.isEmpty(bairro) ||
                TextUtils.isEmpty(numeroStr) || TextUtils.isEmpty(senha)) {
            Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
            Log.d(TAG, "Campos obrigatórios não preenchidos");
            return;
        }

        if (!Utils.validadorCnpj(cnpj)) {
            Toast.makeText(this, "CNPJ inválido", Toast.LENGTH_SHORT).show();
            Log.d(TAG, "CNPJ inválido: " + cnpj);
            return;
        }

        int numero;
        try {
            numero = Integer.parseInt(numeroStr);
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Número inválido", Toast.LENGTH_SHORT).show();
            Log.d(TAG, "Número inválido: " + numeroStr);
            return;
        }

        Endereco endereco = new Endereco(cep, cidade, logradouro, bairro, numero);
        Empresa empresa = new Empresa(nomeEmpresa, senha, cnpj, endereco, produtosList);

        boolean sucesso = empresaMediator.incluirEmpresa(nomeEmpresa, senha, cnpj, endereco);

        if (sucesso) {
            Toast.makeText(this, "Empresa cadastrada com sucesso", Toast.LENGTH_SHORT).show();
            Log.d(TAG, "Empresa cadastrada com sucesso: " + cnpj);
            Intent intent = new Intent(CadastrarEmpresaActivity.this, HomePageActivity.class);
            startActivity(intent);
            finish();
        } else {
            Toast.makeText(this, "Erro ao cadastrar empresa", Toast.LENGTH_SHORT).show();
            Log.d(TAG, "Erro ao cadastrar empresa: " + cnpj);
        }

        limparCampos();
    }

    private void limparCampos() {
        edtNomeEmpresa.setText("");
        edtCnpj.setText("");
        edtSenha.setText("");
        edtCep.setText("");
        edtCidade.setText("");
        edtLogradouro.setText("");
        edtBairro.setText("");
        edtNumero.setText("");
        produtosList.clear();
    }
}