package server.model.domain;

import java.util.HashMap;

public class Login
{
  private HashMap<String, String> usernameAndPassword;

  public Login()
  {
    this.usernameAndPassword = new HashMap<String, String>();
  }

  public HashMap<String, String> getUsernameAndPassword()
  {
    return usernameAndPassword;
  }

  public void register(String username, String password)
  {
    usernameAndPassword.put(username, password);
  }

}
