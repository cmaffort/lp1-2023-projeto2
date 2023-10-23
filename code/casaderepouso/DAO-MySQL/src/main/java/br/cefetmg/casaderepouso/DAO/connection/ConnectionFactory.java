package br.cefetmg.casaderepouso.DAO.connection;


import java.sql.Connection;
import java.sql.SQLException;

public interface ConnectionFactory {
    
    public Connection getConnection() throws SQLException, ClassNotFoundException;
    
    public boolean close() throws SQLException;
    
}