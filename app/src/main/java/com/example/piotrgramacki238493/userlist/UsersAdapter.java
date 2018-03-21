package com.example.piotrgramacki238493.userlist;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Locale;

/**
 * Created by Piotrek on 2018-03-21.
 */

public class UsersAdapter extends ArrayAdapter<User> {
    private ItemButtonListener buttonListener;

    public interface ItemButtonListener {
        public void onButtonClickListener(int position);
    }

    public void setItemButtonListener(ItemButtonListener listener) {
        this.buttonListener = listener;
    }

    public UsersAdapter(@NonNull Context context, @NonNull ArrayList<User> users) {
        super(context, 0, users);
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        User user = getItem(position);

        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.activity_main_listview_item, parent, false);
        }
        TextView tvName = convertView.findViewById(R.id.item_name1);
        TextView tvAge = convertView.findViewById(R.id.item_age);
        ImageButton btnRemove = convertView.findViewById(R.id.remove_button);

        tvName.setText(String.format(Locale.getDefault(), "%s %s",user.getName(), user.getSurname()));
        tvAge.setText(user.getAge());

        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (buttonListener != null)
                    buttonListener.onButtonClickListener(position);
            }
        });

        return convertView;
    }
}
