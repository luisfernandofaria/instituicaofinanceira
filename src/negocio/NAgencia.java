/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import entidade.Agencia;
import java.sql.SQLException;
import java.util.List;
import persistencia.PAgencia;

/**
 *
 * @author luisf
 */
public class NAgencia {

    PAgencia persistencia;

    public NAgencia() {
        this.persistencia = new PAgencia();
    }

    public void salvar(Agencia parametro) throws SQLException, Exception {

        if (parametro.getNumero().isEmpty()) {
            throw new Exception("Ë necessário informar o nome da Agência!");
        }
        if (parametro.getTelefone().isEmpty()) {
            throw new Exception("É necessário informar o telefone da Agência!");
        }
        if (parametro.getLogradouro().isEmpty()) {
            throw new Exception("É necessário informar o endereço.");
        }
        if (parametro.getBairro().isEmpty()) {
            throw new Exception("É necessário informar o endereço.");
        }
        if (parametro.getCidade().isEmpty()) {
            throw new Exception("É necessário informar o endereço.");
        }
        if (parametro.getUf().isEmpty()) {
            throw new Exception("É necessário informar o endereço.");
        }
        if (parametro.getCep().isEmpty()) {
            throw new Exception("É necessário informar o endereço.");
        }
        persistencia.incluir(parametro);
    }

    public void excluir(int parametro) throws SQLException {
        persistencia.excluir(parametro);
    }

    public Agencia consultar(int parametro) throws SQLException {
        return persistencia.consultar(parametro);
    }

    public List<Agencia> listar() throws SQLException {
        return persistencia.listar();
    }

}
