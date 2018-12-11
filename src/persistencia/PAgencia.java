/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import entidade.Agencia;
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
public class PAgencia {

    Connection cnn = util.Conexao.getConnection();

    public void incluir(Agencia parametro) throws SQLException {

        String sql = "INSERT INTO agencia (nome, telefone, logradouro, bairro, cidade, uf, cep) "
                + " VALUES (?,?,?,?,?,?,?)";
        PreparedStatement prd = cnn.prepareStatement(sql);

        prd.setString(1, parametro.getNumero());
        prd.setString(2, parametro.getTelefone());
        prd.setString(3, parametro.getLogradouro());
        prd.setString(4, parametro.getBairro());
        prd.setString(5, parametro.getCidade());
        prd.setString(6, parametro.getUf());
        prd.setString(7, parametro.getCep());

        prd.execute();
        cnn.close();
    }

    public void alterar(Agencia parametro) throws SQLException {

        try {
            String sql = "UPDATE agencia SET"
                    + " nome = ?,"
                    + " telefone = ?,"
                    + " logradouro = ?, "
                    + " bairro = ?, "
                    + " cidade = ?, "
                    + " uf = ?, "
                    + " cep  = ?, "
                    + " WHERE id = ?";

            PreparedStatement prd = cnn.prepareStatement(sql);

            prd.setString(1, parametro.getNumero());
            prd.setString(2, parametro.getTelefone());
            prd.setString(3, parametro.getLogradouro());
            prd.setString(4, parametro.getBairro());
            prd.setString(5, parametro.getCidade());
            prd.setString(6, parametro.getUf());
            prd.setString(7, parametro.getCep());

            prd.execute();
            cnn.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    public void excluir(int parametro) throws SQLException {
        //Cria a instrução sql para a inserção de registros
        String sql = "DELETE FROM agencia "
                + " WHERE id = ?";

        PreparedStatement prd = cnn.prepareStatement(sql);
        prd.setInt(1, parametro);

        prd.execute();
        cnn.close();
    }

    public Agencia consultar(int parametro) throws SQLException {

        String sql = "SELECT id, nome, telefone, logradouro, bairro, cidade, uf, cep"
                + " FROM agencia WHERE id = ?";

        PreparedStatement prd = cnn.prepareStatement(sql);
        prd.setInt(1, parametro);
        ResultSet rs = prd.executeQuery();
        Agencia retorno = new Agencia();

        if (rs.next()) {
            retorno.setId(rs.getInt("id"));
            retorno.setNumero(rs.getString("nome"));
            retorno.setTelefone(rs.getString("telefone"));
            retorno.setLogradouro(rs.getString("logradouro"));
            retorno.setBairro(rs.getString("bairro"));
            retorno.setCidade(rs.getString("cidade"));
            retorno.setUf(rs.getString("uf"));
            retorno.setCep(rs.getString("cep"));
        }
        return retorno;
    }

    public List<Agencia> listar() throws SQLException {

        String sql = "SELECT * FROM agencia";
        Statement st = cnn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        List<Agencia> retorno = new ArrayList<>();

        while (rs.next()) {
            Agencia agencia = new Agencia();

            agencia.setId(rs.getInt("id"));
            agencia.setNumero(rs.getString("nome"));
            agencia.setTelefone(rs.getString("telefone"));
            agencia.setLogradouro(rs.getString("logradouro"));
            agencia.setBairro(rs.getString("bairro"));
            agencia.setCidade(rs.getString("cidade"));
            agencia.setUf(rs.getString("uf"));
            agencia.setCep(rs.getString("cep"));

            retorno.add(agencia);
        }
        return retorno;
    }

}
