package chamelion.chamelophone.com.usermanagementportal.ui.di;

import chamelion.chamelophone.com.usermanagementportal.data.ApiRepository;
import chamelion.chamelophone.com.usermanagementportal.presentation.DashBoardPresnter;
import chamelion.chamelophone.com.usermanagementportal.presentation.LoginPresenter;
import chamelion.chamelophone.com.usermanagementportal.presentation.RegisterPresenter;
import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;

@Module class MyModule {


  @Provides
  static LoginPresenter provideLoginPresenter() {
    return new LoginPresenter();
  }

  @Provides RegisterPresenter provideRegisterPresenter() {
    return new RegisterPresenter();
  }

  @Provides DashBoardPresnter provideDashBoardPresenter() {
    return new DashBoardPresnter();
  }

  @Provides ApiRepository provideApiRepository() {
    return new ApiRepository();
  }
}