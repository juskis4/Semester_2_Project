package client.viewModel;

import client.model.Model;

public class ViewModelFactory
{
  private LoginViewModel loginViewModel;
  private RegisterViewModel registerViewModel;
  private ChangeCarViewModel changeCarViewModel;

  public ViewModelFactory(Model model)
  {
    this.loginViewModel = new LoginViewModel(model);
    this.registerViewModel = new RegisterViewModel(model);
    this.changeCarViewModel = new ChangeCarViewModel(model);
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
}
