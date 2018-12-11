/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import entidade.ContaCorrente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author luisf
 */
public class PContaCorrente {

    private Connection cnn = util.Conexao.getConnection();

    public void incluir(ContaCorrente parametro) throws SQLException {

        cnn.setAutoCommit(false);
        try {
            String sql = "INSERT INTO conta (id_agencia, numero, tipo, limite,"
                    + " conta_conjunta, saldo, data_abertura) "
                    + " VALUES (?,?,?,?,?,?,now())";

            PreparedStatement prd = cnn.prepareStatement(sql);

            prd.setInt(1, parametro.getConta().getId_agencia());
            prd.setString(2, parametro.getConta().getNumero());
            prd.setInt(3, parametro.getConta().getTipo_conta());
            prd.setDouble(4, parametro.getLimite());
            prd.setInt(5, parametro.getConta().getConta_conjunta());
            prd.setDouble(6, parametro.getConta().getSaldo());

            prd.execute();

            cnn.commit();

        } catch (Exception e) {
            System.out.println("Dando rollback conta corrente");
            e.printStackTrace();
            cnn.rollback();
        }
//        cnn.close();
    }

    public void alterar(ContaCorrente parametro) throws SQLException {
        cnn.setAutoCommit(false);
        try {
            String sql = "UPDATE conta SET saldo = ? WHERE numero = ?";

            PreparedStatement prd = cnn.prepareStatement(sql);
            prd.setDouble(1, parametro.getConta().getSaldo());
            prd.setString(2, parametro.getConta().getNumero());

            prd.execute();
            cnn.commit();
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Dando rollback");
            cnn.rollback();
        }
    }

    public ContaCorrente consultar(int parametro) throws SQLException {

        String sql = "SELECT id, id_agencia, numero, data_abertura, conta_conjunta, saldo, limite "
                + " FROM conta WHERE id = ?";

        PreparedStatement prd = cnn.prepareStatement(sql);
        prd.setInt(1, parametro);
        ResultSet rs = prd.executeQuery();
        ContaCorrente retorno = new ContaCorrente();

        if (rs.next()) {
            retorno.getConta().setId(rs.getInt("id"));
            retorno.getConta().setId_agencia(rs.getInt("id_agencia"));
            retorno.getConta().setNumero(rs.getString("numero"));
            retorno.getConta().setData_abertura(rs.getDate("data_abertura"));
            retorno.getConta().setConta_conjunta(rs.getInt("conta_conjunta"));
            retorno.getConta().setSaldo(rs.getDouble("saldo"));
            retorno.setLimite(rs.getDouble("limite"));
        }
        return retorno;
    }

    public ContaCorrente consultarPorNumero(String parametro) throws SQLException {

        String sql = "SELECT id, id_agencia, numero, data_abertura, conta_conjunta, saldo, limite "
                + " FROM conta WHERE numero = ?";

        PreparedStatement prd = cnn.prepareStatement(sql);
        prd.setString(1, parametro);
        ResultSet rs = prd.executeQuery();
        ContaCorrente retorno = new ContaCorrente();

        if (rs.next()) {
            retorno.getConta().setId(rs.getInt("id"));
            retorno.getConta().setId_agencia(rs.getInt("id_agencia"));
            retorno.getConta().setNumero(rs.getString("numero"));
            retorno.getConta().setData_abertura(rs.getDate("data_abertura"));
            retorno.getConta().setConta_conjunta(rs.getInt("conta_conjunta"));
            retorno.getConta().setSaldo(rs.getDouble("saldo"));
            retorno.setLimite(rs.getDouble("limite"));
        }
        return retorno;
    }

    public List<ContaCorrente> listar() throws SQLException {

        String sql = "SELECT * FROM conta";
        Statement st = cnn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        List<ContaCorrente> retorno = new ArrayList<>();

        while (rs.next()) {
            ContaCorrente corrente = new ContaCorrente();

            corrente.getConta().setId(rs.getInt("id"));
            corrente.getConta().setTipo_conta(rs.getInt("tipo"));
            corrente.getConta().setId_agencia(rs.getInt("id_agencia"));
            corrente.getConta().setNumero(rs.getString("numero"));
            corrente.getConta().setData_abertura(rs.getDate("data_abertura"));
            corrente.getConta().setConta_conjunta(rs.getInt("conta_conjunta"));
            corrente.getConta().setSaldo(rs.getDouble("saldo"));
            corrente.setLimite(rs.getDouble("limite"));

            retorno.add(corrente);
        }
        return retorno;
    }

    public Iterator listaContas() throws SQLException {

        List<ContaCorrente> contasCorrente = listar();

        return contasCorrente.iterator();
    }

}
