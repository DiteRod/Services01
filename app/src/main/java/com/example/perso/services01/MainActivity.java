package com.example.perso.services01;

import android.content.Intent;
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


public class MainActivity extends AppCompatActivity {

    EditText titulo;
    EditText descripcion;
    EditText taqs;
    TextView texto;
    JSONArray arr = new JSONArray();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        titulo = (EditText) findViewById(R.id.title);
        descripcion = (EditText) findViewById(R.id.descripcion);
        taqs = (EditText) findViewById(R.id.taqs);
        texto = (TextView) findViewById(R.id.jsontext);

    }

    public void addPost(View v) {
        String title = titulo.getText().toString();
        String description = descripcion.getText().toString();
        String taqq = taqs.getText().toString();
        ArrayList<String> taq;
        taq = IOHelper.StringtoArrayList(taqq);
        Post post = new Post(title, description, taq);
        try {
            JSONArray listaTaqs = new JSONArray(post.getTaqs());
            JSONObject obj = new JSONObject();
            obj.put("titulo",post.getTitulo());
            obj.put("descripcion",post.getDescripcion());
            obj.put("taqs",listaTaqs);
            arr.put(obj);

        }catch(JSONException e){}
        IOHelper.writeToFile(this, "Posts.json", arr.toString());
    }
    /*public  void Leer(View view){
        try {
            FileInputStream is = openFileInput("Posts.json");
            String result = IOHelper.stringFromStream(is);
            texto.setText(result);
            JSONArray posts = new JSONArray(result);

            String res = "";
            for (int i = 0; i < posts.length(); i++) {
                JSONObject post = posts.getJSONObject(i);

                res += "titulo : " + post.getString("titulo") + "\n" +
                        "descripcion : " + post.getString("descripcion")+ "\n" + post.getJSONArray("taqs");
            }
            texto.setText(res);
        } catch (JSONException e) {
            e.printStackTrace();
        } catch(IOException e){}


    }*/
    /*public void getPost(){


        try{
          FileInputStream is = openFileInput("Posts.json");
          String result = IOHelper.stringFromStream(is);
          JSONArray posts = new JSONArray(result);
          for (int i = 0; i < posts.length(); i++) {
              JSONObject post = posts.getJSONObject(i);
              JSONArray s = post.getJSONArray("taqs");
              for(int j=0; j<s.length();j++){
                  JSONObject taq = s.getJSONObject(j);

              }

          }

      }catch (JSONException e) {
          e.printStackTrace();
      }
      catch(IOException e){}
    }*/
    public void Siguiente(View v){
        Intent I = new Intent(this,Main2Activity.class);
        startActivity(I);


    }
}
