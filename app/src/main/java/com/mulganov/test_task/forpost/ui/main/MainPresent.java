package com.mulganov.test_task.forpost.ui.main;

import com.mulganov.test_task.forpost.rest.NetworkService;
import com.mulganov.test_task.forpost.rest.Post;
import com.mulganov.test_task.forpost.user.User;
import com.mulganov.test_task.forpost.user.Users;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresent {

    MainActivity activity;
    private ArrayList<User> users = new ArrayList<>();

    public MainPresent(MainActivity mainActivity) {
        activity = mainActivity;

        Call<Post> a = NetworkService.getInstance()
                .getJSONApi()
                .getUsers(20);

        a.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                final Post post = response.body();

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        users = Users.getUsers(post, activity.getFilesDir());

                        activity.relaodList(users);
                    }
                }).start();
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {

            }
        });
    }

    public void onClickUser(User user){
        activity.openUserActivity(user);
    }

}
