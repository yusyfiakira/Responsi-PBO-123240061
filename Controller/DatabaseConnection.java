package Controller;

import com.sun.jdi.connect.spi.Connection;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/employe.db";
    private static final String USER = "root";
    private static final String PASS = "";
    private static Connection connection = null;

    private static Connection isClosed() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
  
private DatabaseConnection(){}

    public static Connection getconnection() throws SQLException {
        if (connection == null || connection/isClosed()){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException e){
            throw new SQLException("Driver tidak valid!", e);
        }
    } return connection;
}
public static void closeConnection(){
    try {if (connection!=null) connection.close();} catch(SQLException e){}
}
}

