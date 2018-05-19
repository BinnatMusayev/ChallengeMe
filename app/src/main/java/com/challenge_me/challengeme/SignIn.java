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

		getSupportActionBar().hide();



	}

	public void goToSignUp(View view){
		startActivity(new Intent(SignIn.this, SignUp.class));
	}

	public void onLoginClicked(View view){

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        errorMessage = (TextView) findViewById(R.id.errorMessage);

        final Map<String, String> params = new HashMap<>();
        params.put("username", username.getText().toString().trim() );
        params.put("password", password.getText().toString().trim() );

        String url = "http://grp.az/ChallengeMe/user/login";
		final RequestQueue requestQueue = Volley.newRequestQueue(this);
		JsonObjectRequest loginRequest = new JsonObjectRequest(url, new JSONObject(params), new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

				try {
				    finish();
					Intent loggedInActivity = new Intent(SignIn.this, LoggedIn.class);
	                //put id or some data to intentdata
                    loggedInActivity.putExtra("username", response.getJSONObject("data").getString("username"));
                    loggedInActivity.putExtra("sessionId", response.getJSONObject("data").getString("sessionId"));
//                    loggedInActivity.putExtra("username", params.get("username"));
//                    loggedInActivity.putExtra("lname", response.getJSONObject("data").getString("lastname"));
                    startActivity(loggedInActivity);

				} catch (JSONException e) {
					e.printStackTrace();
				}
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
//                errorMessage.setText("Username or Password is not correct");
                error.printStackTrace();
                Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_SHORT).show();
            }
        }){

        };

		requestQueue.add(loginRequest);

	}

	public String getUsernameString(){
	    return username.getText().toString().trim();
    }
}
