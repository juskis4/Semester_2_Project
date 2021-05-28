package client.viewModel;

import client.model.Model;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class SupportViewModel
{
  private StringProperty errorProperty;
  private Model model;

  public SupportViewModel(Model model)
  {
    this.model = model;
    errorProperty = new SimpleStringProperty("");
  }
  public void reset()
  {
    errorProperty.set("");
  }

  public Model getModel() {
    return model;
  }

  public StringProperty getErrorProperty()
  {
    return errorProperty;
  }
}
