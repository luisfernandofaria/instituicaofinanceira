/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package padrao;

import entidade.Pessoa;

/**
 *
 * @author luisf
 */
public class OrdenaPorNome extends Ordenar {
    

    @Override
    public boolean isPrimeiro(Pessoa p1, Pessoa p2) {
        if (p1.getNome().compareToIgnoreCase(p2.getNome()) > 0) {
            return true;
        }
        return false;
    }
}
