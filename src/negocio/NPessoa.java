/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import entidade.Pessoa;
import java.sql.SQLException;
import java.util.List;
import persistencia.PPessoa;
import util.ValidaCPF;

/**
 *
 * @author luisf
 */
public class NPessoa {

    PPessoa persistencia;

    public NPessoa() {
        this.persistencia = new PPessoa();
    }

    public void salvar(Pessoa parametro) throws SQLException, Exception {

        String cpf = parametro.getCpf();
        cpf = cpf.replace(".", "");
        cpf = cpf.replace("-", "");
        if (!ValidaCPF.isCPF(cpf) == true) {
            throw new Exception("CPF inválido! Digite novamente.");
        }

        if (parametro.getId() == 0) {
            persistencia.incluir(parametro);
        } else {
            persistencia.alterar(parametro);
        }

    }

    public void excluir(int parametro) throws SQLException {
        persistencia.excluir(parametro);
    }

    public Pessoa consultar(int parametro) throws SQLException {
        return persistencia.consultar(parametro);
    }

    public List<Pessoa> listar() throws SQLException {
        return persistencia.listar();
    }
}
