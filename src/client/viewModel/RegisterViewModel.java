package client.viewModel;

import client.model.Model;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * A class that represents the register part where the current user is stored for the first time.
 */
public class RegisterViewModel
{
  private StringProperty userNameProperty;
  private StringProperty passwordProperty;
  private StringProperty errorProperty;
  private Model model;

  /**
   * A constructor that initializes model, username and password.
   * @param model client model
   */
  public RegisterViewModel(Model model)
  {
    this.model = model;
    userNameProperty = new SimpleStringProperty("");
    passwordProperty = new SimpleStringProperty("");
    errorProperty = new SimpleStringProperty("");
  }

  /**
   * A method that resets all information to be added.
   */

  public void reset()
  {
    userNameProperty.set("");
    passwordProperty.set("");
    errorProperty.set("");
  }

  /**
   * Gets the username.
   * @return
   */
  public StringProperty getUserNameProperty()
  {
    return userNameProperty;
  }

  /**
   * Gets the password.
   * @return
   */
  public StringProperty getPasswordProperty()
  {
    return passwordProperty;
  }

  /**
   * Gets the errorLabel.
   * @return
   */

  public StringProperty getErrorProperty()
  {
    return errorProperty;
  }

  /**
   * Registers the customer's username and password and stores.
   */

  public void register()
  {
    model.register(userNameProperty.get(), passwordProperty.get());
  }
}
