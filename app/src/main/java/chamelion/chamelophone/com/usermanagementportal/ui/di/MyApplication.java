package chamelion.chamelophone.com.usermanagementportal.ui.di;

import android.app.Application;

public class MyApplication extends Application {

  private MyComponent mMyComponent;

  @Override
  public void onCreate() {
    super.onCreate();
    mMyComponent = createMyComponent();
  }

  public MyComponent getMyComponent() {
    return mMyComponent;
  }

  private MyComponent createMyComponent() {
    return DaggerMyComponent
        .builder()
        .myModule(new MyModule())
        .build();
  }

}