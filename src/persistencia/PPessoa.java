/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import entidade.Pessoa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author luisf
 */
public class PPessoa {

    private static Connection cnn = util.Conexao.getConnection();

    public void incluir(Pessoa parametro) throws SQLException {

        String sql = "INSERT INTO pessoa (nome, cpf, telefone, email, tipo_pessoa, senha, logradouro, bairro, cidade, uf, cep) "
                + " VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement prd = cnn.prepareStatement(sql);

        prd.setString(1, parametro.getNome());
        prd.setString(2, parametro.getCpf());
        prd.setString(3, parametro.getTelefone());
        prd.setString(4, parametro.getEmail());
        prd.setInt(5, parametro.getTipo_pessoa());
        prd.setString(6, parametro.getSenha());
        prd.setString(7, parametro.getLogradouro());
        prd.setString(8, parametro.getBairro());
        prd.setString(9, parametro.getCidade());
        prd.setString(10, parametro.getUf());
        prd.setString(11, parametro.getCep());

        prd.execute();
        cnn.close();
    }

    public void alterar(Pessoa parametro) throws SQLException {

        try {
            String sql = "UPDATE pessoa SET nome = ?, cpf = ?,telefone = ?, "
                    + " email = ?, senha = ?, logradouro = ?, bairro = ?, "
                    + " cidade = ?, uf = ?, cep  = ?, WHERE id = ?";

            PreparedStatement prd = cnn.prepareStatement(sql);

            prd.setString(1, parametro.getNome());
            prd.setString(2, parametro.getCpf());
            prd.setString(3, parametro.getTelefone());
            prd.setString(4, parametro.getEmail());
            prd.setString(5, parametro.getSenha());
            prd.setString(6, parametro.getLogradouro());
            prd.setString(7, parametro.getBairro());
            prd.setString(8, parametro.getCidade());
            prd.setString(9, parametro.getUf());
            prd.setString(10, parametro.getCep());

            prd.execute();
            cnn.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    public void excluir(int parametro) throws SQLException {
        //Cria a instrução sql para a inserção de registros
        String sql = "DELETE FROM pessoa "
                + " WHERE id = ?";

        PreparedStatement prd = cnn.prepareStatement(sql);
        prd.setInt(1, parametro);

        prd.execute();
        cnn.close();
    }

    public Pessoa consultar(int parametro) throws SQLException {

        String sql = "SELECT id, senha, nome, cpf, telefone, email, tipo_pessoa,"
                + " logradouro, bairro, cidade, uf, cep "
                + " FROM pessoa WHERE id = ?";

        PreparedStatement prd = cnn.prepareStatement(sql);
        prd.setInt(1, parametro);
        ResultSet rs = prd.executeQuery();
        Pessoa retorno = new Pessoa();

        if (rs.next()) {
            retorno.setId(rs.getInt("id"));
            retorno.setSenha(rs.getString("senha"));
            retorno.setNome(rs.getString("nome"));
            retorno.setCpf(rs.getString("cpf"));
            retorno.setTelefone(rs.getString("telefone"));
            retorno.setEmail(rs.getString("email"));
            retorno.setTipo_pessoa(rs.getInt("tipo_pessoa"));
            retorno.setLogradouro(rs.getString("logradouro"));
            retorno.setBairro(rs.getString("bairro"));
            retorno.setCidade(rs.getString("cidade"));
            retorno.setUf(rs.getString("uf"));
            retorno.setCep(rs.getString("cep"));
        }
        return retorno;
    }

    public Pessoa consultarPorCPF(String parametro) throws SQLException {

        String sql = "SELECT id, nome, cpf, telefone, email, tipo_pessoa,"
                + " logradouro, bairro, cidade, uf, cep "
                + " FROM pessoa WHERE cpf = ?";

        PreparedStatement prd = cnn.prepareStatement(sql);
        prd.setString(1, parametro);
        ResultSet rs = prd.executeQuery();
        Pessoa retorno = new Pessoa();

        if (rs.next()) {
            retorno.setId(rs.getInt("id"));
            retorno.setNome(rs.getString("nome"));
            retorno.setCpf(rs.getString("cpf"));
            retorno.setTelefone(rs.getString("telefone"));
            retorno.setEmail(rs.getString("email"));
            retorno.setTipo_pessoa(rs.getInt("tipo_pessoa"));
            retorno.setLogradouro(rs.getString("logradouro"));
            retorno.setBairro(rs.getString("bairro"));
            retorno.setCidade(rs.getString("cidade"));
            retorno.setUf(rs.getString("uf"));
            retorno.setCep(rs.getString("cep"));
        }
        return retorno;
    }

    public static List<Pessoa> listar() throws SQLException {

        String sql = "SELECT * FROM pessoa";
        Statement st = cnn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        List<Pessoa> retorno = new ArrayList<>();

        while (rs.next()) {
            Pessoa cliente = new Pessoa();

            cliente.setId(rs.getInt("id"));
            cliente.setNome(rs.getString("nome"));
            cliente.setCpf(rs.getString("cpf"));
            cliente.setTelefone(rs.getString("telefone"));
            cliente.setEmail(rs.getString("email"));
            cliente.setTipo_pessoa(rs.getInt("tipo_pessoa"));
            cliente.setLogradouro(rs.getString("logradouro"));
            cliente.setBairro(rs.getString("bairro"));
            cliente.setCidade(rs.getString("cidade"));
            cliente.setUf(rs.getString("uf"));
            cliente.setCep(rs.getString("cep"));

            retorno.add(cliente);
        }
        return retorno;
    }

    public Iterator listaPessoas() throws SQLException {

            List<Pessoa> pessoas = listar();

        return pessoas.iterator();
    }
}
