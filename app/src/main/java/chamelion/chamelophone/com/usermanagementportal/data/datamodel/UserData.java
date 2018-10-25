package chamelion.chamelophone.com.usermanagementportal.data.datamodel;

import com.google.gson.annotations.SerializedName;

public class UserData {
  @SerializedName("name")
  private String name;

  @SerializedName("job")
  private String job;

  @SerializedName("id")
  private String id;

  @SerializedName("createdAt")
  private String CreatedAt;

  public UserData() {
  }

}
