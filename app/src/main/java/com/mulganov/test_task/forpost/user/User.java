package com.mulganov.test_task.forpost.user;

import android.content.Intent;
import android.graphics.Bitmap;

import com.mulganov.test_task.forpost.helper.Helper;
import com.mulganov.test_task.forpost.rest.Post;

import java.io.File;

public class User {

    private Bitmap bitmap;
    private String name;
    private String email;
    private String phone;
    private String gender;
    private String age;
    private File img;

    public User(){

    }

    public User(final File dir, final Post.Results results){
        name = results.name.first + " " + results.name.last;
        email = results.email;
        phone = results.phone;
        gender = results.gender;
        age = results.dob.age;

        img = new File("/" + dir +"/"+ name + ".jpg");

        bitmap = Helper.loadBitmap(results.picture.large, img + "");

    }

    public User(Intent intent){
        name = intent.getStringExtra("name");
        age = intent.getStringExtra("age");
        email = intent.getStringExtra("email");
        gender = intent.getStringExtra("gender");
        phone = intent.getStringExtra("phone");

        img = new File(intent.getStringExtra("image"));

        bitmap = Helper.loadBitmap(img);
    }


    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public File getImg() {
        return img;
    }

    public void setImg(File img) {
        this.img = img;
    }
}
