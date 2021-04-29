package server.model.domain;

import java.util.ArrayList;

public class UserList
{
  private ArrayList<User> users;

  public UserList()
  {
    this.users = new ArrayList<>();
  }

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
}
