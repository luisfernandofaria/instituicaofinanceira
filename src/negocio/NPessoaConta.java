/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import entidade.PessoaConta;
import java.sql.SQLException;
import java.util.List;
import persistencia.PPessoaConta;

/**
 *
 * @author luisf
 */
public class NPessoaConta {

    private PPessoaConta persistencia;

    public NPessoaConta() {
        this.persistencia = new PPessoaConta();
    }

    public void salvar(PessoaConta p1, PessoaConta p2) throws SQLException, Exception {

        for (PessoaConta verifica : persistencia.listar()) {
            if (p1.getId_pessoa() == verifica.getId_pessoa()) {
                throw new RuntimeException("Primeiro titular já possui conta!");
            } else if (p1.getId_pessoa() > 0 && p2.getId_pessoa() == verifica.getId_pessoa()) {
                throw new RuntimeException("Segundo titular já possui conta!");
            }
        }

        if (p1.getId_conta() == 0) {
            persistencia.incluir(p1);
        } else {
            persistencia.alterar(p1);
        }
    }

    public PessoaConta consultar(int parametro) throws SQLException {
        return persistencia.consultar(parametro);
    }

    public PessoaConta consultar(int id_pessoa, int id_conta, String senha) throws SQLException {
        return persistencia.consultar(id_pessoa, id_conta, senha);
    }

    public List<PessoaConta> listar() throws SQLException {
        return persistencia.listar();
    }
}
