/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apresentacao;

import entidade.Pessoa;
import javax.swing.JOptionPane;
import negocio.NPessoa;

/**
 *
 * @author luisf
 */
public class Login {
    
    private static Pessoa pessoa;

    public static boolean autenticar(String usuario, String senha) {

        try {
            
            NPessoa nPessoa = new NPessoa();
            pessoa = nPessoa.consultar(Integer.parseInt(usuario));

            if (usuario.equals(Integer.toString(pessoa.getId())) && senha.equals(pessoa.getSenha())) {
                return true;
            }

        } catch (Exception e) {
            e.getMessage();
        }
        return false;
    }
    
    public static Pessoa getPessoa () {
        return pessoa;
    }
}
