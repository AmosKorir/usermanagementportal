package chamelion.chamelophone.com.usermanagementportal.data.datamodel;

import com.google.gson.annotations.SerializedName;

public class Token {
  public void setToken(String token) {
    this.token = token;
  }

  public String getToken() {
    return token;
  }

  @SerializedName("token")

  private String token;

  public Token(String token) {
    this.token = token;
  }
}
