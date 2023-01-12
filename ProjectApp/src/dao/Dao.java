package dao;

import java.sql.*;

public class Dao {
    protected String url;
    protected String username;
    protected String password;
    protected String sql;
    protected PreparedStatement preparedStatement;
    protected ResultSet result;
    protected Connection db;

    public Dao() {
        this.url = "jdbc:postgresql://web0.eecs.uottawa.ca:15432/group_b02_g44";
        this.username = "bwu006";
        // PLEASE DO NOT USE THIS PASSWORD FOR OTHER USES!!!!
        this.password = "Wbx123456.";
        connect();
    }

    public void connect() {
        try{
            Class.forName("org.postgresql.Driver");
            db = DriverManager.getConnection(url, username, password);
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (result != null) {
                result.close();
            }
            if (db != null) {
                db.close();
            }
        }catch (Exception e) {
            e.printStackTrace();
        }

    }
}
