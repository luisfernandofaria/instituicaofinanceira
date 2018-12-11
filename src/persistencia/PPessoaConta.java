/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import entidade.PessoaConta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author luisf
 */
public class PPessoaConta {

    Connection cnn = util.Conexao.getConnection();

    public void incluir(PessoaConta pessoaConta) throws SQLException {
        cnn.setAutoCommit(false);
        try {

            String sql = "INSERT INTO pessoa_conta (id_pessoa, id_conta, senha_conta) "
                    + " VALUES (?,?,?)";
            PreparedStatement prd = cnn.prepareStatement(sql);

            prd.setInt(1, pessoaConta.getId_pessoa());
            prd.setInt(2, pessoaConta.getId_conta());
            prd.setString(3, pessoaConta.getSenha());

            prd.execute();
            cnn.commit();
            cnn.close();
        } catch (Exception e) {
            System.out.println("Dando rollback conta pessoa_conta");
            cnn.rollback();
            e.printStackTrace();
        }
    }

    public void alterar(PessoaConta pessoaConta) throws SQLException {

        try {
            String sql = "UPDATE pessoa_conta SET"
                    + " senha = ?, "
                    + " WHERE (id_pessoa, id_conta) = ?";

            PreparedStatement prd = cnn.prepareStatement(sql);
            prd.setString(1, pessoaConta.getSenha());

            prd.execute();
            cnn.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    public PessoaConta consultar(int id_pessoa, int id_conta, String senha) throws SQLException {

        String sql = "SELECT * FROM pessoa_conta WHERE id_pessoa=? AND id_conta=? AND senha_conta=? ";

        PreparedStatement prd = cnn.prepareStatement(sql);

        prd.setInt(1, id_pessoa);
        prd.setInt(2, id_conta);
        prd.setString(3, senha);

        ResultSet rs = prd.executeQuery();
        PessoaConta retorno = new PessoaConta();

        if (rs.next()) {
            retorno.setId_pessoa(rs.getInt("id_pessoa"));
            retorno.setId_conta(rs.getInt("id_conta"));
            retorno.setSenha(rs.getString("senha_conta"));
        }
        return retorno;
    }

    public PessoaConta consultar(int id_conta) throws SQLException {

        String sql = "SELECT id_pessoa, id_conta, senha_conta "
                + " FROM pessoa_conta WHERE id_conta=?";

        PreparedStatement prd = cnn.prepareStatement(sql);
        prd.setInt(1, id_conta);
        ResultSet rs = prd.executeQuery();
        PessoaConta retorno = new PessoaConta();

        if (rs.next()) {
            retorno.setId_pessoa(rs.getInt("id_pessoa"));
            retorno.setId_conta(rs.getInt("id_conta"));
            retorno.setSenha(rs.getString("senha_conta"));
        }
        return retorno;
    }
    
        public PessoaConta consultarPorIDPessoa(int id_pessoa) throws SQLException {

        String sql = "SELECT id_pessoa, id_conta, senha_conta "
                + " FROM pessoa_conta WHERE id_pessoa=?";

        PreparedStatement prd = cnn.prepareStatement(sql);
        prd.setInt(1, id_pessoa);
        ResultSet rs = prd.executeQuery();
        PessoaConta retorno = new PessoaConta();

        if (rs.next()) {
            retorno.setId_pessoa(rs.getInt("id_pessoa"));
            retorno.setId_conta(rs.getInt("id_conta"));
            retorno.setSenha(rs.getString("senha_conta"));
        }
        return retorno;
    }

    public List<PessoaConta> listar() throws SQLException {

        String sql = "SELECT * FROM pessoa_conta";
        Statement st = cnn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        List<PessoaConta> retorno = new ArrayList<>();

        while (rs.next()) {
            PessoaConta pessoaConta = new PessoaConta();

            pessoaConta.setId_pessoa(rs.getInt("id_pessoa"));
            pessoaConta.setId_conta(rs.getInt("id_conta"));
            pessoaConta.setSenha(rs.getString("senha_conta"));

            retorno.add(pessoaConta);
        }
        return retorno;
    }

}
