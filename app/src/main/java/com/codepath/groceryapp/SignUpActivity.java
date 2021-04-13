package com.codepath.groceryapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.Parse;
import com.parse.SignUpCallback;

public class SignUpActivity extends AppCompatActivity {
    public static final String TAG = "SignUpActivity";

    private EditText etUsername;
    private EditText etPassword;
    private EditText etPassword2;
    private Button btnSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        etPassword2 = findViewById(R.id.etPassword2);
        btnSignUp = findViewById(R.id.btnSignUp);

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // on below line we are getting data from our edit text.
                String userName = etUsername.getText().toString();
                String password = etPassword.getText().toString();
                String password2 = etPassword2.getText().toString();

                // checking if the entered text is empty or not.
                if (TextUtils.isEmpty(userName) || TextUtils.isEmpty(password)) {
                    Toast.makeText(SignUpActivity.this, "Please enter user name and password", Toast.LENGTH_SHORT).show();
                    return;
                }
                else if (TextUtils.equals(password, password2)){
                    // calling a method to register a user.
                    registerUser(userName, password);
                }
                else{
                    Toast.makeText(SignUpActivity.this, "Password miss match", Toast.LENGTH_SHORT).show();
                    return;
                }
            }
        });
    }
    private void registerUser(String userName, String password) {

        // on below line we are creating
        // a new user using parse user.
        ParseUser user = new ParseUser();

        // Set the user's username and password,
        // which can be obtained from edit text
        user.setUsername(userName);
        user.setPassword(password);

        // calling a method to register the user.
        user.signUpInBackground(new SignUpCallback() {
            @Override
            public void done(ParseException e) {
                // on user registration checking if
                // the error is null or not.
                if (e == null) {
                    // if the error is null we are displaying a toast message and
                    // redirecting our user to new activity and passing the user name.
                    Toast.makeText(SignUpActivity.this, "User Registered succesfully", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(SignUpActivity.this, MainActivity.class);
                    i.putExtra("username", userName);
                    startActivity(i);
                } else {
                    // if we get any error then we are logging out
                    // our user and displaying an error message
                    ParseUser.logOut();
                    Toast.makeText(SignUpActivity.this, "Fail to Register User..", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}