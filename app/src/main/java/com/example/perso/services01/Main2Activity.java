package com.example.perso.services01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    EditText Taqs;
    TextView ListaPosts;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ListaPosts = findViewById(R.id.listaDePosts);
        Taqs = findViewById(R.id.taqs);

    }
    public void getPost(View v){
        String taqsDeBusqueda = Taqs.getText().toString();
        try {
            FileInputStream is = openFileInput("Posts.json");
            String result = IOHelper.stringFromStream(is);

            JSONArray posts = new JSONArray(result);
            if (!taqsDeBusqueda.equals("")) {
                ArrayList<String> listTaqsDeBusqueda;
                listTaqsDeBusqueda = IOHelper.StringtoArrayList(taqsDeBusqueda);
                JSONArray listaTaqsBusqueda = new JSONArray(listTaqsDeBusqueda);

                //list post(all)
                JSONArray listaPostSalida = new JSONArray();    //listapost salida
                for (int i = 0; i < posts.length(); i++) {
                    boolean B = true;
                    int j = 0;
                    JSONObject post = posts.getJSONObject(i);
                    JSONArray listaTaqsObject = post.getJSONArray("taqs");
                    while (B && j < listaTaqsObject.length()) {
                        int k = 0;
                        while (B && k < listaTaqsBusqueda.length()) {
                            if (listaTaqsObject.getString(j).equals(listaTaqsBusqueda.getString(k))) {
                                B = false;
                            }
                            k++;
                        }

                        if (!B) {
                            listaPostSalida.put(post);
                        }
                        j++;
                    }
                }
                ListaPosts.setText(listaPostSalida.toString());
            } else {
                ListaPosts.setText(posts.toString());
            }
        }catch (JSONException e) {
                e.printStackTrace();
        }catch (Exception e){

        }
    }

}






