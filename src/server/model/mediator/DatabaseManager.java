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

  @Override public User getUserDB(String username, String password) throws SQLException
  {
    try(Connection connection = getConnection())
    {
      PreparedStatement statement = connection.prepareStatement("SELECT * FROM user_parking WHERE username = ? AND password = ?;");
      statement.setString(1, username);
      statement.setString(2, password);

      ResultSet resultSet = statement.executeQuery();
      String password1 = null;
      String username1 = null;
      while(resultSet.next())
      {
        username1 = resultSet.getString("username");
        password1 = resultSet.getString("password");
      }
      System.out.println(username1 + " " + password1);
      return new User(username1, password1);
    }
  }

  public void addUserNamesDB(String firstName, String lastName, String username) throws SQLException {
    try(Connection connection = getConnection()) {
      PreparedStatement statement = connection.prepareStatement("UPDATE user_parking SET (f_name, l_name) = (?,?) WHERE username = ?;");
      statement.setString(3,username);
      statement.setString(1,firstName);
      statement.setString(2,lastName);
      statement.executeUpdate();


      ResultSet resultSet = statement.executeQuery();
      String f_name = null;
      String l_name = null;
      while(resultSet.next())
      {
        f_name = resultSet.getString("f_name");
        l_name = resultSet.getString("l_name");
      }
      System.out.println(f_name + " " + l_name);
    }
  }

  @Override public User getUserDB(String username) throws SQLException
  {
    try(Connection connection = getConnection())
    {
      PreparedStatement statement = connection.prepareStatement("SELECT * FROM user_parking WHERE username = ?;");
      statement.setString(1, username);

      ResultSet resultSet = statement.executeQuery();
      String username1 = null;
      while(resultSet.next())
      {
        username1 = resultSet.getString("username");
      }
      System.out.println(username1);
      if(username1 != null)
      {
        return new User(username1);
      }

      return null;
    }
  }
  private Connection getConnection() throws SQLException{

    return DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres?currentSchema=parking_lot", "postgres","1234");
  }

}
