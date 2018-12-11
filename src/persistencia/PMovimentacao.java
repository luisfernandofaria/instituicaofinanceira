/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import entidade.Movimentacao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author luisf
 */
public class PMovimentacao {

    Connection cnn = util.Conexao.getConnection();

    public void incluir(Movimentacao parametro) throws SQLException {
        cnn.setAutoCommit(false);
        try {
            String sql1 = "INSERT INTO movimentacao (tipo, data, valor, id_conta, id_pessoa) "
                    + " VALUES (?,now(),?,?,?)";
            PreparedStatement prd = cnn.prepareStatement(sql1);

            prd.setString(1, parametro.getTipo());
            prd.setDouble(2, parametro.getValor());
            prd.setInt(3, parametro.getId_conta());
            prd.setInt(4, parametro.getId_pessoa());

            prd.execute();
            cnn.commit();
        } catch (Exception e) {
            System.out.println("Dando rollback movimentação");
            e.printStackTrace();
        }
        cnn.close();
    }

    public Movimentacao consultar(int parametro) throws SQLException {

        String sql = "SELECT id, tipo, data, valor, id_conta, id_pessoa"
                + " FROM movimentacao WHERE id = ?";

        PreparedStatement prd = cnn.prepareStatement(sql);
        prd.setInt(1, parametro);
        ResultSet rs = prd.executeQuery();
        Movimentacao retorno = new Movimentacao();

        if (rs.next()) {
            retorno.setId(rs.getInt("id"));
            retorno.setTipo(rs.getString("tipo"));
            retorno.setData(rs.getDate("data"));
            retorno.setValor(rs.getDouble("valor"));
            retorno.setId_conta(rs.getInt("id_conta"));
            retorno.setId_pessoa(rs.getInt("id_pessoa"));
        }
        return retorno;
    }

    public List<Movimentacao> listar() throws SQLException {

        String sql = "SELECT * FROM movimentacao";
        Statement st = cnn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        List<Movimentacao> retorno = new ArrayList<>();

        while (rs.next()) {
            Movimentacao movimentacao = new Movimentacao();

            movimentacao.setTipo(rs.getString("tipo"));
            movimentacao.setData(rs.getDate("data"));
            movimentacao.setValor(rs.getDouble("valor"));
            movimentacao.setId_conta(rs.getInt("id_conta"));
            movimentacao.setId_pessoa(rs.getInt("id_pessoa"));

            retorno.add(movimentacao);
        }
        return retorno;
    }

}
