package client.viewModel;

import client.model.Model;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.rmi.RemoteException;

public class ChangeCarViewModel
{
  private StringProperty carBrandProperty;
  private StringProperty licenseNoProperty;
  private StringProperty colorProperty;
  private StringProperty errorProperty;
  private Model model;

  public ChangeCarViewModel(Model model)
  {
    this.model = model;
    carBrandProperty = new SimpleStringProperty("");
    licenseNoProperty = new SimpleStringProperty("");
    colorProperty = new SimpleStringProperty("");
    errorProperty = new SimpleStringProperty("");
  }

  public void reset()
  {
    carBrandProperty.set("");
    licenseNoProperty.set("");
    colorProperty.set("");
    errorProperty.set("");
  }

  public StringProperty getCarBrandProperty()
  {
    return carBrandProperty;
  }

  public StringProperty getColorProperty()
  {
    return colorProperty;
  }

  public StringProperty getLicenseNoProperty()
  {
    return licenseNoProperty;
  }

  public StringProperty getErrorProperty()
  {
    return errorProperty;
  }

  public void registerVehicle() throws RemoteException
  {
    model.registerVehicle(licenseNoProperty.get(), colorProperty.get(),
        carBrandProperty.get());
  }

}
