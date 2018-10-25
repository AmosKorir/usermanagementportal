package chamelion.chamelophone.com.usermanagementportal.ui.di;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;
import chamelion.chamelophone.com.usermanagementportal.R;
import chamelion.chamelophone.com.usermanagementportal.ui.di.MyApplication;
import javax.inject.Inject;

public class LoginActivity extends AppCompatActivity {
  @Inject MyExample mMyExample;
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_login);
    ((MyApplication) getApplication())
        .getMyComponent().inject(LoginActivity.this);

    Toast.makeText(this, mMyExample.getDate()+"", Toast.LENGTH_SHORT).show();

  }
}
