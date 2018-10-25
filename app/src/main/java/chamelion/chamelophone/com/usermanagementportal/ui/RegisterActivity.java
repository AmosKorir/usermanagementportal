package chamelion.chamelophone.com.usermanagementportal.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import chamelion.chamelophone.com.usermanagementportal.R;
import chamelion.chamelophone.com.usermanagementportal.presentation.RegisterPresenter;
import chamelion.chamelophone.com.usermanagementportal.ui.di.MyApplication;
import javax.inject.Inject;

public class RegisterActivity extends AppCompatActivity implements RegisterPresenter.Mview {
  @BindView(R.id.LoginEmail) EditText email;
  @BindView(R.id.LoginPassword) EditText password;

  @Inject RegisterPresenter registerPresenter;
  private String mPassword;
  private String mEmail;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_register);
    ButterKnife.bind(this);
    ((MyApplication) getApplication())
        .getMyComponent().inject(RegisterActivity.this);
    ButterKnife.bind(this);
    registerPresenter.setMview(this);
  }

  @OnClick(R.id.RegisterBtn)
  public void login() {
    mEmail = email.getText().toString().trim();
    mPassword = password.getText().toString().trim();
    registerPresenter.registerUser(mEmail, mPassword);
  }

  @Override public void sucess() {
    startActivity(new Intent(this,DashBoard.class));
    Toast.makeText(this, R.string.success, Toast.LENGTH_SHORT).show();
  }

  @Override public void message(String message) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
  }
}
