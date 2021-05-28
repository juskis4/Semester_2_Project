package server.model.domain;

import java.io.Serializable;

/**
 * A class that represents user.
 */
public class User implements Serializable
{
  private Vehicle vehicle;
  private String username;
  private UserRequest userRequest;

  private String firstname;
  private String lastname;
  private String password;
  /**
   * A constructor with only username, that sets other instance variables to null.
   */
  public User(String username)
  {
    this.firstname = null;
    this.lastname = null;
    this.vehicle = null;
    this.userRequest = null;
    this.username = username;
    password = null;
  }

  /**
   * A constructor with only username and password, that sets other instance variables to null.
   * @param username
   * @param password
   */
  public User(String username,String password)
  {
    this.firstname = null;
    this.lastname = null;
    this.vehicle = null;
    this.userRequest = null;
    this.username = username;
    this.password = password;
  }

  /**
   * Setter for first name.
   * @param firstname first name of the user.
   */
  public void setFirstname(String firstname)
  {
    if(firstname == null)
    {
      firstname = "Not set.";
    }
    this.firstname = firstname;
  }

  /**
   * Setter for last name.
   * @param lastname last name of the user.
   */
  public void setLastname(String lastname)
  {
    if(lastname == null)
    {
      lastname = "Not set.";
    }
    this.lastname = lastname;
  }

  /**
   * A method that creates a new vehicle.
   * @param licenseNo license number of the vehicle.
   * @param color color of the vehicle.
   * @param carBrand car brand of the vehicle.
   */
  public void registerVehicle(String licenseNo, String color, String carBrand)
  {
    this.vehicle = new Vehicle(licenseNo, color, carBrand);
  }

  /**
   * A method that registers user request.
   * @param request request of the user.
   */
  public void registerUserRequest(String request)
  {
    this.userRequest = new UserRequest(request);
  }

  /**
   * A getter for user request.
   * @return user request.
   */
  public String getUserRequest()
  {
    return userRequest.getRequest();
  }

  /**
   * Getter for vehicle.
   * @return vehicle.
   */
  public Vehicle getVehicle()
  {
    return vehicle;
  }

  /**
   * A getter for first name.
   * @return first name.
   */
  public String getFirstname()
  {
    return firstname;
  }

  /**
   * A getter for last name.
   * @return last name.
   */
  public String getLastname()
  {
    return lastname;
  }

  /**
   * A getter for password.
   * @return password.
   */
  public String getPassword()
  {
    return password;
  }

  /**
   * A getter for username.
   * @return username.
   */
  public String getUsername()
  {
    return username;
  }

  /**
   * A method that puts user into specific format.
   * @return a string with user in a specific format.
   */
  @Override public String toString()
  {
    return "User{" + "vehicle=" + vehicle + ", firstname='"
        + firstname + '\'' + ", lastname='" + lastname + '\'' + '}';
  }
}
