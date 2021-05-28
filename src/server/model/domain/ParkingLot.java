package server.model.domain;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * A class that represents parking lot.
 */
public class ParkingLot implements Serializable
{
  private ArrayList<ParkingSpace> parkingSpaces;

  /**
   * A constructor for parking lot, that creates an array list pf parking spaces, give them names and adds it to array list.
   */
  public ParkingLot()
  {
    this.parkingSpaces = new ArrayList<>();
    //Adding all the parking spaces to the parking lot
    for(int i = 0; i < 6; i++)
    {
      ParkingSpace aRow = new ParkingSpace("A" + i);
      parkingSpaces.add(aRow);
      if(i<5)
      {
        ParkingSpace bRow = new ParkingSpace("B" + i);
        ParkingSpace cRow = new ParkingSpace("C" + i);
        parkingSpaces.add(bRow);
        parkingSpaces.add(cRow);
      }
      ParkingSpace dRow = new ParkingSpace("D" + i);
      parkingSpaces.add(dRow);
    }
  }

  /**
   * Getter for parking spaces array list
   * @return parking spaces array list.
   */
  public ArrayList<ParkingSpace> getParkingSpaces()
  {
    return parkingSpaces;
  }

  /**
   * A getter that gets parking space from array list by it's name.
   * @param name name of parking space.
   * @return parking space object.
   */
  public ParkingSpace getParkingSpaceByName(String name)
  {
    for(int i = 0; i<parkingSpaces.size(); i++)
    {
      if(parkingSpaces.get(i).getNameOfParkingSpace().equals(name))
      {
        return parkingSpaces.get(i);
      }
    }
    return null;
  }

  /**
   * Getter for parking spaces array list size.
   * @return size of parking spaces array list.
   */
  public int size()
  {
    return parkingSpaces.size();
  }

  /**
   * Getter for parking space, by an index.
   * @param index index of a parking space.
   * @return parking space object.
   */
  public ParkingSpace getParkingSpace(int index)
  {
    return parkingSpaces.get(index);
  }

  /**
   * A method that checks if the parking space is occupied.
   * @param parkingSpaceName parking space name, that will be checked.
   * @return true if parking space is occupied, false if not.
   */
  public boolean isOccupiedBySpaceName(String parkingSpaceName)
  {
    for(int i = 0; i< parkingSpaces.size(); i++)
    {
      if(parkingSpaces.get(i).getNameOfParkingSpace().equals(parkingSpaceName) && parkingSpaces.get(i).getIsOccupied())
      {
        return true;
      }
    }
    return false;
  }

  /**
   * A method that checks if parking space is occupied, by its index.
   * @param index index of a parking space.
   * @return true if parking space is occupied, false if not.
   */
  public boolean isOccupied(int index)
  {
    return parkingSpaces.get(index).getIsOccupied();
  }

  /**
   * Getter for all not occupied parking spaces.
   * @return array list of not occupied parking spaces.
   */
  public ArrayList<ParkingSpace> notOccupiedParkingSpaces()
  {
    ArrayList<ParkingSpace> notOccupied = new ArrayList<>();
    for(int i = 0; i<parkingSpaces.size(); i++)
    {
      if(!(parkingSpaces.get(i).getIsOccupied()))
      {
        notOccupied.add(parkingSpaces.get(i));
      }
    }
    return notOccupied;
  }

  /**
   * A method that checks if there's a parking space occupied by specific user.
   * @param userName Users username.
   * @return true if there is a parking space occupied by this user, false if not.
   */
  public boolean isOcuppiedByUser(String userName)
  {
      for (ParkingSpace parkingSpace : parkingSpaces) {
        if (parkingSpace.getUser().equals(userName)) {
          return true;
        }
      }
    return false;
  }

  /**
   * A method for getting a parking space that a user reserved.
   * @param user
   * @return parking space that is reserved by this user.
   */
  public ParkingSpace getParkingSpaceByUser(User user)
  {
    for(int i = 0; i< parkingSpaces.size(); i++)
    {
      if(parkingSpaces.get(i).getUser().equals(user))
      {
        return parkingSpaces.get(i);
      }
    }
    return null;
  }
}
