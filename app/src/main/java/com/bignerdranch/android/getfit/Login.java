package com.bignerdranch.android.getfit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    private static EditText username;
    private static EditText password;
    private static TextView attempt;
    private static Button login_button;
    int attempt_counter = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        LoginButton();
    }

    public void LoginButton() {
        username = (EditText)findViewById(R.id.editText_user);
        password = (EditText)findViewById(R.id.editText_password);
        attempt = (TextView)findViewById(R.id.textView_attempt_count);
        login_button = (Button)findViewById(R.id.button_login);

        attempt.setText(Integer.toString(attempt_counter));

        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (username.getText().toString().equals("jdoe") &&
                        password.getText().toString().equals("welcome1")) {
                    Toast.makeText(Login.this, "Username and/or password is correct",
                            Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent("com.bignerdranch.android.getfit.User");
                    startActivity(intent);
                } else {
                    Toast.makeText(Login.this, "Username and/or password is NOT correct",
                            Toast.LENGTH_SHORT).show();
                    attempt_counter--;}
                    attempt.setText(Integer.toString(attempt_counter));

                    if (attempt_counter == 0)
                        login_button.setEnabled(false);
                }


        });
    }


}
