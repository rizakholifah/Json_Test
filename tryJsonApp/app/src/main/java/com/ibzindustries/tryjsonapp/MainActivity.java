package com.ibzindustries.tryjsonapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView tvName, tvAge, tvGender;
    private ListView lvAddress;
    private Person person;
    private ArrayList<Alamat> alamats = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initial();
        generelizeJson();

        adapterAlamat adapter = new adapterAlamat(this,person.getAlamats());
        lvAddress.setAdapter(adapter);

    }

    public void initial(){
        tvName = findViewById(R.id.tv_name);
        tvAge = findViewById(R.id.tv_age);
        tvGender = findViewById(R.id.tv_gender);
        lvAddress = findViewById(R.id.lv_address);
    }

    public void generelizeJson(){
        String json = loadJSONFromRaw();

        try {
            JSONObject jsonObject = new JSONObject(json);

            JSONObject jsonPerson = jsonObject.getJSONObject("person");
            String nama = jsonPerson.getString("name");
            String age = jsonPerson.getString("age");
            String gender = jsonPerson.getString("gender");

            JSONArray jsonArray = jsonPerson.getJSONArray("address");
            for (int j=0;j<jsonArray.length();j++){
                JSONObject jsonAddress = jsonArray.getJSONObject(j);
                String namaAlamat = jsonAddress.getString("nameAddress");
                String detailAlamat = jsonAddress.getString("addressDetail");
                String kota = jsonAddress.getString("city");

                Alamat alamat = new Alamat(namaAlamat,detailAlamat,kota);
                alamats.add(alamat);

            }

            person = new Person(nama,age,gender, alamats);

            tvName.setText(person.getNama());
            tvAge.setText(String.valueOf(person.getUmur()));
            tvGender.setText(person.getGender());

        }catch (JSONException ex){
            ex.printStackTrace();
        }
    }

    public String loadJSONFromRaw() {
        String json = null;
        try {
            InputStream is = getResources().openRawResource(R.raw.data);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}
