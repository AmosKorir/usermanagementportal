package chamelion.chamelophone.com.usermanagementportal.presentation;

import chamelion.chamelophone.com.usermanagementportal.data.ApiRepository;
import chamelion.chamelophone.com.usermanagementportal.data.datamodel.Data;
import chamelion.chamelophone.com.usermanagementportal.data.datamodel.UseDataList;
import chamelion.chamelophone.com.usermanagementportal.data.datamodel.UserData;
import chamelion.chamelophone.com.usermanagementportal.domain.User;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListUserActivityPresenter {

  Mview view;

  ApiRepository repository;

  @Inject
  public ListUserActivityPresenter() {
    repository = new ApiRepository();
  }

  public void setView(
      Mview view) {
    this.view = view;

  }

  public void getUsers() {
    Call<UseDataList> call = repository.getUsers();

    call.enqueue(new Callback<UseDataList>() {
      @Override public void onResponse(Call<UseDataList> call, Response<UseDataList> response) {
        UseDataList useDataList = response.body();
        List<Data> list = useDataList.getData();
        ArrayList<Data> arrayList = new ArrayList<>(list);
        view.loadList(arrayList);
      }

      @Override public void onFailure(Call<UseDataList> call, Throwable t) {
        view.message("Failed to load");
      }
    });
  }

  public interface Mview {

    void success();

    void loadList(ArrayList<Data> arrayList);

    void message(String message);
  }
}
