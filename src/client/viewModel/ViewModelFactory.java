package client.viewModel;

import client.model.Model;
import client.view.SupportViewController;

import java.rmi.RemoteException;
import java.sql.SQLException;

/**
 * Class that handles view models.
 */
public class ViewModelFactory
{
  private LoginViewModel loginViewModel;
  private RegisterViewModel registerViewModel;
  private ChangeCarViewModel changeCarViewModel;
  private ProfileViewModel profileViewModel;
  private ParkingLotViewModel parkingLotViewModel;
  private WorkingHoursViewModel workingHoursViewModel;
  private ReserveViewModel reserveViewModel;
  private CancelReservationViewModel cancelReservationViewModel;
  private SupportViewModel supportViewModel;

  /**
   * Constructor that initializes all view models.
   * @param model model.
   * @throws RemoteException throwing remote exception.
   * @throws SQLException throwing sql exception.
   */
  public ViewModelFactory(Model model) throws RemoteException, SQLException
  {
    this.loginViewModel = new LoginViewModel(model);
    this.registerViewModel = new RegisterViewModel(model);
    this.changeCarViewModel = new ChangeCarViewModel(model);
    this.profileViewModel = new ProfileViewModel(model);
    this.parkingLotViewModel = new ParkingLotViewModel(model);
    this.workingHoursViewModel = new WorkingHoursViewModel(model);
    this.reserveViewModel = new ReserveViewModel(model);
    this.cancelReservationViewModel = new CancelReservationViewModel(model);
    this.supportViewModel = new SupportViewModel(model);
  }

  /**
   * getter for reserve view model.
   * @return
   */
  public ReserveViewModel getReserveViewModel()
  {
    return reserveViewModel;
  }
  /**
   * getter for working hours view model.
   * @return
   */
  public WorkingHoursViewModel getWorkingHoursViewModel()
  {
    return workingHoursViewModel;
  }
  /**
   * getter for parking lot view model.
   * @return
   */
  public ParkingLotViewModel getParkingLotViewModel()
  {
    return parkingLotViewModel;
  }
  /**
   * getter for login view model.
   * @return
   */
  public LoginViewModel getLoginViewModel()
  {
    return loginViewModel;
  }
  /**
   * getter for register view model.
   * @return
   */
  public RegisterViewModel getRegisterViewModel()
  {
    return registerViewModel;
  }
  /**
   * getter for change car view model.
   * @return
   */
  public ChangeCarViewModel getChangeCarViewModel()
  {
    return changeCarViewModel;
  }
  /**
   * getter for profile view model.
   * @return
   */
  public ProfileViewModel getProfileViewModel()
  {
    return profileViewModel;
  }
  /**
   * getter for cancel reservation view model.
   * @return
   */
  public CancelReservationViewModel getCancelReservationViewModel()
  {
    return cancelReservationViewModel;
  }
  /**
   * getter for support view model.
   * @return
   */
  public SupportViewModel getSupportViewModel()
  {
    return supportViewModel;
  }
}
