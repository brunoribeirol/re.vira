//package com.revira.models.empresa;
//package com.revira.models.Produto;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class ProgramaJava {
//    public static void main(String[] args) {
//        EmpresaDAO empresaDAO = new EmpresaDAO();
//
//        // Criar produtos válidos
//        List<Produto> produtosValidos1 = new ArrayList<>();
//        List<Produto> produtosValidos2 = new ArrayList<>();
//
//        // Criar produtos com base no construtor existente
//        Produto produto1 = new Produto("Produto 1", "Categoria 1", produtosValidos1);
//        Produto produto2 = new Produto("Produto 2", "Categoria 2", produtosValidos2);
//
//        // Adicionar produtos à lista
//        List<Produto> produtos = new ArrayList<>();
//        produtos.add(produto1);
//        produtos.add(produto2);
//
//        // Criar um endereço
//        Endereco endereco1 = new Endereco("Rua A", "Cidade B", "Estado C", "12345-678");
//
//        // Criação de uma nova empresa
//        Empresa empresa1 = new Empresa("12345678000195", "Minha Empresa", endereco1, produtos);
//
//        // Teste de inclusão
//        boolean incluido = empresaDAO.incluir(empresa1);
//        if (incluido) {
//            System.out.println("Empresa incluída com sucesso: " + empresa1.getNome());
//        } else {
//            System.out.println("Falha ao incluir a empresa: " + empresa1.getNome());
//        }
//
//        // Teste de busca
//        Empresa buscada = empresaDAO.buscar("12345678000195");
//        if (buscada != null) {
//            System.out.println("Empresa encontrada: " + buscada.getNome());
//            System.out.println("Endereço: " + buscada.getEndereco().getRua());
//            System.out.println("Produtos: ");
//            for (Produto produto : buscada.getProdutos()) {
//                System.out.println(" - " + produto.getNome() + " (" + produto.getCategoria() + ")");
//            }
//        } else {
//            System.out.println("Empresa não encontrada.");
//        }
//
//        // Teste de inclusão de uma empresa já existente
//        boolean incluido2 = empresaDAO.incluir(empresa1);
//        if (!incluido2) {
//            System.out.println("Empresa já existe: " + empresa1.getNome());
//        } else {
//            System.out.println("Inclusão duplicada permitida incorretamente.");
//        }
//
//        // Criação de uma nova empresa com CNPJ diferente
//        Endereco endereco2 = new Endereco("Rua X", "Cidade Y", "Estado Z", "98765-432");
//        List<Produto> produtos2 = new ArrayList<>();
//        Produto produto3 = new Produto("Produto 3", "Categoria 3", produtosValidos1);
//        Produto produto4 = new Produto("Produto 4", "Categoria 4", produtosValidos2);
//        produtos2.add(produto3);
//        produtos2.add(produto4);
//        Empresa empresa2 = new Empresa("98765432000198", "Outra Empresa", endereco2, produtos2);
//
//        // Teste de inclusão da nova empresa
//        boolean incluido3 = empresaDAO.incluir(empresa2);
//        if (incluido3) {
//            System.out.println("Nova empresa incluída com sucesso: " + empresa2.getNome());
//        } else {
//            System.out.println("Falha ao incluir a nova empresa: " + empresa2.getNome());
//        }
//
//        // Teste de busca da nova empresa
//        Empresa buscada2 = empresaDAO.buscar("98765432000198");
//        if (buscada2 != null) {
//            System.out.println("Nova empresa encontrada: " + buscada2.getNome());
//            System.out.println("Endereço: " + buscada2.getEndereco().getRua());
//            System.out.println("Produtos: ");
//            for (Produto produto : buscada2.getProdutos()) {
//                System.out.println(" - " + produto.getNome() + " (" + produto.getCategoria() + ")");
//            }
//        } else {
//            System.out.println("Nova empresa não encontrada.");
//        }
//    }
//}
