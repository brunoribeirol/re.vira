package com.revira.data;
import android.provider.BaseColumns;
public final class EmpresaContract {

    private EmpresaContract() {}

    public static class EmpresaEntry implements BaseColumns {
        public static final String TABLE_NAME = "empresa";
        public static final String COLUMN_NOME = "nome";
        public static final String COLUMN_CNPJ = "cnpj";
        public static final String COLUMN_ENDERECO = "endereco";
        public static final String COLUMN_PRODUTOS = "produtos";

        // Outras colunas necessárias

        // Query para criar a tabela
        public static final String SQL_CREATE_ENTRIES =
                "CREATE TABLE " + TABLE_NAME + " (" +
                        _ID + " INTEGER PRIMARY KEY," +
                        COLUMN_NOME + " TEXT," +
                        COLUMN_CNPJ + " TEXT," +
                        COLUMN_ENDERECO + " TEXT," +
                        COLUMN_PRODUTOS + "TEXT" +
                        // Definir outras colunas conforme necessário
                        ")";

        // Query para deletar a tabela
        public static final String SQL_DELETE_ENTRIES =
                "DROP TABLE IF EXISTS " + TABLE_NAME;
    }
}