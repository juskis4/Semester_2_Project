package server.model.domain;

import java.util.HashMap;
import java.util.Map;

/**
 * A class that represents login in this system.
 */
public class Login
{
  private HashMap<String, String> usernameAndPassword;
  private UserList userList;

  /**
   * A constructor for login, that creates a new hashmap and userlist.
   */
  public Login()
  {
    this.usernameAndPassword = new HashMap<String, String>();
    this.userList = new UserList();

  }

  /**
   * A getter for username and password.
   * @return username and password.
   */
  public HashMap<String, String> getUsernameAndPassword()
  {
    return usernameAndPassword;
  }

  /**
   * A method that adds username and password to hashmap and adds username to userlist.
   * @param username string of username.
   * @param password string of password.
   */
  public void register(String username, String password)
  {
    usernameAndPassword.put(username, password);
    userList.addUser(username);

  }

  //Takes a username and looks if the hashmap has it as a key, if it does then
  //it checks if the username's value(password) is correct and if it is
  //returns true

  /**
   * A method that takes username and looks if the hashmap has it as a key, if it does then it checks if the username's value(password) is correct
   * and if it is returns true.
   * @param username string of username.
   * @param password string of password.
   * @return true if hashmap contains username and password false, if otherwise.
   */
  public boolean isCorrectLogin(String username, String password)
  {
    if(usernameAndPassword.containsKey(username)
        && getUsernameAndPassword().get(username).equals(password))
    {
      return true;
    }
    return false;
  }

  /**
   * Getter for user list.
   * @return user list
   */
  public UserList getUserList() {
    return userList;
  }


}
