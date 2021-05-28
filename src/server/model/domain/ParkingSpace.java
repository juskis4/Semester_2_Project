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
    this.userName = "";
    this.startingTime = null;
    this.endingTime = null;
    this.date = null;
  }

  public void setNotOccupied()
  {
    this.isOccupied = false;
    userName = "";
    startingTime = null;
    endingTime = null;
    date = null;
  }

  public void setOccupied(String userName, Time startingTime, Time endingTime, Date date)
  {
    this.isOccupied = true;
    this.userName = userName;
    if(userName == null)
    {
      throw new IllegalArgumentException("Username is null.");
    }
    if(startingTime == null)
    {
      throw new IllegalArgumentException("Starting time is null.");
    }
    this.startingTime = startingTime;
    if(endingTime == null)
    {
      throw new IllegalArgumentException("Ending time is null.");
    }
    this.endingTime = endingTime;
    if(date == null)
    {
      throw new IllegalArgumentException("Date is null.");
    }
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

  public Date getDate() {
    return date;
  }

  public Time getEndingTime() {
    return endingTime;
  }

  public Time getStartingTime() {
    return startingTime;
  }

  @Override public String toString()
  {
    String all = "Parking space: " + nameOfParkingSpace;
    if(isOccupied)
    {
      all+= ", is occupied from " + startingTime + " to " + endingTime + ", on " + date;
    }
    else {
      all+= ", is not occupied";
    }
    return all;
  }

  //TODO: After finishing the project, delete "boolean isOcuppied" for every class.
}
