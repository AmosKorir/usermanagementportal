package chamelion.chamelophone.com.usermanagementportal.data.datamodel;

import com.google.gson.annotations.SerializedName;

public class AdminData {

  @SerializedName("email")
  private String email;

  @SerializedName("password")
  private String Password;

  public AdminData(String email, String password) {
    this.email = email;
    Password = password;
  }
}
