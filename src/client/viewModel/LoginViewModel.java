package client.viewModel;

import client.model.Model;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * A class that represents the viewmodel for ChangeCar window and it is part of MVVM pattern.
 */
public class LoginViewModel
{
  private StringProperty userNameProperty;
  private StringProperty passwordProperty;
  private StringProperty errorProperty;
  private Model model;

  /**
   *  A constructor that sets the label text for every StringProperty variable.
   *  All StringProperties are initiated, but not fullfilled. The user has to complete them, to be able to log in.
   * @param model client model
   */
  public LoginViewModel(Model model)
  {
    this.model = model;
    userNameProperty = new SimpleStringProperty("");
    passwordProperty = new SimpleStringProperty("");
    errorProperty = new SimpleStringProperty("");
  }

  /**
   * Resets all text labels to null, remaining to be set by the user.
   */
  public void reset()
  {
    userNameProperty.set("");
    passwordProperty.set("");
    errorProperty.set("");
  }

  /**
   * It gets the model.
   * @return client model.
   */
  public Model getModel() {
    return model;
  }

  /**
   * It gets the customer's password.
   * @return password.
   */

  public StringProperty getPasswordProperty()
  {
    return passwordProperty;
  }

  /**
   * It gets the customer's username.
   * @return userName.
   */

  public StringProperty getUserNameProperty()
  {
    return userNameProperty;
  }

  /**
   * It gets the error, if any.
   * @return error.
   */

  public StringProperty getErrorProperty()
  {
    return errorProperty;
  }

  /**
   * It returns a boolean object, if username and password fields have passed the verification in database.
   * @return false or true statement.
   */
  public boolean login()
  {
    return model.login(userNameProperty.get(),passwordProperty.get());
  }
}
