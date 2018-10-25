package chamelion.chamelophone.com.usermanagementportal.presentation;

import chamelion.chamelophone.com.usermanagementportal.R;
import chamelion.chamelophone.com.usermanagementportal.data.ApiRepository;
import chamelion.chamelophone.com.usermanagementportal.data.datamodel.UserData;
import java.util.Observer;
import javax.inject.Inject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DashBoardPresnter {

  Mview mview;

  ApiRepository apiRepository;

  @Inject
  public DashBoardPresnter() {
    apiRepository = new ApiRepository();
  }

  public Mview getMview() {
    return mview;
  }

  public void addUser(String name, String job) {
    if (name.isEmpty() || job.isEmpty()) {
      mview.message("Please enter both fields");
    } else {
      addUser(apiRepository.addPerson(name, job));
    }
  }

  private void addUser(
      Call<UserData> userDataCall) {
    userDataCall.enqueue(new Callback<UserData>() {
      @Override public void onResponse(Call<UserData> call, Response<UserData> response) {
        mview.message("Successful");
      }

      @Override public void onFailure(Call<UserData> call, Throwable t) {
        mview.message("Failed to add");
      }
    });

  }

  public void setMview(
      Mview mview) {
    this.mview = mview;
  }

  public interface Mview {
    void sucess();

    void message(String message);
  }
}
