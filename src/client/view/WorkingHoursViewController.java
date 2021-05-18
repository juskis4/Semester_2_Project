package client.view;

import client.viewModel.LoginViewModel;
import client.viewModel.WorkingHoursViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;


public class WorkingHoursViewController
{
  @FXML private Label errorLabel;
  private ViewHandler viewHandler;
  private Region root;
  private WorkingHoursViewModel workingHoursViewModel;

  public WorkingHoursViewController()
  {

  }

  public void init(ViewHandler viewHandler, WorkingHoursViewModel viewModel, Region root)
  {
    this.workingHoursViewModel = viewModel;
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
    workingHoursViewModel.reset();
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



}
