package server.model.domain;

import java.io.Serializable;

public class ParkingSpace implements Serializable
{
  private boolean isOccupied;
  private String nameOfParkingSpace;
  private String userName;
  private Time startingTime;
  private Time endingTime;
  private Date date;
  

  public ParkingSpace(String nameOfParkingSpace)
  {
    this.nameOfParkingSpace = nameOfParkingSpace;
    this.isOccupied = false;
    this.userName = null;
    this.startingTime = null;
    this.endingTime = null;
    this.date = null;
  }

  public void setOccupied(boolean isOccupied, String userName, Time startingTime, Time endingTime, Date date)
  {
    this.isOccupied = isOccupied;
    this.userName = userName;
    this.startingTime = startingTime;
    this.endingTime = endingTime;
    this.date = date;
  }

  public String getNameOfParkingSpace()
  {
    return nameOfParkingSpace;
  }

  public boolean getIsOccupied()
  {
    return isOccupied;
  }

  public boolean equals(Object obj)
  {
    if(!(obj instanceof ParkingSpace))
      return false;
    ParkingSpace other = (ParkingSpace) obj;
    return isOccupied == other.isOccupied && nameOfParkingSpace.equals(other.nameOfParkingSpace);
  }

  public String getUser()
  {
    return userName;
  }



  @Override public String toString()
  {
    return "ParkingSpace{" + "isOccupied=" + isOccupied
        + ", nameOfParkingSpace='" + nameOfParkingSpace + '\'' + '}';
  }

  //TODO: After finishing the project, delete "boolean isOcuppied" for every class.
}
