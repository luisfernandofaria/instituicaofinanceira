/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import entidade.ContaCorrente;
import java.sql.SQLException;
import java.util.List;
import persistencia.PContaCorrente;

/**
 *
 * @author luisf
 */
public class NContaCorrente {

    private PContaCorrente persistencia;

    public NContaCorrente() {
        this.persistencia = new PContaCorrente();
    }

    public void salvar(ContaCorrente parametro) throws SQLException, Exception {

        for (ContaCorrente verificaNumero : persistencia.listar()) {
            if (parametro.getConta().getNumero().equals(verificaNumero.getConta().getId())) {
                throw new RuntimeException("Número de conta já utilizado! Gerar novamente!");
            }
        }

        if (parametro.getConta().getId() == 0) {
            persistencia.incluir(parametro);
        } else {
            persistencia.alterar(parametro);
        }
    }

    //CRIAR MÉTODO PARA ENCERRAR A CONTA, ISTO É, DESABILITÁ-LA, MAS NÃO EXCLUIR.
    public ContaCorrente consultar(int parametro) throws SQLException {
        return persistencia.consultar(parametro);
    }

    public ContaCorrente consultarPorNumero(String parametro) throws SQLException {
        return persistencia.consultarPorNumero(parametro);
    }

    public List<ContaCorrente> listar() throws SQLException {
        return persistencia.listar();
    }

}
