package com.challenge_me.challengeme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
	private TextView dontHaveAccountText;
	private boolean loggedIn;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
//		setContentView(R.layout.activity_main);
		setContentView(R.layout.activity_sign_in);

		dontHaveAccountText = (TextView) findViewById(R.id.dontHaveAccountText);
		dontHaveAccountText.setText("Don't have an account yet?");

		loggedIn = false;

		if(loggedIn){
			//go to profile
		}else{
			startActivity(new Intent(MainActivity.this, SignIn.class));
		}

	}

	public void goToSignUp(View view){
		startActivity(new Intent(MainActivity.this, SignUp.class));
	}
}
