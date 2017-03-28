package fr.univ_lille1.iut_info.fablety.coachsportif;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by fablety on 23/03/17.
 */

public class Autre extends Activity {

    public TextView outputTextView;
    public TextView modif;


    String urlevent = "http://172.18.49.152:8080/v1/event/";
    String urlUser = "http://172.18.49.152:8080/v1/user/";
    GsonBuilder jsonBuild = new GsonBuilder();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.autre);
        outputTextView =(TextView) findViewById(R.id.textout);

        // Request a string response
        StringRequest stringRequest = new StringRequest(Request.Method.GET, urlUser,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        //User user = jsonBuild.create().fromJson(response, User.class);
                        // Result handling
                        JSONArray array;
                        ArrayList<Event> l;
                        Type listType = new TypeToken<ArrayList<Event>>(){}.getType();
                        outputTextView.setText(response);
                        //String test = user.toString();
                        try {
                            array = new JSONArray(response);
                            l= jsonBuild.create().fromJson(String.valueOf(array), listType);
                            System.out.println(l.size());

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }



                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                // Error handling
                System.out.println("Something went wrong!");
                outputTextView.setText("NOPE");
                error.printStackTrace();

            }
        });

        Volley.newRequestQueue(this).add(stringRequest);



    }






}
