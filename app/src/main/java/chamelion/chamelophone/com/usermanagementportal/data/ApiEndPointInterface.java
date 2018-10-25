package chamelion.chamelophone.com.usermanagementportal.data;

import chamelion.chamelophone.com.usermanagementportal.data.datamodel.Token;
import chamelion.chamelophone.com.usermanagementportal.data.datamodel.UseDataList;
import chamelion.chamelophone.com.usermanagementportal.data.datamodel.UserData;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface ApiEndPointInterface {

  @POST("/api/register")
  @FormUrlEncoded
  Call<Token> registerAdmin(@Field("email") String email, @Field("password") String password);

  @POST("/api/login")
  @FormUrlEncoded
  Call<Token> loginAdmin(@Field("email") String email, @Field("password") String password);

  @POST("/api/users")
  @FormUrlEncoded
  Call<UserData> createPerson(@Field("name") String name, @Field("job") String job);

  @GET("/api/users?page=2")
  Call<UseDataList> getPersons();
}
