package chamelion.chamelophone.com.usermanagementportal.ui;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import butterknife.BindView;
import butterknife.ButterKnife;
import chamelion.chamelophone.com.usermanagementportal.R;
import chamelion.chamelophone.com.usermanagementportal.data.datamodel.Data;
import chamelion.chamelophone.com.usermanagementportal.domain.User;
import chamelion.chamelophone.com.usermanagementportal.presentation.ListUserActivityPresenter;
import chamelion.chamelophone.com.usermanagementportal.ui.adapters.PersonAdapter;
import chamelion.chamelophone.com.usermanagementportal.ui.di.MyApplication;
import java.util.ArrayList;
import javax.inject.Inject;

public class ListUsersActvity extends AppCompatActivity implements ListUserActivityPresenter.Mview {

  @Inject ListUserActivityPresenter listUserActivityPresenter;

  @BindView(R.id.userlist) ListView listView;

  ProgressDialog progressDialog;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_list_users_actvity);

    ((MyApplication) getApplication())
        .getMyComponent().inject(ListUsersActvity.this);
    progressDialog=new ProgressDialog(this);
    progressDialog.setMessage(getString(R.string.pleasewait));

    ButterKnife.bind(this);
    listUserActivityPresenter.setView(this);
    listUserActivityPresenter.getUsers();
  }

  @Override public void success() {

  }

  @Override public void loadList(ArrayList<Data> arrayList) {
    progressDialog.dismiss();
    PersonAdapter adapter = new PersonAdapter(this, R.layout.user_item_layout, arrayList);
    listView.setAdapter(adapter);
  }

  @Override public void message(String message) {

  }
}
