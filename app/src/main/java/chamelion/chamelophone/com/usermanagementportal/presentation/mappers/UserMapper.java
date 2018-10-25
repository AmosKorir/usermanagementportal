package chamelion.chamelophone.com.usermanagementportal.presentation.mappers;

import chamelion.chamelophone.com.usermanagementportal.data.datamodel.Data;
import chamelion.chamelophone.com.usermanagementportal.domain.User;

public class UserMapper {

  public User map(Data data) {
    User user = new User();
    user.setAvatar(data.getAvatar());
    user.setFirstName(data.getFirstName());
    user.setLastName(data.getLastName());
    user.setId(data.getId());
    return user;
  }
}
