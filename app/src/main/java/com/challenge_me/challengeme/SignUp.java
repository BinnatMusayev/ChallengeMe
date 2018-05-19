package com.challenge_me.challengeme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class SignUp extends AppCompatActivity {
	TextView haveAnAccountText;
	private EditText registerEmail;
    private EditText registerUsername;
    private EditText registerPassword;
    private EditText registerConfirmPassword;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sign_up);

		registerEmail = (EditText) findViewById(R.id.registerEmail);
        registerUsername = (EditText) findViewById(R.id.registerUsername);
        registerPassword = (EditText) findViewById(R.id.registerPassword);
        registerConfirmPassword = (EditText) findViewById(R.id.registerConfirmPassword);

		haveAnAccountText = (TextView) findViewById(R.id.haveAnAccountText);
		haveAnAccountText.setText("Already have an account?");


		getSupportActionBar().hide();

	}

	public void goToSignIn(View view){
		startActivity(new Intent(SignUp.this, SignIn.class));
	}

	public void onRegisterClicked(View v){

        Map<String, String> params = new HashMap<>();
        params.put("email", registerEmail.getText().toString().trim() );
        params.put("username", registerUsername.getText().toString().trim() );
        params.put("password", registerPassword.getText().toString().trim() );

        String url = "http://grp.az/ChallengeMe/user/register";
        final RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonObjectRequest registerRequest = new JsonObjectRequest(url, new JSONObject(params), new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
//                try {
                    finish();
                    Intent loggedInActivity = new Intent(SignUp.this, LoggedIn.class);
                    //put id or some data to intentdata
                    loggedInActivity.putExtra("username", registerUsername.getText().toString().trim() );
//                    loggedInActivity.putExtra("lname", response.getJSONObject("data").getString("lastname"));
                    startActivity(loggedInActivity);

//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "wrong register", Toast.LENGTH_SHORT).show();
            }
        }){

        };

        if (registerPassword.getText().toString().equals(registerConfirmPassword.getText().toString())){
            requestQueue.add(registerRequest);
        }else{
            Toast.makeText(getApplicationContext(), "password and confirm are not same", Toast.LENGTH_LONG).show();
        }

    }
}
