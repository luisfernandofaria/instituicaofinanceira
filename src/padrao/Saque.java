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
public class Saque extends Operacao {

    @Override
    public double opcao(double limite, double saldo, double valor, String tipoMov) {
        tipoMov = "saque";
        if ((limite+saldo) - valor >= 0) {
            return saldo - valor;
        }
        return saldo;
    }
}
