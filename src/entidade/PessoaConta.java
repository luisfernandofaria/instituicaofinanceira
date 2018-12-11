/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade;

/**
 *
 * @author luisf
 */
public class PessoaConta {

    private int id_pessoa;
    private int id_conta;
    private String senha;

    public PessoaConta(int id_pessoa, int id_conta, String senha) {
        this.id_pessoa = id_pessoa;
        this.id_conta = id_conta;
        this.senha = senha;
    }

    public PessoaConta() {

    }

    public int getId_pessoa() {
        return id_pessoa;
    }

    public void setId_pessoa(int id_pessoa) {
        this.id_pessoa = id_pessoa;
    }

    public int getId_conta() {
        return id_conta;
    }

    public void setId_conta(int id_conta) {
        this.id_conta = id_conta;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
