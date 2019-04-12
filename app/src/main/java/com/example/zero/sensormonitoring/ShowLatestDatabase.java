package com.example.zero.sensormonitoring;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.example.zero.sensormonitoring.Adapter.DataBaseListAdapter;
import com.example.zero.sensormonitoring.Database.DatabaseHelper;

public class ShowLatestDatabase extends AppCompatActivity {

    TextView tvID, tvIDServer, tvSensor1, tvSensor2, tvSensor3, tvSensor4, tvTanggal;

    private DataBaseListAdapter adapterList;
    final static String TABLE_NAME = "dataSensor";
    SQLiteDatabase db;
    DatabaseHelper mDB;
    int id,i;
    int[] a;

    String convert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_latest_database);

        mDB = new DatabaseHelper(this);

        tvID            = findViewById(R.id.txt_idLatest);
        tvIDServer      = findViewById(R.id.txt_idServerLatest);
        tvSensor1       = findViewById(R.id.txt_sensor1Latest);
        tvSensor2       = findViewById(R.id.txt_sensor2Latest);
        tvSensor3       = findViewById(R.id.txt_sensor3Latest);
        tvSensor4       = findViewById(R.id.txt_sensor4Latest);
        tvTanggal       = findViewById(R.id.txt_TanggalLatest);

        Cursor data = mDB.getData();

        

//        while(data.moveToNext()) {
//            i++;
//            a[i] = data.getInt(0);
//
//
//            convert = Integer.toString(a[i]);
//            Log.d("data", convert);
//        }
//
//        int z = a.length();



//        tvID.setText(data.getString(0));
//        tvIDServer.setText(data.getString(1));
//        tvSensor1.setText(data.getString(2));
//        tvSensor2.setText(data.getString(3));
//        tvSensor3.setText(data.getString(4));
//        tvSensor4.setText(data.getString(5));
//        tvTanggal.setText(data.getString(6));

    }
}
