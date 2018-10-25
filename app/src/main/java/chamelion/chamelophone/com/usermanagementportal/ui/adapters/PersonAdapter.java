package chamelion.chamelophone.com.usermanagementportal.ui.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import chamelion.chamelophone.com.usermanagementportal.R;
import chamelion.chamelophone.com.usermanagementportal.data.datamodel.Data;

import java.util.ArrayList;

public class PersonAdapter extends ArrayAdapter<Data> {

  @BindView(R.id.itemname) TextView nametxt;
  @BindView(R.id.itemjob) TextView jobtxt;
  @BindView(R.id.itembutton) ImageButton optionButton;

  int resourse;

  Context context;

  ArrayList<Data> users;

  public PersonAdapter(Context context, int resource, ArrayList<Data> objects) {
    super(context, resource, objects);
    this.context = context;
    this.resourse = resource;
    users = objects;
  }

  @NonNull @Override
  public View getView(int position, View itemView, ViewGroup parent) {
    itemView = LayoutInflater.from(context).inflate(resourse, null);
    ButterKnife.bind(this, itemView);

    optionButton.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View view) {
        showPopup(view, position);
      }
    });
    return itemView;
  }

  public void showPopup(View v, int position) {
    PopupMenu popup = new PopupMenu(context, v);
    MenuInflater inflater = popup.getMenuInflater();
    inflater.inflate(R.menu.popmenu, popup.getMenu());
    popup.show();

    popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
      @Override public boolean onMenuItemClick(MenuItem menuItem) {
        menuItem.getItemId();
        if (R.id.delete == menuItem.getItemId()) {
          Toast.makeText(context, "delete", Toast.LENGTH_SHORT).show();
        }
        if (R.id.edit == menuItem.getItemId()) {
          Toast.makeText(context, "edit", Toast.LENGTH_SHORT).show();
        }
        return false;
      }
    });
  }
}
