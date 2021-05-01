package server.model.domain;

public class User
{
  private Vehicle vehicle;
  private Login login;
  private UserRequest userRequest;

  private String firstname;
  private String lastname;

  public User(Login login)
  {
    this.firstname = null;
    this.lastname = null;
    this.vehicle = null;
    this.userRequest = null;
    this.login = login;
  }

  public void setFirstname(String firstname)
  {
    this.firstname = firstname;
  }

  public void setLastname(String lastname)
  {
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

  public Login getLogin()
  {
    return login;
  }

  //Takes a username and looks if the hashmap has it as a key, if it does then
  //it checks if the username's value(password) is correct and if it is
  //returns true
  public boolean isCorrectLogin(String username, String password)
  {
    if(login.getUsernameAndPassword().containsKey(username)
        && login.getUsernameAndPassword().get(username).equals(password))
    {
      return true;
    }
    return false;
  }

  @Override public String toString()
  {
    return "User{" + "vehicle=" + vehicle + ", login=" + login + ", firstname='"
        + firstname + '\'' + ", lastname='" + lastname + '\'' + '}';
  }
}
