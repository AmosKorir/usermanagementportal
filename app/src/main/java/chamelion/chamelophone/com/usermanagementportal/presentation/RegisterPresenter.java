package chamelion.chamelophone.com.usermanagementportal.presentation;

import android.support.annotation.MainThread;

import chamelion.chamelophone.com.usermanagementportal.data.ApiRepository;
import chamelion.chamelophone.com.usermanagementportal.data.datamodel.Token;
import chamelion.chamelophone.com.usermanagementportal.ui.di.MyApplication;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import javax.inject.Inject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterPresenter {

  Mview mview;

  ApiRepository apiRepository;

  @Inject
  public RegisterPresenter() {
    apiRepository = new ApiRepository();
  }

  public void setMview(
      Mview mview) {
    this.mview = mview;
  }

  public void registerUser(String email, String password) {
    if (email.isEmpty() || password.isEmpty()) {
      mview.message("Please enter the both fields");
    } else {
      register(email, password);
    }
  }

  private void register(String email, String password) {
    Call<Token> call = apiRepository.registerAdmin(email, password);

    call.enqueue(new Callback<Token>() {
      @Override public void onResponse(Call<Token> call, Response<Token> response) {
        mview.sucess();
      }

      @Override public void onFailure(Call<Token> call, Throwable t) {

      }
    });

  }

  public interface Mview {
    void sucess();

    void message(String message);
  }
}
