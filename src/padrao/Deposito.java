/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package padrao;

/**
 *
 * @author luisf
 */
public class Deposito extends Operacao {

    @Override
    public double opcao(double limite, double saldo, double valor, String tipoMov ) {
        tipoMov = "deposito";
        return saldo+valor;
    }

}
