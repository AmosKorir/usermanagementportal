package chamelion.chamelophone.com.usermanagementportal.domain;

public class Admin {
  private String email;

  private String password;

  public Admin() {
  }

  private Admin(Builder builder) {
    setEmail(builder.email);
    setPassword(builder.password);
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }


  public static final class Builder {
    private String email;
    private String password;

    private Builder() {
    }

    public Builder withEmail(String val) {
      email = val;
      return this;
    }

    public Builder withPassword(String val) {
      password = val;
      return this;
    }

    public Admin build() {
      return new Admin(this);
    }
  }
}
