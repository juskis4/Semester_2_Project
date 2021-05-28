package client.viewModel;

import client.model.Model;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * A class that represents a model for support view.
 */
public class SupportViewModel
{
  private StringProperty errorProperty;
  private Model model;

  /**
   * Constructor in which modek and error properties are initialized.
   * @param model
   */
  public SupportViewModel(Model model)
  {
    this.model = model;
    errorProperty = new SimpleStringProperty("");
  }

  /**
   * Resetting properties.
   */
  public void reset()
  {
    errorProperty.set("");
  }

  /**
   * Getter for model.
   * @return model.
   */
  public Model getModel() {
    return model;
  }

  /**
   * Getter for error property.
   * @return
   */
  public StringProperty getErrorProperty()
  {
    return errorProperty;
  }
}
