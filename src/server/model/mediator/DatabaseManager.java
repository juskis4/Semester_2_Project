package server.model.mediator;

import javafx.beans.property.StringProperty;
import org.postgresql.core.SqlCommand;
import server.model.domain.User;

import java.sql.*;

public class DatabaseManager implements ParkingDatabase
{
  private Connection connection;

  public DatabaseManager()
  {
//    String driver = "org.postgresql.Driver";
//
//    String url = "jdbc:postgresql://localhost:5432/postgres?currentSchema=jdbc";
//
//    String user = "postgres";
//    String pw = "1234";
//
//    connection = null;
//
//    try {
//      Class.forName(driver);
//    }
//    catch (ClassNotFoundException e)
//    {
//      e.printStackTrace();
//    }
//
//    try {
//      connection = DriverManager.getConnection(url, user, pw);
//    }
//    catch (SQLException e)
//    {
//      e.printStackTrace();
//    }
  }

  public User addUserDB(String username, String password) throws SQLException {
    try(Connection connection = getConnection()) {
      PreparedStatement statement = connection.prepareStatement("INSERT INTO user_parking(username,password) VALUES(?,?);");
      statement.setString(1,username);
      statement.setString(2,password);
      statement.executeUpdate();
      return new User(username,password);
    }

  }


  private Connection getConnection() throws SQLException{

    return DriverManager.getConnection("jdbc:postgresql://10.10.27.65:5432/postgres?currentSchema=jdbc", "postgres","admin");
  }
//  public void createTables()
//  {
//    String sql = "CREATE SCHEMA IF NOT EXIST \"ParkingReservation\";";
//    try{
//      Statement statement = connection.createStatement();
//      statement.execute(sql);
//    }
//    catch (SQLException e)
//    {
//      e.printStackTrace();
//      throw new RuntimeException("Could not create Schema");
//    }
//
//    sql = "CREATE TABLE IF NOT EXISTS \"ParkingReservation\".ParkingLot ("
//        + "Number varchar(2) NOT NULL PRIMARY KEY,"
//        + "isReserved varchar(1) NOT NULL" + ");";
//
//    try {
//      Statement statement = connection.createStatement();
//      statement.execute(sql);
//    }
//    catch (SQLException e)
//    {
//      e.printStackTrace();
//    }
//
//  }

}
