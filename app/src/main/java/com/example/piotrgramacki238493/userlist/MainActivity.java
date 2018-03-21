package com.example.piotrgramacki238493.userlist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements UsersAdapter.ItemButtonListener {
    public static int RESULT_OK = 0;
    private static int ADD_USER = 1;

    private ArrayList<User> users;
    private UsersAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        users = new ArrayList<>();
        adapter = new UsersAdapter(this, users);

        ListView listView = findViewById(R.id.list);
        adapter.setItemButtonListener(this);
        listView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_activity_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_add:
                final Intent addIntent = new Intent(this, InputDataActivity.class);
                startActivityForResult(addIntent, ADD_USER);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ADD_USER) {
            if (resultCode == RESULT_OK) {
                String userName = data.getStringExtra("userName");
                String userSurname = data.getStringExtra("userSurname");
                String userAge = data.getStringExtra("userAge");

                addUser(userName, userSurname, userAge);
            }
        }
    }

    private void addUser(String name, String surname, String date) {
        User user = new User(name, surname, date);
        users.add(user);
    }

    @Override
    public void onButtonClickListener(int position) {
        users.remove(position);
        adapter.notifyDataSetChanged();
    }
}
