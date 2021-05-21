package server.model.mediator;

import server.model.domain.*;

import java.sql.SQLException;

public class ModelManager implements Model
{
  private ParkingLot parkingLot;
  private DatabaseManager databaseManager;
  private Login login;
  private ParkingDatabase parkingDatabase;

  public ModelManager()
  {
    parkingLot = new ParkingLot();
    login = new Login();
    parkingDatabase = new DatabaseManager();
  }

  @Override public void registerSpace(String username, ParkingSpace parkingSpace, Time time, Date date)
  {
    // TO BE IMPLEMENTED WITH DATABASE
  }

  @Override
  public void reserveParkingSpace(ParkingSpace parkingSpace, User user) {
    for(int i = 0; i < parkingLot.size(); i++)
    {
      if(parkingLot.getParkingSpace(i).equals(parkingSpace) && !(parkingSpace.getIsOccupied()))
      {
        parkingLot.getParkingSpace(i).setOccupied(true, user);
      }
    }
  }

  @Override
  public void reserveParkingSpace(int index, User user)
  {
    if(!parkingLot.getParkingSpace(index).getIsOccupied())
    {
      parkingLot.getParkingSpace(index).setOccupied(true, user);
    }
  }

  @Override
  public void register(String userName, String password) throws SQLException {
    login.register(userName,password);
    parkingDatabase.addUserDB(userName,password);
  }

  @Override
  public boolean login(String userName, String password) throws SQLException
  {
    //System.out.println(parkingDatabase.getUserDB(userName,password));
    User dummy = new User(userName,password);
    if(parkingDatabase.getUserDB(userName, password).getUsername().equals(dummy.getUsername()) &&
        parkingDatabase.getUserDB(userName, password).getPassword().equals(dummy.getPassword()))
    {
      return true;
    }
    return false;
  }

  @Override
  public void registerFirstAndLastName(String firstName, String lastName, String username) {
    login.getUserList().getUserByUsername(username).setFirstname(firstName);
    login.getUserList().getUserByUsername(username).setLastname(lastName);
  }

  @Override
  public User getUserByUserName(String userName) {
    return login.getUserList().getUserByUsername(userName);
  }

  @Override public void registerVehicle(String username, String licenseNo, String color,
                                        String carBrand)
  {
    login.getUserList().getUserByUsername(username).registerVehicle(licenseNo, color, carBrand);
  }

  @Override
  public ParkingLot getParkingLot() {
    return parkingLot;
  }
}
