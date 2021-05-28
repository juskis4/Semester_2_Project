package server.model.mediator;

import server.model.domain.Date;
import server.model.domain.Time;
import server.model.domain.User;
import server.model.domain.Vehicle;

import java.sql.SQLException;

public interface ParkingDatabase
{
  User addUserDB(String username,String password) throws SQLException;
  User getUserDB(String username, String password) throws SQLException;
  void addUserNamesDB(String firstName, String lastName, String username) throws SQLException;
  User getUserDB(String username) throws SQLException;
  void addCarDB(String username, String carBrand, String licenseNo, String color) throws SQLException;
  Vehicle getCarDB(String username) throws SQLException;
  void addLog(String username, Date date, Time time, String parkingSpace)
      throws SQLException;
}
