/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade;

import java.sql.Date;

/**
 *
 * @author luisf
 */
public class Movimentacao {

    private int id;
    private String tipo;
    private Date data;
    private double valor;
    private int id_conta;
    private int id_pessoa;

    public Movimentacao(int id, String tipo, Date data, double valor, int id_conta, int id_pessoa) {
        this.id = id;
        this.tipo = tipo;
        this.data = data;
        this.valor = valor;
        this.id_conta = id_conta;
        this.id_pessoa = id_pessoa;
    }

    public Movimentacao() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getId_conta() {
        return id_conta;
    }

    public void setId_conta(int id_conta) {
        this.id_conta = id_conta;
    }

    public int getId_pessoa() {
        return id_pessoa;
    }

    public void setId_pessoa(int id_pessoa) {
        this.id_pessoa = id_pessoa;
    }

}
