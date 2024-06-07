//package com.revira.ui;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.AdapterView;
//import android.widget.ListView;
//import androidx.appcompat.app.AppCompatActivity;
//
//import com.revira.models.empresa.Empresa;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class VisualizarEmpresasActivity extends AppCompatActivity
//{
//    private ListView lvEmpresas;
//    private EmpresaAdapter adapter;
//    private List<Empresa> empresas;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_view_return_points);
//
//        lvEmpresas = findViewById(R.id.lvEmpresas);
//        empresas = new ArrayList<>();
//
//        // Adicionar dados de exemplo
//        empresas.add(new Empresa("Empresa A", "Segmento 1", "Produto 1, Produto 2", 4.5, 2.3));
//        empresas.add(new Empresa("Empresa B", "Segmento 2", "Produto 3, Produto 4", 3.8, 1.5));
//        empresas.add(new Empresa("Empresa C", "Segmento 3", "Produto 5, Produto 6", 4.9, 3.7));
//        empresas.add(new Empresa("Empresa D", "Segmento 4", "Produto 7, Produto 8", 4.2, 4.1));
//        empresas.add(new Empresa("Empresa E", "Segmento 5", "Produto 9, Produto 10", 3.9, 2.9));
//
//        adapter = new EmpresaAdapter(this, empresas);
//        lvEmpresas.setAdapter(adapter);
//
//        lvEmpresas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Empresa empresa = empresas.get(position);
//                Intent intent = new Intent(ViewReturnPointsActivity.this, EmpresaDetalhesActivity.class);
//                intent.putExtra("nome", empresa.getNome());
//                intent.putExtra("segmento", empresa.getSegmento());
//                intent.putExtra("produtos", empresa.getProdutos());
//                intent.putExtra("pontuacao", empresa.getPontuacao());
//                intent.putExtra("distancia", empresa.getDistancia());
//                startActivity(intent);
//            }
//        });
//    }
//}
//
