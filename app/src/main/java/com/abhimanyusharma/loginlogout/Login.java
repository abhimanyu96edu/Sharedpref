package com.abhimanyusharma.loginlogout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    EditText name,email,pass;
    Button login;
    Intent intent;

    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String Name = "nameKey";
    public static final String Password = "passKey";
    public static final String Email = "emailKey";

    SharedPreferences sharedpreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        name= (EditText) findViewById(R.id.name);
        email= (EditText) findViewById(R.id.email);
        pass= (EditText) findViewById(R.id.pass);

        login= (Button) findViewById(R.id.login);

        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        //editor = sharedpreferences.edit();

        if(sharedpreferences.contains(Email))
        {
            String getEmailStatus=sharedpreferences.getString(Email, "nil");
            String getPasswordStatus=sharedpreferences.getString(Password, "nil");
            String getNameStatus=sharedpreferences.getString(Name, "nil");
            email.setText(getEmailStatus);
            pass.setText(getPasswordStatus);
            name.setText(getNameStatus);
        }

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user=name.getText().toString();
                String mail=email.getText().toString();
                String password=pass.getText().toString();

                if (user.trim().equals("admin") && password.trim().equals("admin")){


                    editor = sharedpreferences.edit();
                    editor.putString(Name,user);
                    editor.putString(Password,password);
                    editor.putString(Email,mail);
                    editor.putString(Name,user);
                    editor.apply();

                    intent=new Intent(Login.this,Logout.class);
                    startActivity(intent);

                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Invalid Credentials",Toast.LENGTH_LONG).show();
                }

            }
        });



    }
}



