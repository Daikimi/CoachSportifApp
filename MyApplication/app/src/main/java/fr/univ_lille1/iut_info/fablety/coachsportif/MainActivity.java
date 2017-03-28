package fr.univ_lille1.iut_info.fablety.coachsportif;

import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.text.Layout;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.GridView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.android.volley.Response;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    /*private GridView gridView;
    private GaleriePhotos gridAdapter;*/






    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Add the request to the RequestQueue.


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        Button rea = (Button) findViewById(R.id.reathletisation);
        Button cn = (Button) findViewById(R.id.conseils_nutri);
        Button cd = (Button) findViewById(R.id.home_coaching);
        Button fpp = (Button) findViewById(R.id.perte_poids);
        Button pp = (Button) findViewById(R.id.prepa_physique);
        Button au = (Button) findViewById(R.id.autre);

        /*Listener sur boutons */

        rea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Reathletisation.class);
                startActivity(intent);
            }
        });

        cn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(fr.univ_lille1.iut_info.fablety.coachsportif.MainActivity.this, ConseilsNutri.class);
                startActivity(intent);
            }
        });

        cd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(fr.univ_lille1.iut_info.fablety.coachsportif.MainActivity.this, CoachingDomicile.class);
                startActivity(intent);
            }
        });


        fpp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(fr.univ_lille1.iut_info.fablety.coachsportif.MainActivity.this, ForfaitPoids.class);
                startActivity(intent);
            }
        });


        pp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(fr.univ_lille1.iut_info.fablety.coachsportif.MainActivity.this, PrepaPhysique.class);
                startActivity(intent);
            }
        });


        au.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(fr.univ_lille1.iut_info.fablety.coachsportif.MainActivity.this, Autre.class);
                startActivity(intent);
            }
        });

        /*gridView = (GridView) findViewById(R.id.gridView);
        gridAdapter = new GaleriePhotos(this, R.layout.grid_item_layout, getData());*/

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        Intent sendIntent;
        int id = item.getItemId();

          if (id == R.id.nav_tarifs) {

            sendIntent = new Intent(MainActivity.this,Tarifs.class);
            startActivity(sendIntent);

        } else if (id == R.id.nav_galerie) {

        } else if(id == R.id.nav_options) {

        } else if(id == R.id.nav_share) {
              sendIntent = new Intent();
              sendIntent.setAction(Intent.ACTION_SEND);
              sendIntent.putExtra(Intent.EXTRA_TEXT, "This is my text to send.");
              sendIntent.setType("text/plain");
              startActivity(sendIntent);


          }else if(id == R.id.connect){
              sendIntent = new Intent(MainActivity.this,Connect.class);
              startActivity(sendIntent);
          }else if(id== R.id.nav_profil){
              sendIntent = new Intent(MainActivity.this,Profil.class);
              startActivity(sendIntent);
          }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
/*
    private ArrayList<ImageItem> getData() {
        final ArrayList<ImageItem> imageItems = new ArrayList<>();
        TypedArray imgs = getResources().obtainTypedArray(R.);
        for (int i = 0; i < imgs.length(); i++) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), imgs.getResourceId(i, -1));
            imageItems.add(new ImageItem(bitmap, "Image#" + i));
        }
        return imageItems;
    }*/

    /*http://stackoverflow.com/questions/27077878/how-to-create-scrollable-page-of-carousels-in-android*/
    /*Pour faire un carousel d'images */
}
