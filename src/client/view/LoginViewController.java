package client.view;

import client.viewModel.LoginViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class LoginViewController
{
  @FXML private TextField usernameField;
  @FXML private TextField passwordField;
  @FXML private Label errorLabel;
  private ViewHandler viewHandler;
  private Region root;
  private LoginViewModel viewModel;

  public LoginViewController()
  {

  }

  public void init(ViewHandler viewHandler, LoginViewModel viewModel, Region root)
  {
    this.viewModel = viewModel;
    this.viewHandler = viewHandler;
    this.root = root;

    usernameField.textProperty().bindBidirectional(viewModel.getUserNameProperty());
    passwordField.textProperty().bindBidirectional(viewModel.getPasswordProperty());
    errorLabel.textProperty().bindBidirectional(viewModel.getErrorProperty());
  }

  public Region getRoot()
  {
    return root;
  }

  public void reset()
  {
    viewModel.reset();
  }

  @FXML private void onLogin()
  {
    if(viewModel.login()){

    }
  }

  @Override
  public void propertyChange(PropertyChangeEvent evt) {

  }
}
