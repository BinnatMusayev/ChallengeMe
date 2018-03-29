package com.challenge_me.challengeme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SignIn extends AppCompatActivity {
	TextView dontHaveAccountText, errorMessage;
	EditText username, password;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sign_in);

		setContentView(R.layout.activity_sign_in);

		dontHaveAccountText = (TextView) findViewById(R.id.dontHaveAccountText);
		dontHaveAccountText.setText("Don't have an account yet?");



	}

	public void goToSignUp(View view){
		startActivity(new Intent(SignIn.this, SignUp.class));
	}

	public void onLoginClicked(View view){
		username = (EditText) findViewById(R.id.username);
		password = (EditText) findViewById(R.id.password);
		errorMessage = (TextView) findViewById(R.id.errorMessage);

		if(!username.getText().toString().equals("") || !password.getText().toString().equals("") ){
			if(username.getText().toString().equals("user") && password.getText().toString().equals("pass")){
				//go to profile
				errorMessage.setText("Correct");
				startActivity(new Intent(SignIn.this, LoggedIn.class));
			}else{
				errorMessage.setText("Username or Password is not correct");
			}
		}else{
			errorMessage.setText("Username or Password is empty");
		}

	}
}
