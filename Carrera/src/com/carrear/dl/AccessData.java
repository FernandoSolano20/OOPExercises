package com.carrear.dl;

import com.sun.rowset.CachedRowSetImpl;

import java.sql.*;
import java.util.ArrayList;

public class AccessData {
    Connection connection = null;

    private Connection getConnection() throws SQLException {
        Connection conn;
        conn = ConnectionFactory.getInstance().getConnection();
        return conn;
    }

    public String insertData(String statement) throws Exception {
        try {
            connection = getConnection();
            Statement st = connection.createStatement();
            // note that i'm leaving "date_created" out of this insert statement
            st.executeUpdate(statement,Statement.RETURN_GENERATED_KEYS);
            connection.close();
            st.close();
            return "Guardado";
        }
        catch (Exception e)
        {
            throw new Exception("error en db");
        }
    }

    public ResultSet selectData(String statement) throws Exception {
        ResultSet resultSet = null;
        Statement st = null;
        CachedRowSetImpl crs = null;
        try {
            connection = getConnection();
            st = connection.createStatement();
            resultSet = st.executeQuery(statement);
            crs = new CachedRowSetImpl();
            crs.populate(resultSet);
        }
        catch (Exception e)
        {
            throw new Exception("error en db");
        }
        finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (st != null) {
                    st.close();
                }
                if (connection != null) {
                    connection.close();
                }
            }
            catch (Exception e){
                e.getMessage();
            }
        }
        return crs;
        ///^(?=.*[a-z])(?=.*[A-Z])(?=.*\W).{8,10}$/
    }
}
