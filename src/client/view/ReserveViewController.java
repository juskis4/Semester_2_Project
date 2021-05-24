package client.view;

import client.utility.IntStringConverter;
import client.viewModel.ParkingLotViewModel;
import client.viewModel.ReserveViewModel;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import server.model.domain.User;

import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.rmi.RemoteException;
import java.sql.SQLException;

public class ReserveViewController
{
  @FXML private TextField hourField;
  @FXML private TextField minField;
  @FXML private DatePicker reserveDate;
  @FXML private Label parkingSpaceField;
  @FXML private Label errorLabel;
  private ViewHandler viewHandler;
  private Region root;
  private ReserveViewModel viewModel;

  public ReserveViewController()
  {

  }

  public void init(ViewHandler viewHandler, ReserveViewModel viewModel, Region root)
      throws RemoteException
  {
    this.viewModel = viewModel;
    this.viewHandler = viewHandler;
    this.root = root;

    parkingSpaceField.textProperty().bindBidirectional(viewModel.nameOfParkingSpaceProperty());
    Bindings.bindBidirectional(hourField.textProperty(),
        viewModel.hProperty(), new IntStringConverter());
    Bindings.bindBidirectional(minField.textProperty(),
        viewModel.mProperty(), new IntStringConverter());
    TextField dateEditor = reserveDate.getEditor();
    viewModel.dateInStringProperty().bindBidirectional(dateEditor.textProperty());
    errorLabel.textProperty().bindBidirectional(viewModel.getErrorLabelProperty());

//    dateEditor.textProperty().bind(viewModel.dateInStringProperty());

  }

  public void reset()
  {
    viewModel.reset();
  }

  public Region getRoot()
  {
    return root;
  }

  @FXML public void onReserve() throws RemoteException, SQLException
  {
    viewModel.registerSpace();
    viewHandler.openView("ParkingLotView");
  }
  @FXML public void onWorkingHours()
  {
    viewHandler.openView("WorkingHoursView");
  }
}
