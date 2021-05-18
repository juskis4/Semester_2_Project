package server.model.domain;

import java.util.HashMap;
import java.util.Map;

public class Login
{
  private HashMap<String, String> usernameAndPassword;
  private UserList userList;
  private String userName;

  public Login()
  {
    this.usernameAndPassword = new HashMap<String, String>();
    this.userList = new UserList();
    userName = null;
  }

  public HashMap<String, String> getUsernameAndPassword()
  {
    return usernameAndPassword;
  }

  public void register(String username, String password)
  {
    usernameAndPassword.put(username, password);
    userList.addUser(username);
    this.userName = username;
  }

  //Takes a username and looks if the hashmap has it as a key, if it does then
  //it checks if the username's value(password) is correct and if it is
  //returns true
  public boolean isCorrectLogin(String username, String password)
  {
    if(usernameAndPassword.containsKey(username)
        && getUsernameAndPassword().get(username).equals(password))
    {
      return true;
    }
    return false;
  }

  public UserList getUserList() {
    return userList;
  }

  public String getUserName() {
    return userName;
  }
}
