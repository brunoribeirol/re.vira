//package com.revira.models.empresa;
//
//import java.io.Serializable;
//import br.edu.cesarschool.next.oo.persistenciaobjetos.CadastroObjetos;
//
//public class EmpresaDAO
//{
//    private CadastroObjetos cadastro = new CadastroObjetos(Empresa.class);
//
//    private String obterIdUnico(Empresa empresa) {
//        return empresa.getCnpj();
//    }
//
//    public Empresa buscar(String cnpj) {
//        return (Empresa) cadastro.buscar(cnpj);
//    }
//
//    public boolean incluir(Empresa empresa) {
//        String idUnico = obterIdUnico(empresa);
//        Empresa empresa1 = buscar(idUnico);
//        if (empresa1 == null) {
//            cadastro.incluir(empresa, idUnico);
//            return true;
//        }
//        return false;
//    }
//
//    public boolean alterar(Empresa empresa) {
//        String idUnico = obterIdUnico(empresa);
//        Empresa empresa1 = buscar(idUnico);
//        if (empresa1 != null) {
//            cadastro.alterar(empresa, idUnico);
//            return true;
//        }
//        return false;
//    }
//
//    public boolean excluir(String cnpj) {
//        Empresa empresa1 = buscar(cnpj);
//        if (empresa1 != null) {
//            cadastro.excluir(cnpj);
//            return true;
//        }
//        return false;
//    }
//
//    public Empresa[] buscarTodos() {
//        Serializable[] res = cadastro.buscarTodos();
//        if (res == null) {
//            return null;
//        } else {
//            Empresa[] empresas = new Empresa[res.length];
//            int i = 0;
//            for (Serializable reg : res) {
//                empresas[i] = (Empresa) reg;
//                i++;
//            }
//            return empresas;
//        }
//    }
//}
