package com.revira.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.revira.MainActivity;
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

        // Configura o clique do botão "Cadastrar Empresa"
        btnCadastrarEmpresa.setOnClickListener(v -> {
            // Chama o método cadastrarEmpresa() ao clicar no botão
            cadastrarEmpresa();
        });
    }

    private void cadastrarEmpresa() {
        Log.d(TAG, "Iniciando cadastro de empresa");

        // Obtém os valores dos campos
        String nomeEmpresa = edtNomeEmpresa.getText().toString();
        String cnpj = edtCnpj.getText().toString();
        String senha = edtSenha.getText().toString();
        String cep = edtCep.getText().toString();
        String cidade = edtCidade.getText().toString();
        String logradouro = edtLogradouro.getText().toString();
        String bairro = edtBairro.getText().toString();
        String numeroStr = edtNumero.getText().toString();

        // Verifica se todos os campos estão preenchidos
        if (TextUtils.isEmpty(nomeEmpresa) || TextUtils.isEmpty(cnpj) ||
                TextUtils.isEmpty(cep) || TextUtils.isEmpty(cidade) ||
                TextUtils.isEmpty(logradouro) || TextUtils.isEmpty(bairro) ||
                TextUtils.isEmpty(numeroStr) || TextUtils.isEmpty(senha)) {
            Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
            Log.d(TAG, "Campos obrigatórios não preenchidos");
            return;
        }

        // Verifica se o CNPJ é válido
        if (!Utils.validadorCnpj(cnpj)) {
            Toast.makeText(this, "CNPJ inválido", Toast.LENGTH_SHORT).show();
            Log.d(TAG, "CNPJ inválido: " + cnpj);
            return;
        }

        // Converte o número para inteiro
        int numero;
        try {
            numero = Integer.parseInt(numeroStr);
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Número inválido", Toast.LENGTH_SHORT).show();
            Log.d(TAG, "Número inválido: " + numeroStr);
            return;
        }

        // Cria o objeto Endereco com os valores dos campos
        Endereco endereco = new Endereco(cep, cidade, logradouro, bairro, numero);

        // Cria o objeto Empresa com os valores dos campos e a lista de produtos vazia
        Empresa empresa = new Empresa(nomeEmpresa, senha, cnpj, endereco, produtosList);

            // Abre a tela de ProdutosRetornaveisActivity
            Intent intent = new Intent(CadastrarEmpresaActivity.this, ProdutosRetornaveisActivity.class);
            startActivity(intent);


        // Limpa os campos após o cadastro
        limparCampos();
    }


    @Override
    public void onBackPressed() {
        // Chama a MainActivity quando o botão de voltar for pressionado
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish(); // Finaliza a atividade atual para evitar empilhar várias atividades na parte de trás
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
