package br.ufrn.imd.controllers;

import java.sql.Connection;
import java.sql.DriverManager;

/**
* Classe respons�vel por fornecedor conex�o com o banco de dados para a
* aplica��o.
* 
* @author itamir.filho
*/
public class GerenciadorConexao {

    private static Connection conexao;

    /**
        * M�todo est�tico para obten��o de conex�o.
        * 
        * @return
        */
    public static Connection getConexao() {

        if (conexao == null) {
          String username = "root";
          String password = "max";
          // Informa a URL do banco (siturb) e o timezone do servidor
          String url = "jdbc:mysql://localhost/siturb?serverTimezone=UTC";
          try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                conexao = DriverManager.getConnection(url, username, password);
          } catch (Exception e) {
                e.printStackTrace();
          }
        }
    return conexao;
    }
}