package com.challenge_me.challengeme;

import android.app.ActionBar;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Map;


public class CreateChallenge extends AppCompatActivity {

    private static  final int PICK_IMAGE = 100;
    Uri imageUri;
    private Bitmap bitmap;

    private ImageView challengeItem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_challenge);


        //actionbar
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.action_bar_layout);
        TextView textViewTitle = (TextView) findViewById(R.id.title);
        textViewTitle.setText(R.string.title);

        //back button enable
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        challengeItem = (ImageView) findViewById(R.id.creator_photo);
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                this.finish();
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void addChallengeItem(View view){
        Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(gallery, PICK_IMAGE);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK && requestCode == PICK_IMAGE ){
            imageUri = data.getData();
            challengeItem.setImageURI(imageUri);
            try {
                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), imageUri);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

    public String getStringImage(Bitmap bmp){
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] imageBytes = baos.toByteArray();
        String encodedImage = Base64.encodeToString(imageBytes, Base64.DEFAULT);
        return encodedImage;
    }

    public void createChallengeClicked(View v){
        //Showing the progress dialog
//        String url = "http://grp.az/ChallengeMe/challenge/add";
//        final ProgressDialog loading = ProgressDialog.show(this,"Uploading...","Please wait...",false,false);
//        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
//                new Response.Listener<String>() {
//                    @Override
//                    public void onResponse(String s) {
//                        //Disimissing the progress dialog
//                        loading.dismiss();
//                        //Showing toast message of the response
//                        Toast.makeText(CreateChallenge.this, "created" , Toast.LENGTH_LONG).show();
//                    }
//                },
//                new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError volleyError) {
//                        //Dismissing the progress dialog
//                        loading.dismiss();
//
//                        //Showing toast
//                        Toast.makeText(CreateChallenge.this, volleyError.getMessage().toString(), Toast.LENGTH_LONG).show();
//                    }
//                }){
//            @Override
//            protected Map<String, String> getParams() throws AuthFailureError {
//                //Converting Bitmap to String
//                String image = getStringImage(bitmap);
//
//                //Getting Image Name
//
//
//                //Creating parameters
//                Map<String,String> params = new Hashtable<String, String>();
//
//                //Adding parameters
//                params.put("sessionId", getIntent().getStringExtra("sessionId"));
//                params.put("photo", image);
//
//                //returning parameters
//                return params;
//            }
//        };
//
//        //Creating a Request Queue
//        RequestQueue requestQueue = Volley.newRequestQueue(this);
//
//        //Adding request to the queue
//        requestQueue.add(stringRequest);
    }
}
