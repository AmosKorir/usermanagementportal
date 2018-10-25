package chamelion.chamelophone.com.usermanagementportal.ui;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import chamelion.chamelophone.com.usermanagementportal.R;
import chamelion.chamelophone.com.usermanagementportal.presentation.DashBoardPresnter;
import chamelion.chamelophone.com.usermanagementportal.ui.di.MyApplication;
import javax.inject.Inject;

public class DashBoard extends AppCompatActivity implements DashBoardPresnter.Mview {

  AlertDialog.Builder builder;

  LayoutInflater inflater;

  @Inject DashBoardPresnter dashBoardPresnter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_dash_board);

    ((MyApplication) getApplication())
        .getMyComponent().inject(DashBoard.this);
    dashBoardPresnter.setMview(this);

    builder = new AlertDialog.Builder(this);

    ButterKnife.bind(this);

    inflater = this.getLayoutInflater();
  }

  @OnClick(R.id.addcard)
  public void addUser() {
    addPerson();
  }

  @OnClick(R.id.listcard)
  public void listUsers() {
    startActivity(new Intent(this, ListUsersActvity.class));
  }

  private void addPerson() {
    builder.setTitle(R.string.add_person);
    View dialogView = inflater.inflate(R.layout.dialog_adduser_layout, null);
    builder.setView(dialogView);
    final EditText nameEditText = dialogView.findViewById(R.id.name);
    final EditText jobEditText = dialogView.findViewById(R.id.job);

    builder.setPositiveButton(
        R.string.ok,
        new DialogInterface.OnClickListener() {
          public void onClick(DialogInterface dialog, int id) {
            dashBoardPresnter.addUser(nameEditText.getText().toString().trim(),
                jobEditText.getText().toString().trim());
            dialog.cancel();
          }
        });

    builder.setNegativeButton(
        R.string.cancel,
        new DialogInterface.OnClickListener() {
          public void onClick(DialogInterface dialog, int id) {
            dialog.cancel();
          }
        });
    AlertDialog alertPinDialog = builder.create();
    alertPinDialog.setOnShowListener(new DialogInterface.OnShowListener() {
      @Override public void onShow(DialogInterface dialogInterface) {
        alertPinDialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(Color.RED);
      }
    });
    alertPinDialog.show();
  }

  @Override public void sucess() {

  }

  @Override public void message(String message) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
  }
}
