package com.mulganov.test_task.forpost.user;

import com.mulganov.test_task.forpost.rest.Post;

import java.io.File;
import java.util.ArrayList;

public class Users {
    public static ArrayList<User> getUsers(Post post, File dir){
        ArrayList<User> a = new ArrayList<>();

        for (Post.Results results: post.results){
            a.add(new User(dir, results));
        }

        return a;
    }
}
