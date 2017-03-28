package fr.univ_lille1.iut_info.fablety.coachsportif;

import android.app.Activity;
import android.database.MatrixCursor;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

/**
 * Created by fablety on 24/03/17.
 */

public class Tarifs extends Activity {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tarifs);

        // Définition des colonnes
// NB : SimpleCursorAdapter a besoin obligatoirement d'un ID nommé "_id"
        String[] columns = new String[] { "_id", "col1", "col2","col3", "col4" };

// Définition des données du tableau
// les lignes ci-dessous ont pour seul but de simuler
// un objet de type Cursor pour le passer au SimpleCursorAdapter.
// Si vos données sont issues d'une base SQLite,
// utilisez votre "cursor" au lieu du "matrixCursor"


        MatrixCursor matrixCursor= new MatrixCursor(columns);
        startManagingCursor(matrixCursor);
        matrixCursor.addRow(new Object[] { 1,"Tarif à l'heure par personne","Séance individuelle ","2 personnes", "3 personnes" });
        matrixCursor.addRow(new Object[] { 2,"Coaching à domicile","38€","34€","30€" });
        matrixCursor.addRow(new Object[] { 3,"Reathlétisation","38€", "34€","30€" });
        matrixCursor.addRow(new Object[] { 4,"Préparation physique","38€","34€","30€" });
        matrixCursor.addRow(new Object[] { 5,"Forfait perte de poids","40€","36€","32€" });
        matrixCursor.addRow(new Object[] { 6,"Conseils nutritionnels","5€","5€","5€" });

// on prendra les données des colonnes 1 et 2...
        String[] from = new String[] {"col1", "col2", "col3", "col4"};

// ...pour les placer dans les TextView définis dans "row_item.xml"
        int[] to = new int[] { R.id.textViewCol1, R.id.textViewCol2, R.id.textViewCol3, R.id.textViewCol4};

// création de l'objet SimpleCursorAdapter...
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, R.layout.row_item, matrixCursor, from, to, 0);

// ...qui va remplir l'objet ListView
        ListView lv = (ListView) findViewById(R.id.tab);
        lv.setAdapter(adapter);



    }
}
