/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.cefetmg.casaderepouso.DAO.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DAO {
    private String driver="com.mysql.cj.jdbc.Driver";
    String url = "jdbc:mysql://127.0.0.1:3306/bdlardeidosos";
    String user = "root";
    String password = "admin";
    //conexão
    private Connection conectar(){
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