package chamelion.chamelophone.com.usermanagementportal.ui.di;
import chamelion.chamelophone.com.usermanagementportal.ui.LoginActivity;
import javax.inject.Singleton;
import dagger.Component;

@Singleton
@Component(modules = MyModule.class)
interface MyComponent {

  void inject(LoginActivity loginActivity);

}