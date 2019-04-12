package com.example.zero.sensormonitoring.Database;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.zero.sensormonitoring.Adapter.DataBaseListAdapter;
import com.example.zero.sensormonitoring.GetSetDataVariabel.variabelList;
import com.example.zero.sensormonitoring.R;

import java.util.ArrayList;
import java.util.Calendar;

public class ShowDatabase extends AppCompatActivity {

    private String[] dataidServer;
    private String[] dataSensor1;
    private String[] dataSensor2;
    private String[] dataSensor3;
    private String[] dataSensor4;
    private String[] dataTanggal;

    private DataBaseListAdapter adapterList;
    private ListView listView;

    DatabaseHelper mDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_database);

        mDB = new DatabaseHelper(this);
        adapterList = new DataBaseListAdapter(this);

        listView = findViewById(R.id.listView_Database);
        listView.setAdapter(adapterList);





        addItem();

//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Toast.makeText(ShowDatabase.this, dataidServer[i], Toast.LENGTH_SHORT).show();
//            }
//        });

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
}
