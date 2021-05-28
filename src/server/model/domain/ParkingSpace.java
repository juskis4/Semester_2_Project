package server.model.domain;


import java.io.Serializable;

/**
 * A class that represents parking space.
 */
public class ParkingSpace implements Serializable
{
  private boolean isOccupied;
  private String nameOfParkingSpace;
  private String userName;
  private Time startingTime;
  private Time endingTime;
  private Date date;

  /**
   * A constructor with just parking space name.
   * @param nameOfParkingSpace the name of a parking space.
   */
  public ParkingSpace(String nameOfParkingSpace)
  {
    this.nameOfParkingSpace = nameOfParkingSpace;
    this.isOccupied = false;
    this.userName = "";
    this.startingTime = null;
    this.endingTime = null;
    this.date = null;
  }
  /**
   * A method that sets parking space to "not occupied".
   */
  public void setNotOccupied()
  {
    this.isOccupied = false;
    userName = "";
    startingTime = null;
    endingTime = null;
    date = null;
  }

  /**
   * A method that sets parking space to occupied by specific user.
   * @param userName name of user that occupies this parking space.
   * @param startingTime a time from when the parking space is going to occupied.
   * @param endingTime a time until when the parking space is going to be occupied.
   * @param date a date on which parking space will be occupied.
   */
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
  /**
   * A getter for parking space name.
   */
  public String getNameOfParkingSpace()
  {
    return nameOfParkingSpace;
  }

  /**
   * A getter for parking space occupation.
   * @return true if it is occupied, false if not.
   */
  public boolean getIsOccupied()
  {
    return isOccupied;
  }

  /**
   * A method that checks if obj is equal to parking space.
   * @param obj an object that will be compared with parking space.
   * @return true if parking space and object are equal, false if not.
   */
  public boolean equals(Object obj)
  {
    if(!(obj instanceof ParkingSpace))
      return false;
    ParkingSpace other = (ParkingSpace) obj;
    return isOccupied == other.isOccupied && nameOfParkingSpace.equals(other.nameOfParkingSpace);
  }

  /**
   * A getter for user.
   * @return user.
   */
  public String getUser()
  {
    return userName;
  }

  /**
   * A getter for date.
   * @return date.
   */
  public Date getDate() {
    return date;
  }

  /**
   * A getter for ending time.
   * @return ending time.
   */
  public Time getEndingTime() {
    return endingTime;
  }

  /**
   * A getter for starting time.
   * @return starting time.
   */
  public Time getStartingTime() {
    return startingTime;
  }

  /**
   * A method that puts parking space in a specific format.
   * @return string of parking space in a specific format.
   */
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
