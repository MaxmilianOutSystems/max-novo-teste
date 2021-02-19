package br.ufrn.imd.dao; 

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.ufrn.imd.controllers.GerenciadorConexao;
import br.ufrn.imd.model.Cobrador;

/**
* Classe para manipula��o de informa��es de cobradores na base de dados.
* @author itamir.filho
*
*/
public class CobradorDao {

    /**
     * Lista todos os cobradores cadastrados.
     * @return
     */
    public List<Cobrador> buscarTodosCobradores() {
        List<Cobrador> resultado = new ArrayList<Cobrador>();
        Connection con = GerenciadorConexao.getConexao();
        String sql = "select * from cobrador";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Cobrador cobrador = new Cobrador();
                cobrador.setCpf(rs.getString("cpf"));
                cobrador.setEndereco(rs.getString("endereco"));
                cobrador.setMatricula(rs.getString("matricula"));
                cobrador.setNome(rs.getString("nome"));
                resultado.add(cobrador);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultado;
    }


    /**
     * M�todo para realizar a inser��o de um cobrador no BD.
     * @param cobrador
     */
    public void inserirCobrador(Cobrador cobrador) {
    	 System.out.print("Metodo inserir..."+cobrador.getNome());
        Connection con = GerenciadorConexao.getConexao();
        String sql = "insert into cobrador values (?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, cobrador.getNome());
            ps.setString(2, cobrador.getCpf());
            ps.setString(3, cobrador.getMatricula());
            ps.setString(4, cobrador.getEndereco());
           
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    
    public void tentarExcluir(Cobrador cobrador) {
    	
   	 System.out.print("Metodo Excluir..."+cobrador.getNome());
   	 String nome = cobrador.getNome();
     Connection con = GerenciadorConexao.getConexao();
     String sql = "delete from cobrador where nome="+"'"+nome+"'";
  
     try {
         PreparedStatement ps = con.prepareStatement(sql);
             
         ps.executeUpdate();
     } catch (SQLException e) {
         e.printStackTrace();
     }
    
    	
    }
    
}