package server.model.domain;

import java.io.Serializable;

public class User implements Serializable
{
  private Vehicle vehicle;
  private String username;
  private UserRequest userRequest;

  private String firstname;
  private String lastname;
  private String password;

  public User(String username)
  {
    this.firstname = null;
    this.lastname = null;
    this.vehicle = null;
    this.userRequest = null;
    this.username = username;
    password = null;
  }

  public User(String username,String password)
  {
    this.firstname = null;
    this.lastname = null;
    this.vehicle = null;
    this.userRequest = null;
    this.username = username;
    this.password = password;
  }

  public void setFirstname(String firstname)
  {
    if(firstname == null)
    {
      firstname = "Not set.";
    }
    this.firstname = firstname;
  }

  public void setLastname(String lastname)
  {
    if(lastname == null)
    {
      lastname = "Not set.";
    }
    this.lastname = lastname;
  }

  public void registerVehicle(String licenseNo, String color, String carBrand)
  {
    this.vehicle = new Vehicle(licenseNo, color, carBrand);
  }

  public void registerUserRequest(String request)
  {
    this.userRequest = new UserRequest(request);
  }

  public String getUserRequest()
  {
    return userRequest.getRequest();
  }

  public Vehicle getVehicle()
  {
    return vehicle;
  }

  public String getFirstname()
  {
    return firstname;
  }

  public String getLastname()
  {
    return lastname;
  }

  public String getPassword()
  {
    return password;
  }

  public String getUsername()
  {
    return username;
  }
  @Override public String toString()
  {
    return "User{" + "vehicle=" + vehicle + ", firstname='"
        + firstname + '\'' + ", lastname='" + lastname + '\'' + '}';
  }
}
