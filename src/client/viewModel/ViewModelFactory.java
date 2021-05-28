package client.viewModel;

import client.model.Model;
import client.view.SupportViewController;

import java.rmi.RemoteException;
import java.sql.SQLException;

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

  public ReserveViewModel getReserveViewModel()
  {
    return reserveViewModel;
  }

  public WorkingHoursViewModel getWorkingHoursViewModel()
  {
    return workingHoursViewModel;
  }

  public ParkingLotViewModel getParkingLotViewModel()
  {
    return parkingLotViewModel;
  }


  public LoginViewModel getLoginViewModel()
  {
    return loginViewModel;
  }

  public RegisterViewModel getRegisterViewModel()
  {
    return registerViewModel;
  }

  public ChangeCarViewModel getChangeCarViewModel()
  {
    return changeCarViewModel;
  }

  public ProfileViewModel getProfileViewModel()
  {
    return profileViewModel;
  }

  public CancelReservationViewModel getCancelReservationViewModel()
  {
    return cancelReservationViewModel;
  }

  public SupportViewModel getSupportViewModel()
  {
    return supportViewModel;
  }
}
