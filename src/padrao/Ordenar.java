/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package padrao;

import entidade.Pessoa;
import java.util.List;

/**
 *
 * @author luisf
 */
public abstract class Ordenar {

    public abstract boolean isPrimeiro(Pessoa p1, Pessoa p2);

    public void ordenarLista(List<Pessoa> listaPessoas) {

        Pessoa aux;

        for (int i = listaPessoas.size() - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (!isPrimeiro(listaPessoas.get(i), listaPessoas.get(j))) {
                    aux = listaPessoas.get(j);
                    listaPessoas.set(j, listaPessoas.get(i));
                    listaPessoas.set(i, aux);
                }
            }
        }
    }
}
