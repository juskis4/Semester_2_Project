package server.model.domain;

import java.util.HashMap;
import java.util.Map;

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

  public boolean loginValidation(String username, String password)
  {
    for (Map.Entry<String,String> entry : usernameAndPassword.entrySet())
    {
      if(username.equals(entry.getKey()) && password.equals(entry.getValue()))
      {
        return true;
      }
    }
    return false;
  }

}
