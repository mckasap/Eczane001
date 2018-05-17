package org.kasapbasi.eczane001;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;
import java.util.jar.Manifest;

public class MainActivity extends AppCompatActivity {

    List<ilce> ilceler = new ArrayList<>();

    Spinner spn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spn = (Spinner) findViewById(R.id.spinner);


        spn.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {
                Toast.makeText(MainActivity.this, parent.getItemAtPosition(i).toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }


        });
        myAscTask asc = new myAscTask();
        asc.execute();

    }


    public class myAscTask extends AsyncTask<Void, Void, Void> {


        @Override
        protected Void doInBackground(Void... voids) {

            try {
                Document doc = Jsoup.connect("http://apps.istanbulsaglik.gov.tr/eczane").get();

                Log.d("TEST-->", doc.title());

                Elements ilceHTML = doc.select(".ilce-link");

                for (Element a : ilceHTML)
                    ilceler.add(new ilce(a.attr("title"),"",""));

            } catch (Exception ex) {

            }

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            MainActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    ArrayAdapter<ilce> spinnerAdapter = new ArrayAdapter<ilce>(MainActivity.this, android.R.layout.simple_spinner_item, ilceler);
                    spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spn.setAdapter(spinnerAdapter);
                    spinnerAdapter.notifyDataSetChanged();
                }
            });

            super.onPostExecute(aVoid);
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }
    }
}
