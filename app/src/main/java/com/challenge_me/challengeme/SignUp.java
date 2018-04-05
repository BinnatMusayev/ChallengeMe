package com.challenge_me.challengeme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SignUp extends AppCompatActivity {
	TextView haveAnAccountText;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sign_up);

		haveAnAccountText = (TextView) findViewById(R.id.haveAnAccountText);
		haveAnAccountText.setText("Already have an account?");


		getSupportActionBar().hide();

	}

	public void goToSignIn(View view){
		startActivity(new Intent(SignUp.this, SignIn.class));
	}
}
