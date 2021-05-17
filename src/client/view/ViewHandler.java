package client.view;

import client.viewModel.RegisterViewModel;
import client.viewModel.ViewModelFactory;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

public class ViewHandler
{
  private Scene currentScene;
  private Stage primaryStage;
  private ViewModelFactory viewModelFactory;
  private LoginViewController loginViewController;
  private RegisterViewController registerViewController;
  private ChangeCarViewController changeCarViewController;
  private ProfileViewController profileViewController;

  public ViewHandler(ViewModelFactory viewModelFactory)
  {
    this.viewModelFactory = viewModelFactory;
  }

  public void start(Stage primaryStage)
  {
    this.primaryStage = primaryStage;
    this.currentScene = new Scene(new Region());
    openView("Log");
  }

  public void openView(String window)
  {
    Region root = null;
    switch (window)
    {
      case "Login":
        root = loadLoginView("LoginView.fxml");
        break;

      case "Register":
        root = loadRegisterView("RegisterView.fxml");
        break;

      case "ChangeCar":
        root = loadChangeCarView("ChangeCarView.fxml");
        break;
    }

    currentScene.setRoot(root);
    String title = "";
    if(root.getUserData() != null)
    {
      title += root.getUserData();
    }

    primaryStage.setTitle(title);
    primaryStage.setScene(currentScene);
    primaryStage.setWidth(root.getMaxWidth());
    primaryStage.setHeight(root.getMaxHeight());
    primaryStage.show();
  }

  public Region loadLoginView(String fxmlFile)
  {
    if(loginViewController == null)
    {
      try {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxmlFile));
        Region root = loader.load();
        loginViewController = loader.getController();
        loginViewController.init(this, viewModelFactory.getLoginViewModel(), root);
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
    }
    else {
      loginViewController.reset();
    }
    return loginViewController.getRoot();
  }

  public Region loadRegisterView(String fxmlFile)
  {
    if(registerViewController == null)
    {
      try {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxmlFile));
        Region root = loader.load();
        registerViewController = loader.getController();
        registerViewController.init(this, viewModelFactory.getRegisterViewModel(), root);
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
    }
    else {
      registerViewController.reset();
    }
    return registerViewController.getRoot();
  }

  public Region loadChangeCarView(String fxmlFile)
  {
    if(changeCarViewController == null)
    {
      try {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxmlFile));
        Region root = loader.load();
        changeCarViewController = loader.getController();
        changeCarViewController.init(this, viewModelFactory.getChangeCarViewModel(), root);
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
    }
    else {
      changeCarViewController.reset();
    }
    return changeCarViewController.getRoot();
  }

  public Region loadProfileView(String fxmlFile)
  {
    if(profileViewController == null)
    {
      
    }
  }

}
