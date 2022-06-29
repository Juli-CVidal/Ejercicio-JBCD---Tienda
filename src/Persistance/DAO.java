/*
// Curso Egg FullStack
 */
package Persistance;

// @author JulianCVidal
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class DAO {

    protected Connection connection = null;
    protected ResultSet result = null;
    protected Statement sentence = null;

    private final String USER = "root";
    private final String PASSWORD = "root";
    private final String DATABASE = "tienda";
    private final String DRIVER = "com.mysql.jdbc.Driver";

    protected void connectToBase() throws Exception {
        try {
            Class.forName(DRIVER);
            String dataBaseURL = "jdbc:mysql://localhost:3306/" + DATABASE + "?useSSL=false";
            connection = DriverManager.getConnection(dataBaseURL, USER, PASSWORD);

        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        }
    }

    protected void disconnectToBase() throws SQLException {
        try {
            if (result != null) {
                result.close();
            }
            if (sentence != null) {
                sentence.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            throw e;
        }
    }

    protected void instertModifyOrDelete(String query) throws Exception {
        try {
            connectToBase();
            sentence = connection.createStatement();
            sentence.executeUpdate(query);
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        } finally {
            disconnectToBase();
        }
    }

    protected void consultInBase(String query) throws Exception {
        try {
            connectToBase();
            sentence = connection.createStatement();
            result = sentence.executeQuery(query);
        } catch (ClassNotFoundException | SQLException ex) {
            throw ex;
        }
    }

    protected void sendModifierQuery(String query) throws Exception {
        try {
            instertModifyOrDelete(query);
        } catch (Exception e) {
            throw e;
        }
    }
}
