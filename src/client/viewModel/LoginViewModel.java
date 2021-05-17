package client.viewModel;

import client.model.Model;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class LoginViewModel
{
  private StringProperty userNameProperty;
  private StringProperty passwordProperty;
  private StringProperty errorProperty;

  public LoginViewModel(Model model)
  {
    userNameProperty = new SimpleStringProperty("");

  }
  public void reset()
  {
  }
}
