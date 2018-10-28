package chamelion.chamelophone.com.usermanagementportal.presentation;


import chamelion.chamelophone.com.usermanagementportal.data.ApiRepository;
import chamelion.chamelophone.com.usermanagementportal.data.datamodel.Token;
import javax.inject.Inject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginPresenter {

    ApiRepository apiRepository;
  public void setView(
      mView view) {
    this.view = view;
    apiRepository=new ApiRepository();
  }

  mView view;

  @Inject
  public LoginPresenter() {
  }

  public void authUser(String email, String password) {
    if (email.isEmpty() || password.isEmpty()) {
      view.failed("Please enter the right login");
    } else {
      Call<Token> call=apiRepository.logikn(email,password);
      call.enqueue(new Callback<Token>() {
        @Override public void onResponse(Call<Token> call, Response<Token> response) {
          view.sucess();
        }

        @Override public void onFailure(Call<Token> call, Throwable t) {
          view.failed("FAILED");
        }
      });

    }
  }

  public interface mView {
    void sucess();

    void failed(String message);
  }
}
