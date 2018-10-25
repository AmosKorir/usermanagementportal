package chamelion.chamelophone.com.usermanagementportal.data.datamodel;

import javax.inject.Inject;

public class ApiRepository {
  @Inject
  public ApiRepository() {
  }

  public void registerAdmin(String email,String password){
    AdminData adminData=new AdminData(email,password);
  }
}
