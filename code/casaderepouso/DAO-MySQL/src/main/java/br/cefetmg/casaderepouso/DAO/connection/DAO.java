/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.cefetmg.casaderepouso.DAO.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAO {
    private static String driver="com.mysql.cj.jdbc.Driver";
    private static String url = "jdbc:mysql://127.0.0.1:3306/bdlardeidosos";
    private static String user = "root";
    private static String password = "admin";
    //conexão
    public static Connection conectar() throws ClassNotFoundException, SQLException{
        Connection con = null;
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, password);
            return con;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
    //fecha a conexão
    public static void fecharConexao(Connection conexao, Statement comando) throws SQLException{
        if(comando != null)
            comando.close();
        
        if(conexao != null)
            conexao.close();
    }
    
    public static void fecharConexao(Connection conexao, Statement comando, ResultSet rs) throws SQLException {
        fecharConexao(conexao, comando);
        
        if(rs != null)
            rs.close();
    }
    
    //public void testeConexao(){
    //    try {
    //        Connection con = conectar();
    //        System.out.println(con);
    //        con.close();
    //    } catch (Exception e) {
    //        System.out.println(e);
    //    }
    //}
}