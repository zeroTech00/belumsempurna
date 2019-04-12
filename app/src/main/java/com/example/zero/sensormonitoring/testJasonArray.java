package com.example.zero.sensormonitoring;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zero.sensormonitoring.Adapter.DataBaseListAdapter;
import com.example.zero.sensormonitoring.Database.DatabaseHelper;
import com.example.zero.sensormonitoring.GetSetDataVariabel.variabelList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class testJasonArray extends AppCompatActivity {

    TextView tvJasonArray;
    Button btnJSONshow;

    private DataBaseListAdapter adapterList;
    private ListView listView;

    DatabaseHelper mDB;

    boolean suksesDatabase = false;


    String data;
    String saveIDServer, saveSensor1, saveSensor2, saveSensor3, saveSensor4, saveTanggal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_jason_array);

        mDB = new DatabaseHelper(this);
        adapterList = new DataBaseListAdapter(this);

        listView = findViewById(R.id.listView_test);
        listView.setAdapter(adapterList);

        tvJasonArray = findViewById(R.id.txt_jsonarray);
        btnJSONshow = findViewById(R.id.btn_SHOWtestJason);

        data = getResources().getString(R.string.data);

        tvJasonArray.setText(data);

        try{
            JSONArray jsonArray = new JSONArray(data);
            for(int i=0; i<jsonArray.length(); i++){
                JSONObject objID = jsonArray.getJSONObject(i);

                saveIDServer    = objID.getString("id");
                saveSensor1     = objID.getString("sensor1");
                saveSensor2     = objID.getString("sensor2");
                saveSensor3     = objID.getString("sensor3");
                saveSensor4     = objID.getString("sensor4");
                saveTanggal     = objID.getString("tanggal");

                suksesDatabase = mDB.insertData(saveIDServer, saveSensor1, saveSensor2, saveSensor3, saveSensor4, saveTanggal);

                Log.d("parser",saveIDServer);
                Log.d("parser",saveSensor1);
                Log.d("parser",saveSensor2);
                Log.d("parser",saveSensor3);
                Log.d("parser",saveSensor4);
                Log.d("parser",saveTanggal);
            }


        }catch (JSONException e){
            e.printStackTrace();
        }

        if(suksesDatabase) {
            showToast("data berhasil disimpan");
        } else {
            showToast("data gagal disimpan");
        }

        addItem();

    }

    private void addItem() {
        Cursor data = mDB.getData();
        ArrayList<variabelList> variabelLists = new ArrayList<>();


        while(data.moveToNext()) {
            variabelList vl = new variabelList();
            vl.setIDServer(data.getString(1));
            vl.setSensor1(data.getString(2));
            vl.setSensor2(data.getString(3));
            vl.setSensor3(data.getString(4));
            vl.setSensor4(data.getString(5));
            vl.setTanggal(data.getString(6));

            variabelLists.add(vl);
        }

        adapterList.setVariabelLists(variabelLists);
    }

    private void showToast(String text) {
        Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();
    }



}
