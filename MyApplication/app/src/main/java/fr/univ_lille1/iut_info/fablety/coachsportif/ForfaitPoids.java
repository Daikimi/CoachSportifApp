package fr.univ_lille1.iut_info.fablety.coachsportif;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;

/**
 * Created by fablety on 23/03/17.
 */

public class ForfaitPoids extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forfaitpoids);

        ImageView iv = (ImageView) findViewById(R.id.imageView5);
        String path ="android.resource://fr.univ_lille1.iut_info.fablety.coachsportif/"+R.raw.pertedepoid;
        Uri uri = Uri.parse(path);
        iv.setImageURI(uri);

    }
}
