package server.model.mediator;

import server.model.domain.*;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * A class that represents server model manager.
 */
public class ModelManager implements Model
{
  private ParkingLot parkingLot;
  private DatabaseManager databaseManager;
  private Login login;
  private ParkingDatabase parkingDatabase;

  /**
   * A constructor of modelmanager.
   */
  public ModelManager()
  {
    parkingLot = new ParkingLot();
    login = new Login();
    parkingDatabase = new DatabaseManager();
  }

  /**
   * A method that registers parking space.
   * @param userName users username.
   * @param parkingSpace parking space.
   * @param startingTime time when parking space was reserved.
   * @param endingTime time when reservation ends.
   * @param date date on which parking space was reserved.
   */
  @Override public void registerSpace(String userName, ParkingSpace parkingSpace, Time startingTime, Time endingTime, Date date)
  {
    for(int i = 0; i < parkingLot.size(); i++)
    {
      if(parkingLot.getParkingSpace(i).equals(parkingSpace) && !(parkingSpace.getIsOccupied()))
      {
        parkingLot.getParkingSpace(i).setOccupied(userName,startingTime,endingTime,date);
      }
    }
  }

  /**
   * A method that register user.
   * @param userName users username.
   * @param password users password.
   * @throws SQLException throwing sql exception.
   */
  @Override
  public void register(String userName, String password) throws SQLException {
    login.register(userName,password);
    parkingDatabase.addUserDB(userName,password);
  }

  /**
   * A method that logs user into system.
   * @param userName users username.
   * @param password users password.
   * @return true if user is validate, falseif not.
   * @throws SQLException throwing sql exception.
   */
  @Override
  public boolean login(String userName, String password) throws SQLException
  {
    //System.out.println(parkingDatabase.getUserDB(userName,password));
    User dummy = new User(userName,password);
    System.out.println(parkingDatabase.getUserDB(userName, password).getPassword());
    if(parkingDatabase.getUserDB(userName, password).getUsername().equals(dummy.getUsername()) &&
        parkingDatabase.getUserDB(userName, password).getPassword().equals(dummy.getPassword()))
    {
      return true;
    }
    return false;
  }

  /**
   * A method that registers users first and last names.
   * @param firstName users first name.
   * @param lastName users last name.
   * @param username users username.
   * @throws SQLException throwing sql exception.
   */
  @Override
  public void registerFirstAndLastName(String firstName, String lastName, String username)
      throws SQLException
  {
    parkingDatabase.addUserNamesDB(firstName, lastName, username);
  }

  /**
   * A getter for user by username.
   * @param userName users username.
   * @return user.
   * @throws SQLException throwing sql exception.
   */
  @Override
  public User getUserByUserName(String userName) throws SQLException
  {
    return parkingDatabase.getUserDB(userName);
  }

  /**
   * A method that registers users vehicle.
   * @param username users username.
   * @param licenseNo users vehicle license number.
   * @param color users vehicle color.
   * @param carBrand users vehicle brand.
   */
  @Override public void registerVehicle(String username, String licenseNo, String color,
                                        String carBrand)
  {
    try
    {
      parkingDatabase.addCarDB(username, licenseNo, carBrand, color);
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
  }

  /**
   * A getter parking lot
   * @return parking lot
   */
  @Override
  public ParkingLot getParkingLot() {
    return parkingLot;
  }

  /**
   * A method to add logs to the database.
   * @param username users username.
   * @param parkingSpace parking space name.
   * @throws SQLException throwing sql exception.
   */
  @Override public void addLog(String username, String parkingSpace) throws SQLException
  {
    LocalDate localDate = LocalDate.now();
    Date date = new Date(localDate.getDayOfMonth(), localDate.getMonthValue(), localDate.getYear());
    LocalTime localTime = LocalTime.now();
    Time currentTime = new Time(localTime.getHour(),localTime.getMinute());
    System.out.println(date.toString());
    parkingDatabase.addLog(username, date, currentTime, parkingSpace);
  }
}
