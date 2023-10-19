package br.cefetmg.casaderepouso.DAO.connection;

import java.sql.SQLException;
import java.sql.Connection;

public class ConnectionManager {
    
    private static ConnectionManager cm;
    private static ConnectionFactory cf;

    private ConnectionManager(){
        ConnectionManager.cf = new MysqlConnection();
    }

    public static ConnectionManager getInstance(){
        if(cm == null)
            cm = new ConnectionManager();

        return cm;
    }

    public Connection getConnection() throws SQLException, ClassNotFoundException{
        return ConnectionManager.cf.getConnection();
    }

}