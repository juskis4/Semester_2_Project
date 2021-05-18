package client.view;

import client.utility.IntStringConverter;
import client.viewModel.ReserveViewModel;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;

import java.awt.*;
import java.rmi.RemoteException;

public class ReserveViewController
{
  @FXML private TextField hourField;
  @FXML private TextField minField;
  @FXML private DatePicker reserveDate;
  private ViewHandler viewHandler;
  private Region root;
  private ReserveViewModel viewModel;

  public ReserveViewController()
  {

  }

  public void init(ViewHandler viewHandler, ReserveViewModel viewModel, Region root)
  {
    this.viewModel = viewModel;
    this.viewHandler = viewHandler;
    this.root = root;
    Bindings.bindBidirectional(hourField.textProperty(),
        viewModel.hProperty(), new IntStringConverter());
    Bindings.bindBidirectional(minField.textProperty(),
        viewModel.mProperty(), new IntStringConverter());
    TextField dateEditor = reserveDate.getEditor();
    dateEditor.textProperty().bind(viewModel.dateInStringProperty());
  }

  public Region getRoot()
  {
    return root;
  }

  @FXML public void onReserve() throws RemoteException
  {
    viewModel.registerSpace();
    viewHandler.openView("ParkingLotView");
  }
  @FXML public void onWorkingHours()
  {
    viewHandler.openView("WorkingHoursView");
  }
}
