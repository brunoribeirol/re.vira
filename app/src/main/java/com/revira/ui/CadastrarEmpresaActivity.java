package com.revira.ui;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.revira.R;

import com.revira.data.EmpresaContract;
import com.revira.data.EmpresaDbHelper;
import com.revira.models.empresa.Empresa;
import com.revira.models.Endereco;
import com.revira.models.Produto;
import com.revira.utils.Utils;
import java.util.ArrayList;
import java.util.List;

public class CadastrarEmpresaActivity extends AppCompatActivity {

    private EditText edtNomeEmpresa, edtCnpj, edtCep, edtCidade, edtLogradouro, edtBairro, edtNumero;
    private EditText edtProdutoNome, edtProdutoCategoria;
    private Button btnAdicionarProduto, btnCadastrarEmpresa;

    private List<Produto> produtosList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_empresa);

        edtNomeEmpresa = findViewById(R.id.edtNomeEmpresa);
        edtCnpj = findViewById(R.id.edtCnpj);
        edtCep = findViewById(R.id.edtCep);
        edtCidade = findViewById(R.id.edtCidade);
        edtLogradouro = findViewById(R.id.edtLogradouro);
        edtBairro = findViewById(R.id.edtBairro);
        edtNumero = findViewById(R.id.edtNumero);
        btnCadastrarEmpresa = findViewById(R.id.btnCadastrarEmpresa);

//        btnAdicionarProduto.setOnClickListener(v -> adicionarProduto());
        btnCadastrarEmpresa.setOnClickListener(v -> cadastrarEmpresa());
    }

//    private void adicionarProduto() {
//        String nomeProduto = edtProdutoNome.getText().toString();
//        String categoriaProduto = edtProdutoCategoria.getText().toString();
//
//        if (TextUtils.isEmpty(nomeProduto) || TextUtils.isEmpty(categoriaProduto)) {
//            Toast.makeText(this, "Preencha todos os campos do produto", Toast.LENGTH_SHORT).show();
//            return;
//        }
//
//        Produto produto = new Produto(nomeProduto, categoriaProduto, new ArrayList<>());
//        produtosList.add(produto);
//
//        Toast.makeText(this, "Produto adicionado", Toast.LENGTH_SHORT).show();
//        edtProdutoNome.setText("");
//        edtProdutoCategoria.setText("");
//    }

    private void cadastrarEmpresa() {
        String nomeEmpresa = edtNomeEmpresa.getText().toString();
        String cnpj = edtCnpj.getText().toString();
        String cep = edtCep.getText().toString();
        String cidade = edtCidade.getText().toString();
        String logradouro = edtLogradouro.getText().toString();
        String bairro = edtBairro.getText().toString();
        int numero = Integer.parseInt(edtNumero.getText().toString());

        if (TextUtils.isEmpty(nomeEmpresa) || TextUtils.isEmpty(cnpj) ||
                TextUtils.isEmpty(cep) || TextUtils.isEmpty(cidade) ||
                TextUtils.isEmpty(logradouro) || TextUtils.isEmpty(bairro) ||
                TextUtils.isEmpty(String.valueOf(numero))) {
            Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!Utils.validadorCnpj(cnpj)) {
            Toast.makeText(this, "CNPJ inválido", Toast.LENGTH_SHORT).show();
            return;
        }

        Endereco endereco = new Endereco(cep, cidade, logradouro, bairro, numero);
        Empresa empresa = new Empresa(nomeEmpresa, cnpj, endereco, produtosList);

        // Aqui você pode adicionar código para salvar a empresa em um banco de dados ou enviar para um servidor
        EmpresaDbHelper dbHelper = new EmpresaDbHelper(this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(EmpresaContract.EmpresaEntry.COLUMN_NOME, empresa.getNome());
        values.put(EmpresaContract.EmpresaEntry.COLUMN_CNPJ, empresa.getCnpj());
//        values.put(EmpresaContract.EmpresaEntry.COLUMN_ENDERECO, empresa.getEndereco());
//        values.put(EmpresaContract.EmpresaEntry.COLUMN_PRODUTOS, empresa.getProdutos());

        long newRowId = db.insert(EmpresaContract.EmpresaEntry.TABLE_NAME, null, values);

        if (newRowId != -1) {
            Toast.makeText(this, "Empresa cadastrada com sucesso", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Erro ao cadastrar empresa", Toast.LENGTH_SHORT).show();
        }

        // Limpar os campos após o cadastro
        edtNomeEmpresa.setText("");
        edtCnpj.setText("");
        edtCep.setText("");
        edtCidade.setText("");
        edtLogradouro.setText("");
        edtBairro.setText("");
        edtNumero.setText("");
//        produtosList.clear();
    }
}
