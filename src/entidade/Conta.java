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
public class Conta {

    private int id;
    private String numero;
    private int tipo_conta;
    private double saldo;
    private int conta_conjunta;
    private Date data_abertura;
    private int id_agencia;

    public Conta(int id, String numero, int tipo_conta, double saldo, int conta_conjunta, Date data_abertura, int id_agencia) {
        this.id = id;
        this.numero = numero;
        this.tipo_conta = tipo_conta;
        this.saldo = saldo;
        this.conta_conjunta = conta_conjunta;
        this.data_abertura = data_abertura;
        this.id_agencia = id_agencia;
    }

    public Conta() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public int getTipo_conta() {
        return tipo_conta;
    }

    public void setTipo_conta(int tipo_conta) {
        this.tipo_conta = tipo_conta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public int getConta_conjunta() {
        return conta_conjunta;
    }

    public void setConta_conjunta(int conta_conjunta) {
        this.conta_conjunta = conta_conjunta;
    }

    public Date getData_abertura() {
        return data_abertura;
    }

    public void setData_abertura(Date data_abertura) {
        this.data_abertura = data_abertura;
    }

    public int getId_agencia() {
        return id_agencia;
    }

    public void setId_agencia(int id_agencia) {
        this.id_agencia = id_agencia;
    }

}
