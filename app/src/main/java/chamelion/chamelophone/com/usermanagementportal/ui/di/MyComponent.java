package chamelion.chamelophone.com.usermanagementportal.ui.di;
import chamelion.chamelophone.com.usermanagementportal.presentation.RegisterPresenter;
import chamelion.chamelophone.com.usermanagementportal.ui.DashBoard;
import chamelion.chamelophone.com.usermanagementportal.ui.ListUsersActvity;
import chamelion.chamelophone.com.usermanagementportal.ui.LoginActivity;
import chamelion.chamelophone.com.usermanagementportal.ui.RegisterActivity;
import javax.inject.Singleton;
import dagger.Component;

@Singleton
@Component(modules = MyModule.class)
public interface MyComponent {


  void inject(LoginActivity loginActivity);

  void inject(RegisterActivity registerActivity);

  void inject(RegisterPresenter registerPresenter);

  void inject(DashBoard dashBoard);

  void inject(ListUsersActvity listUsersActvity);

}