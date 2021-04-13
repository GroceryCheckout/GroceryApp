package com.codepath.groceryapp;

import android.app.Application;

import com.parse.Parse;

public class ParseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("gWh9etyCkS2MWvreDzJwZcE4gND3qRsyJs7NJdgA") // should correspond to Application Id env variable
                .clientKey("oIzfaYO6zMWwtLUf9Yc2J0cilxuaajViZdqAwHMy")  // should correspond to Client key env variable
                .server("https://parseapi.back4app.com")
                .build());
    }
}
