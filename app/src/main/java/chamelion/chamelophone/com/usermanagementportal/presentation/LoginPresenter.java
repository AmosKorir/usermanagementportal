package chamelion.chamelophone.com.usermanagementportal.presentation;

import javax.inject.Inject;

public class LoginPresenter {

  public void setView(
      mView view) {
    this.view = view;
  }

  mView view;

  @Inject
  public LoginPresenter() {
  }

  public void authUser(String email, String password) {
    if (email.isEmpty() || password.isEmpty()) {
      view.failed("Please enter the right login");
    } else {
      view.sucess();
    }
  }

  public interface mView {
    void sucess();

    void failed(String message);
  }
}
