package com.mulganov.test_task.forpost.ui.user;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.mulganov.test_task.forpost.R;
import com.mulganov.test_task.forpost.ui.main.user.User;

public class UserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        User user = new User(getIntent());

        ((ImageView)findViewById(R.id.image)).setImageBitmap(user.getBitmap());

        ((TextView)findViewById(R.id.name)).setText(user.getName());
        ((TextView)findViewById(R.id.age)).setText(user.getAge());
        ((TextView)findViewById(R.id.phone)).setText(user.getPhone());
        ((TextView)findViewById(R.id.email)).setText(user.getEmail());
        ((TextView)findViewById(R.id.gender)).setText(user.getGender());

    }



}
