package server.model.mediator;

import server.model.domain.User;

import java.sql.SQLException;

public interface ParkingDatabase
{
  //void createTables();
  User addUserDB(String username,String password) throws SQLException;
  User getUserDB(String username, String password) throws SQLException;
  void addUserNamesDB(String firstName, String lastName, String username) throws SQLException;
  User getUserDB(String username) throws SQLException;
}
