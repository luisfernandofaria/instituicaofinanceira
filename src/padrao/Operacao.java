/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package padrao;

import entidade.ContaCorrente;
import entidade.Movimentacao;
import negocio.NContaCorrente;
import negocio.NMovimentacao;

/**
 *
 * @author luisf
 */
public abstract class Operacao {
    
    long millis = System.currentTimeMillis();
    java.sql.Date date = new java.sql.Date(millis);
    
    public abstract double opcao(double limite, double saldo, double valor, String tipoMov );
    
    public void executarOperacao(double limite, double saldo, double valor, String tipoMov, String numeroConta, int idPessoa, String senha) {
        
        try {
            Movimentacao movimentacao = new Movimentacao();
            NMovimentacao nMovimentacao = new NMovimentacao();
            ContaCorrente cc = new NContaCorrente().consultarPorNumero(numeroConta);
            NContaCorrente nContaCorrente = new NContaCorrente();
            int id_conta = cc.getConta().getId();
            
            double novoSaldo = opcao(limite, saldo, valor, tipoMov);
            
            cc.getConta().setSaldo(novoSaldo);
            nContaCorrente.salvar(cc);
            movimentacao.setTipo(tipoMov);
            movimentacao.setId_conta(id_conta);
            movimentacao.setId_pessoa(idPessoa);
            movimentacao.setValor(valor);
            movimentacao.setData(date);
            nMovimentacao.salvar(movimentacao);
            
        } catch (Exception e) {
            e.getMessage();
        }
    }
    
}
