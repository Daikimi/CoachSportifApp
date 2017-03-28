package fr.univ_lille1.iut_info.fablety.coachsportif;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;

import java.lang.reflect.Type;
import java.util.ArrayList;


/**
 * Created by fablety on 27/03/17.
 */

public class Connect extends Activity {


    String url="http://172.18.49.152:8080/v1/user/";
    GsonBuilder jsonBuild = new GsonBuilder();
    User user ;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.connect);

        user = AppSingleton.getUser();
        if (user!=null ) {

                finish();

            //System.out.println(user.toString());

        }
        /*if (user==null){
            finish();
        }*/
    }

    public void onClick(View view){
        TextView iden= (TextView) findViewById(R.id.jl_Reichmann);
        TextView passwd= (TextView) findViewById(R.id.password);

        String nom= iden.getText().toString();
        String pass= passwd.getText().toString();

        System.out.println(nom);

        if(nom.equals("") ||nom==null ){
            Toast.makeText(getBaseContext(), "Pas d'identifiant", Toast.LENGTH_SHORT).show();
            return;
        }else{
            url += nom;
        }
        if(pass.equals("") ||pass==null){
            Toast.makeText(getBaseContext(), "Pas de mot de passe", Toast.LENGTH_SHORT).show();
            return;
        }

        StringRequest stringRequest = new StringRequest(Request.Method.GET,url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        //User user = jsonBuild.create().fromJson(response, User.class);
                        // Result handling

                        User user = jsonBuild.create().fromJson(response,User.class);

                         AppSingleton.setUser(user);



                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                // Error handling
                System.out.println("Something went wrong!");
                Toast.makeText(getBaseContext(), "Profil inexistant", Toast.LENGTH_LONG).show();
                //error.printStackTrace();

            }
        });

        Volley.newRequestQueue(this).add(stringRequest);
        AppSingleton app = AppSingleton.getInstance(new User());
        setResult(Activity.RESULT_OK);
        finish();

    }


}
