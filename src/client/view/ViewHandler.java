package client.view;

import client.viewModel.CancelReservationViewModel;
import client.viewModel.RegisterViewModel;
import client.viewModel.ViewModelFactory;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * A class for handling controllers.
 */
public class ViewHandler {
    private Scene currentScene;
    private Stage primaryStage;
    private ViewModelFactory viewModelFactory;
    private LoginViewController loginViewController;
    private RegisterViewController registerViewController;
    private ChangeCarViewController changeCarViewController;
    private ProfileViewController profileViewController;
    private ParkingLotViewController parkingLotViewController;
    private WorkingHoursViewController workingHoursViewController;
    private ReserveViewController reserveViewController;
    private CancelReservationViewController cancelReservationViewController;

    /**
     * Constructor that initializes view model factory.
     * @param viewModelFactory
     */
    public ViewHandler(ViewModelFactory viewModelFactory) {
        this.viewModelFactory = viewModelFactory;
    }

    /**
     * Starting and opening the first window(login window).
     * @param primaryStage the first stage.
     */
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.currentScene = new Scene(new Region());
        openView("Login");
    }

    /**
     * A method for opening different views.
     * @param window view name.
     */
    public void openView(String window) {
        try {
            double width = primaryStage.getWidth();
            double height = primaryStage.getHeight();
            Region root = null;
            switch (window) {
                case "Login":
                    root = loadLoginView("LoginView.fxml");
                    break;

                case "Register":
                    root = loadRegisterView("RegisterView.fxml");
                    break;

                case "ChangeCar":
                    root = loadChangeCarView("ChangeCarView.fxml");
                    break;

                case "ProfileView":
                    root = loadProfileView("ProfileView.fxml");
                    break;

                case "ParkingLotView":
                    root = loadParkingView("ParkingLotView.fxml");
                    break;

                case "WorkingHoursView":
                    root = loadWorkingHoursView("WorkingHoursView.fxml");
                    break;

                case "ReserveView":
                    root = loadReserveView("ReserveView.fxml");
                    break;

                case "CancelReservationView":
                    root = loadCancelReservationView("CancelReservationView.fxml");
                    break;
            }

            currentScene.setRoot(root);
            String title = "";
            if (root.getUserData() != null) {
                title += root.getUserData();
            }
            primaryStage.setTitle(title);
            primaryStage.setScene(currentScene);
            primaryStage.setWidth(root.getPrefWidth());
            primaryStage.setHeight(root.getPrefHeight());
            primaryStage.setWidth(root.getPrefWidth());
            primaryStage.setHeight(root.getPrefHeight());
            primaryStage.show();
            primaryStage.setMinWidth(root.minWidth(-1));
            primaryStage.setMinHeight(root.minHeight(-1));
            primaryStage.show();
            if(primaryStage.getMinWidth() <= width){
                primaryStage.setWidth(width);
            }
            if(primaryStage.getMinHeight() <= height)
            {
                primaryStage.setHeight(height);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Loader for login view.
     * @param fxmlFile view name.
     * @return returning view root.
     */
    public Region loadLoginView(String fxmlFile) {
        if (loginViewController == null) {
            try {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource(fxmlFile));
                Region root = loader.load();
                loginViewController = loader.getController();
                loginViewController
                        .init(this, viewModelFactory.getLoginViewModel(), root);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            loginViewController.reset();
        }
        return loginViewController.getRoot();
    }
    /**
     * Loader for register view.
     * @param fxmlFile view name.
     * @return returning view root.
     */
    public Region loadRegisterView(String fxmlFile) {
        if (registerViewController == null) {
            try {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource(fxmlFile));
                Region root = loader.load();
                registerViewController = loader.getController();
                registerViewController
                        .init(this, viewModelFactory.getRegisterViewModel(), root);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            registerViewController.reset();
        }
        return registerViewController.getRoot();
    }
    /**
     * Loader for change car view.
     * @param fxmlFile view name.
     * @return returning view root.
     */
    public Region loadChangeCarView(String fxmlFile) {
        if (changeCarViewController == null) {
            try {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource(fxmlFile));
                Region root = loader.load();
                changeCarViewController = loader.getController();
                changeCarViewController
                        .init(this, viewModelFactory.getChangeCarViewModel(), root);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            changeCarViewController.reset();
        }
        return changeCarViewController.getRoot();
    }
    /**
     * Loader for profile view.
     * @param fxmlFile view name.
     * @return returning view root.
     */
    public Region loadProfileView(String fxmlFile) {
        if (profileViewController == null) {
            try {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource(fxmlFile));
                Region root = loader.load();
                profileViewController = loader.getController();
                profileViewController.init(this, viewModelFactory.getProfileViewModel(), root);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return profileViewController.getRoot();
    }
    /**
     * Loader for parking view.
     * @param fxmlFile view name.
     * @return returning view root.
     */
    public Region loadParkingView(String fxmlFile) {
        if (parkingLotViewController == null) {
            try {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource(fxmlFile));
                Region root = loader.load();
                parkingLotViewController = loader.getController();
                parkingLotViewController.init(this, viewModelFactory.getParkingLotViewModel(), root);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return parkingLotViewController.getRoot();
    }
    /**
     * Loader for working hours view.
     * @param fxmlFile view name.
     * @return returning view root.
     */
    public Region loadWorkingHoursView(String fxmlFile) {
        if (workingHoursViewController == null) {
            try {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource(fxmlFile));
                Region root = loader.load();
                workingHoursViewController = loader.getController();
                workingHoursViewController
                        .init(this, viewModelFactory.getWorkingHoursViewModel(), root);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return workingHoursViewController.getRoot();
    }
    /**
     * Loader for reserve view.
     * @param fxmlFile view name.
     * @return returning view root.
     */
    public Region loadReserveView(String fxmlFile) {
        if (reserveViewController == null) {
            try {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource(fxmlFile));
                Region root = loader.load();
                reserveViewController = loader.getController();
                reserveViewController.init(this, viewModelFactory.getReserveViewModel(), root);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return reserveViewController.getRoot();
    }
    /**
     * Loader for cancel reservation view.
     * @param fxmlFile view name.
     * @return returning view root.
     */
    public Region loadCancelReservationView(String fxmlFile) {
        if (cancelReservationViewController == null) {
            try {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource(fxmlFile));
                Region root = loader.load();
                cancelReservationViewController = loader.getController();
                cancelReservationViewController.init(this, viewModelFactory.getCancelReservationViewModel(), root);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return cancelReservationViewController.getRoot();
    }
}