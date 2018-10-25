package chamelion.chamelophone.com.usermanagementportal.data.datamodel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {

  @SerializedName("id")
  @Expose
  private int id;
  @SerializedName("first_name")
  @Expose
  private String firstName;
  @SerializedName("last_name")
  @Expose
  private String lastName;
  @SerializedName("avatar")
  @Expose
  private String avatar;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Data withId(int id) {
    this.id = id;
    return this;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public Data withFirstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public Data withLastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  public String getAvatar() {
    return avatar;
  }

  public void setAvatar(String avatar) {
    this.avatar = avatar;
  }

  public Data withAvatar(String avatar) {
    this.avatar = avatar;
    return this;
  }

}