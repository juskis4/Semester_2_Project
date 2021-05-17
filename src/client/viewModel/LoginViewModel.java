package client.viewModel;

import client.model.Model;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class LoginViewModel
{
  private StringProperty userNameProperty;
  private StringProperty passwordProperty;
  private StringProperty errorProperty;
  private Model model;

  public LoginViewModel(Model model)
  {
    this.model = model;
    userNameProperty = new SimpleStringProperty("");
    passwordProperty = new SimpleStringProperty("");
    errorProperty = new SimpleStringProperty("");
  }
  public void reset()
  {
    userNameProperty.set("");
    passwordProperty.set("");
    errorProperty.set("");
  }

  public StringProperty getPasswordProperty()
  {
    return passwordProperty;
  }

  public StringProperty getUserNameProperty()
  {
    return userNameProperty;
  }

  public StringProperty getErrorProperty()
  {
    return errorProperty;
  }

  public boolean login()
  {
    return model.login(userNameProperty.get(),passwordProperty.get());
  }
}
