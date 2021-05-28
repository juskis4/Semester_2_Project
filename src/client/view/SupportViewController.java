package client.view;

import client.viewModel.SupportViewModel;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;

public class SupportViewController
{
  @FXML private Label errorLabel;
  private ViewHandler viewHandler;
  private Region root;
  private SupportViewModel supportViewModel;

  public SupportViewController()
  {

  }

  public void init(ViewHandler viewHandler, SupportViewModel viewModel, Region root)
  {
    this.supportViewModel = viewModel;
    this.viewHandler = viewHandler;
    this.root = root;
    errorLabel.textProperty().bindBidirectional(viewModel.getErrorProperty());
  }

  public Region getRoot()
  {
    return root;
  }

  public void reset()
  {
    supportViewModel.reset();
  }


  @FXML private void onProfile()
  {
    viewHandler.openView("ProfileView");
  }

  @FXML private void onParkingLot()
  {
    viewHandler.openView("ParkingLotView");
  }

  @FXML private void onChangeYourCar()
  {
    viewHandler.openView("ChangeCar");
  }

  @FXML private void onWorkingHours()
  {
    viewHandler.openView("WorkingHoursView");
  }

  @FXML private void onSubmit()
  {

  }
}
