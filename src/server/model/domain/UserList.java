package server.model.domain;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * A class that represents user list.
 */
public class UserList implements Serializable
{
  private ArrayList<User> users;

  /**
   * A constructor for user list.
   */
  public UserList()
  {
    this.users = new ArrayList<>();
  }

  /**
   * A method that gets a user by its vehicle license number.
   * @param licenseNo users vehicle license number.
   * @return user.
   */
  public User getUserByLicenseNo(String licenseNo)
  {
    for(int i = 0; i < users.size(); i++)
    {
      if(users.get(i).getVehicle().getLicenseNo().equals(licenseNo))
      {
        return users.get(i);
      }
    }
    return null;
  }

  /**
   * A method, that adds user to user list.
   * @param username username of the user.
   */
  public void addUser(String username)
  {
    User user1 = new User(username);
    this.users.add(user1);
  }

  /**
   * A getter for user by username.
   * @param username users username.
   * @return user.
   */
  public User getUserByUsername(String username)
  {
    for(int i = 0;i < users.size(); i++)
    {
      if(users.get(i).getUsername().equals(username))
      {
        return users.get(i);
      }
    }
    return null;
  }
}
