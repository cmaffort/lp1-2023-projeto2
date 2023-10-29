/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.cefetmg.casaderepouso.DAO.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DAO {
    //metodos precisam ser estaticos para podermos usar em outras classes de forma eficiente :)//
    private static String driver="com.mysql.cj.jdbc.Driver";
    private static String url = "jdbc:mysql://127.0.0.1:3306/bdlardeidosos";
    private static String user = "root";
    private static String password = "admin";
    //conexão
    public static Connection conectar(){
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