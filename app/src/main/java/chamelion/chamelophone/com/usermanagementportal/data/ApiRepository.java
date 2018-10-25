package chamelion.chamelophone.com.usermanagementportal.data;

import chamelion.chamelophone.com.usermanagementportal.data.datamodel.Token;

import chamelion.chamelophone.com.usermanagementportal.data.datamodel.UseDataList;
import chamelion.chamelophone.com.usermanagementportal.data.datamodel.UserData;
import javax.inject.Inject;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiRepository {

  ApiEndPointInterface apiInterface;

  Retrofit retrofit;

  @Inject
  public ApiRepository() {
    initMethod();
  }

  private void initMethod() {
    Retrofit retrofit = new Retrofit.Builder()
        .baseUrl("https://reqres.in/")
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
        .build();
    apiInterface = retrofit.create(ApiEndPointInterface.class);
  }

  public Call<Token> registerAdmin(String email, String password) {
    initMethod();
    Call<Token> call = apiInterface.registerAdmin(email, password);
    return call;
  }

  public Call<UserData> addPerson(String name, String job) {
    initMethod();
    Call<UserData> call = apiInterface.createPerson(name, job);
    return call;
  }

  public Call<UseDataList> getUsers() {
    initMethod();
    Call<UseDataList> call = apiInterface.getPersons();
    return call;
  }
}
