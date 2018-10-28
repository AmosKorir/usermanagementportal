package chamelion.chamelophone.com.usermanagementportal.ui.adapters;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import chamelion.chamelophone.com.usermanagementportal.R;
import chamelion.chamelophone.com.usermanagementportal.data.datamodel.Data;

import com.squareup.picasso.Picasso;
import java.util.ArrayList;

public class PersonAdapter extends ArrayAdapter<Data> {

  @BindView(R.id.itemname) TextView fname;
  @BindView(R.id.itemjob) TextView lname;
  @BindView(R.id.avatar) ImageView imageView;
  @BindView(R.id.itembutton) ImageButton optionButton;

  int resourse;

  Context context;

  ArrayList<Data> users;

  AlertDialog.Builder builder;

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
    builder = new AlertDialog.Builder(context);
    Data data = users.get(position);
    fname.setText(data.getFirstName());
    lname.setText(data.getLastName());
    Picasso.get()
        .load(data.getAvatar()).into(imageView);
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
          addPerson();
        }
        return false;
      }
    });
  }

  private void deletePerson() {

  }

  private void addPerson() {
    builder.setTitle("Edit Person");
    View dialogView = LayoutInflater.from(context).inflate(R.layout.dialog_adduser_layout, null);
    builder.setView(dialogView);
    final EditText nameEditText = dialogView.findViewById(R.id.name);
    final EditText jobEditText = dialogView.findViewById(R.id.job);

    builder.setPositiveButton(
        R.string.ok,
        new DialogInterface.OnClickListener() {
          public void onClick(DialogInterface dialog, int id) {
            nameEditText.getText();
            jobEditText.getText().toString().trim();
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
}
