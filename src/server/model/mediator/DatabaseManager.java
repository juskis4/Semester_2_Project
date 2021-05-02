package server.model.mediator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseManager implements ParkingDatabase
{
  private Connection connection;

  public DatabaseManager()
  {
    String driver = "org.postgresql.Driver";

    String url = "jdbc:postgresql://localhost:5432/postgres";

    String user = "postgres";
    String pw = "1234";

    connection = null;

    try {
      Class.forName(driver);
    }
    catch (ClassNotFoundException e)
    {
      e.printStackTrace();
    }

    try {
      connection = DriverManager.getConnection(url, user, pw);
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
  }

  public void createTables()
  {
    String sql = "CREATE SCHEMA IF NOT EXIST \"ParkingReservation\";";
    try{
      Statement statement = connection.createStatement();
      statement.execute(sql);
    }
    catch (SQLException e)
    {
      e.printStackTrace();
      throw new RuntimeException("Could not create Schema");
    }

    sql = "CREATE TABLE IF NOT EXISTS \"ParkingReservation\".ParkingLot ("
        + "Number varchar(2) NOT NULL PRIMARY KEY,"
        + "isReserved varchar(1) NOT NULL" + ");";

    try {
      Statement statement = connection.createStatement();
      statement.execute(sql);
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    
  }

}
