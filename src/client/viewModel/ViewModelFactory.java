package client.viewModel;

import client.model.Model;

public class ViewModelFactory
{
  private LoginViewModel loginViewModel;
  private RegisterViewModel registerViewModel;
  private ChangeCarViewModel changeCarViewModel;
  private ProfileViewModel profileViewModel;

  public ViewModelFactory(Model model)
  {
    this.loginViewModel = new LoginViewModel(model);
    this.registerViewModel = new RegisterViewModel(model);
    this.changeCarViewModel = new ChangeCarViewModel(model);
    this.profileViewModel = new ProfileViewModel(model);
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
}
