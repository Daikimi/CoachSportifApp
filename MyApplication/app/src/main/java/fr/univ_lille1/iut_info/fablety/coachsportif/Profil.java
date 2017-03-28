package fr.univ_lille1.iut_info.fablety.coachsportif;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

/**
 * Created by fablety on 27/03/17.
 */

public class Profil extends Activity {
    User user = AppSingleton.getUser();
    TextView tv1;
    TextView tv2;
    TextView tv3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profil);
        System.out.println(user);
        if (user==null){
            Intent intent = new Intent(Profil.this,Connect.class);
            startActivity(intent);
            user=AppSingleton.getUser();
        }else{
             tv1= (TextView) findViewById(R.id.ident);
            tv2= (TextView) findViewById(R.id.nom);
             tv3 = (TextView) findViewById(R.id.alias);
            tv1.setText("Id "+user.id);
            tv2.setText("Nom: "+user.name);
            tv3.setText("Alias: "+user.alias);
        }

    }




    @Override
    protected void onRestart() {
        super.onResume();


        user= AppSingleton.getUser();
        //System.out.println(user);
        if(user==null){
            System.out.println("Cassoulet");
        }else {

            //System.out.println(user.toString());
            tv1 = (TextView) findViewById(R.id.ident);
            tv2 = (TextView) findViewById(R.id.nom);
            tv3 = (TextView) findViewById(R.id.alias);
            tv1.setText("Id: " + user.id);
            tv2.setText("Nom: " + user.name);
            tv3.setText("Alias:  " + user.alias);
        }
        refresh();
    }


    public void OnActivityResult(int requestCode, int resultCode, Intent data){

    }

    public void refresh(){
        recreate();
    }
}
