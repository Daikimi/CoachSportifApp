package fr.univ_lille1.iut_info.fablety.coachsportif;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.net.URI;

/**
 * Created by fablety on 23/03/17.
 */

public class Reathletisation  extends Activity {


        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.reathletisation);


            ImageView iv = (ImageView) findViewById(R.id.imageView2);
            String path ="android.resource://fr.univ_lille1.iut_info.fablety.coachsportif/"+R.raw.reatheli;
            Uri uri = Uri.parse(path);
            iv.setImageURI(uri);
    }
}
