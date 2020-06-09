package com.mulganov.test_task.forpost.ui.main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import com.mulganov.test_task.forpost.R;
import com.mulganov.test_task.forpost.ui.main.user.User;
import com.mulganov.test_task.forpost.ui.user.UserActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private MainPresent present;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        present = new MainPresent(this);
    }

    public void relaodList(ArrayList<User> list){
        final BoxAdapter adapter = new BoxAdapter(this, list, present);

        findViewById(R.id.list).post(new Runnable() {
            @Override
            public void run() {
                ((ListView)findViewById(R.id.list)).setAdapter(adapter);
            }
        });
    }

    public void openUserActivity(User user){
        Intent intent = new Intent(this, UserActivity.class);
        intent.putExtra("name", user.getName());
        intent.putExtra("age", user.getAge());
        intent.putExtra("email", user.getEmail());
        intent.putExtra("gender", user.getGender());
        intent.putExtra("phone", user.getPhone());

        System.out.println("image: " + user.getImg() + "");
        intent.putExtra("image", user.getImg() + "");

        startActivity(intent);
    }

}
