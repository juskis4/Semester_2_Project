package server.model.mediator;

import javafx.beans.property.StringProperty;
import org.postgresql.core.SqlCommand;
import server.model.domain.User;
import server.model.domain.Vehicle;

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

  @Override public Vehicle getCarDB(String username) throws SQLException
  {
    try(Connection connection = getConnection())
    {
      PreparedStatement statement = connection.prepareStatement("SELECT * FROM car_info WHERE username = ?;");
      statement.setString(1, username);

      ResultSet resultSet = statement.executeQuery();
      String username1 = null;
      String licenseNo = null;
      String carBrand = null;
      String color = null;
      while(resultSet.next())
      {
        username1 = resultSet.getString("username");
        licenseNo = resultSet.getString("license_no");
        carBrand = resultSet.getString("car_brand");
        color = resultSet.getString("color");
      }
      if(licenseNo != null)
      {
        return new Vehicle(licenseNo, color, carBrand);
      }
      return null;
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

  public void addCarDB(String username, String licenseNo, String carBrand, String color) throws SQLException {
    try(Connection connection = getConnection()) {
      if(getCarDB(username) == null)
      {
        PreparedStatement statement = connection.prepareStatement(
            "INSERT INTO car_info (username, license_no, car_brand, color) VALUES (?,?,?,?)");
        statement.setString(1, username);
        statement.setString(2, licenseNo);
        statement.setString(3, carBrand);
        statement.setString(4, color);
        statement.executeUpdate();
      }

      else
      {
        PreparedStatement statement = connection.prepareStatement("UPDATE car_info SET (license_no, car_brand, color) = (?,?,?) WHERE username = ?;");
        statement.setString(4,username);
        if(licenseNo!=null)
        {
          statement.setString(1, licenseNo);
          statement.setString(2, color);
          statement.setString(3, carBrand);
        }
        statement.executeUpdate();
      }

//      ResultSet resultSet = statement.executeQuery();
//      String f_name = null;
//      String l_name = null;
//      while(resultSet.next())
//      {
//        f_name = resultSet.getString("f_name");
//        l_name = resultSet.getString("l_name");
//      }
//      System.out.println(f_name + " " + l_name);
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
      String firstName = null;
      String lastName = null;
      while(resultSet.next())
      {
        username1 = resultSet.getString("username");
        if(!(resultSet.getString("f_name")==null))
        {
          firstName = resultSet.getString("f_name");
          lastName = resultSet.getString("l_name");
        }
      }
      System.out.println(username1);
      if(username1 != null)
      {
        User user = new User(username1);
        if(firstName != null)
        {
          user.setFirstname(firstName);
          user.setLastname(lastName);
        }
        return user;
      }

      return null;
    }
  }
  private Connection getConnection() throws SQLException{

    return DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres?currentSchema=parking_lot", "postgres","1234");
  }

}
