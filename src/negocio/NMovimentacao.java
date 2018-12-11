/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import entidade.Movimentacao;
import java.sql.SQLException;
import java.util.List;
import persistencia.PMovimentacao;

/**
 *
 * @author luisf
 */
public class NMovimentacao {

    PMovimentacao persistencia;

    public NMovimentacao() {
        this.persistencia = new PMovimentacao();
    }

    public void salvar(Movimentacao parametro) throws SQLException, Exception {

        if (parametro.getData() == null) {
            throw new Exception("Ë necessário informar o nome!");
        }
        if (parametro.getTipo().isEmpty()) {
            throw new Exception("É necessário informar se é saque ou depósito!");
        }
        if (parametro.getValor() <= 0) {
            throw new Exception("Valor inválido. Verifique e tente novamente!");
        }
        if (parametro.getId_conta() < 0) {
            throw new Exception("Conta inexistente.");
        }
        if (parametro.getId_pessoa() < 0) {
            throw new Exception("Cliente inexistente.");
        }
        persistencia.incluir(parametro);
    }

    public Movimentacao consultar(int parametro) throws SQLException {
        return persistencia.consultar(parametro);
    }

    public List<Movimentacao> listar() throws SQLException {
        return persistencia.listar();
    }
}
