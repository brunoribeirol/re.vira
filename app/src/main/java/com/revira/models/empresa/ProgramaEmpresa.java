//package com.revira.models.empresa;
//
//import com.revira.models.Endereco;
//import com.revira.models.Produto;
//import java.util.ArrayList;
//import java.util.List;
//
//public class ProgramaEmpresa {
//    public static void main(String[] args) {
//        // Criando alguns produtos
//        Produto produto1 = new Produto("Produto 1", "Eletrônico");
//        Produto produto2 = new Produto("Produto 2", "Eletrônico");
//        List<Produto> produtos = new ArrayList<>();
//        produtos.add(produto1);
//        produtos.add(produto2);
//
//        // Criando endereço com parâmetros corretos
//        Endereco endereco = new Endereco("12345-678", "Cidade A", "Rua A", "Bairro C", 123);
//
//        // Criando empresas
//        Empresa empresa1 = new Empresa("Empresa 1", "00.000.000/0001-00", endereco, produtos);
//        Empresa empresa2 = new Empresa("Empresa 2", "00.000.000/0002-00", endereco, produtos);
//
//        // Criando instancia do DAO
//        EmpresaDAO empresaDAO = new EmpresaDAO();
//
//        // Testando inclusão
//        System.out.println("Incluindo Empresa 1: " + empresaDAO.incluir(empresa1)); // Deve retornar true
//        System.out.println("Incluindo Empresa 2: " + empresaDAO.incluir(empresa2)); // Deve retornar true
//        System.out.println("Incluindo Empresa 1 novamente: " + empresaDAO.incluir(empresa1)); // Deve retornar false
//
//        // Testando busca
//        System.out.println("Buscando Empresa 1: " + empresaDAO.buscar("00.000.000/0001-00").getNome()); // Deve retornar "Empresa 1"
//        System.out.println("Buscando Empresa Inexistente: " + empresaDAO.buscar("00.000.000/0003-00")); // Deve retornar null
//
//        // Testando alteração
//        Empresa empresaAlterada = new Empresa("Empresa 1 - Alterada", "00.000.000/0001-00", endereco, produtos);
//        System.out.println("Alterando Empresa 1: " + empresaDAO.alterar(empresaAlterada)); // Deve retornar true
//        System.out.println("Buscando Empresa 1 alterada: " + empresaDAO.buscar("00.000.000/0001-00").getNome()); // Deve retornar "Empresa 1 - Alterada"
//
//        // Testando exclusão
//        System.out.println("Excluindo Empresa 1: " + empresaDAO.excluir("00.000.000/0001-00")); // Deve retornar true
//        System.out.println("Excluindo Empresa 1 novamente: " + empresaDAO.excluir("00.000.000/0001-00")); // Deve retornar false
//
//        // Testando busca de todos
//        Empresa[] todasEmpresas = empresaDAO.buscarTodos();
//        System.out.println("Empresas restantes: ");
//        if (todasEmpresas != null) {
//            for (Empresa e : todasEmpresas) {
//                System.out.println(e.getNome());
//            }
//        } else {
//            System.out.println("Nenhuma empresa encontrada");
//        }
//    }
//}
