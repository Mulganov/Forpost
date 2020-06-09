package com.mulganov.test_task.forpost.rest;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Post {
    @SerializedName("results")
    @Expose
    public ArrayList<Results> results;

    public static class Results{
        @SerializedName("gender")
        @Expose
        public String gender;
        @SerializedName("name")
        @Expose
        public Name name;
        @SerializedName("picture")
        @Expose
        public Picture picture;
        @SerializedName("dob")
        @Expose
        public Dob dob;
        @SerializedName("phone")
        @Expose
        public String phone;
        @SerializedName("email")
        @Expose
        public String email;


        public static class Dob{
            @SerializedName("age")
            @Expose
            public String age;

        }

        public static class Picture{
            @SerializedName("large")
            @Expose
            public String large;

        }

        public static class Name{
            @SerializedName("title")
            @Expose
            public String title;
            @SerializedName("first")
            @Expose
            public String first;
            @SerializedName("last")
            @Expose
            public String last;

        }
    }
}