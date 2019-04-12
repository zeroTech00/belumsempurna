package com.example.zero.sensormonitoring.Database;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zero.sensormonitoring.R;

import java.util.Calendar;
import java.util.TimerTask;

public class CreateDatabase extends AppCompatActivity {

    Button btnCreate;
    EditText edtID, edtSensor1, edtSensor2, edtSensor3, edtSensor4, edtTanggal;
    DatabaseHelper mDB;

    String saveIDServer, saveSensor1, saveSensor2, saveSensor3, saveSensor4, saveTanggal;
    Boolean suksesDatabase = false;

    Calendar kalender;
    int get_kalender_year, get_kalender_month, get_kalender_day;

    DatePickerDialog.OnDateSetListener setListener;
    String tanggalDipilih;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_database);

        mDB = new DatabaseHelper(this);

        btnCreate = findViewById(R.id.btn_CreateDatabase);
        edtID = findViewById(R.id.et_id);
        edtSensor1 = findViewById(R.id.et_sensor1);
        edtSensor2 = findViewById(R.id.et_sensor2);
        edtSensor3 = findViewById(R.id.et_sensor3);
        edtSensor4 = findViewById(R.id.et_sensor4);
        edtTanggal = findViewById(R.id.et_tanggal);

        kalender = Calendar.getInstance();
        get_kalender_day    = kalender.get(Calendar.DAY_OF_MONTH);
        get_kalender_month  = kalender.get(Calendar.MONTH);
        get_kalender_year   = kalender.get(Calendar.YEAR);

        edtTanggal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog dataDatePickerDialog = new DatePickerDialog(
                        CreateDatabase.this,android.R.style.Theme_Holo_Light_Dialog_MinWidth
                        ,
                        setListener,get_kalender_year,get_kalender_month,get_kalender_day);
                dataDatePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dataDatePickerDialog.show();

            }
        });

        setListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month +1;

                if(month < 10) {
                    tanggalDipilih = year + "-0" + month + "-" + dayOfMonth;
                }else {
                    tanggalDipilih = year + "-" + month + "-" + dayOfMonth;
                }

                edtTanggal.setText(tanggalDipilih);


            }
        };



        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    saveIDServer = edtID.getText().toString();
                    saveSensor1 = edtSensor1.getText().toString();
                    saveSensor2 = edtSensor2.getText().toString();
                    saveSensor3 = edtSensor3.getText().toString();
                    saveSensor4 = edtSensor4.getText().toString();
                    saveTanggal = edtTanggal.getText().toString();

                if(saveIDServer.isEmpty() || saveSensor1.isEmpty() || saveSensor2.isEmpty() || saveSensor3.isEmpty() || saveSensor4.isEmpty()
                        || saveTanggal.isEmpty()) {

                    showToast("Isi data dengan lengkap");
                } else {
                    suksesDatabase = mDB.insertData(saveIDServer, saveSensor1, saveSensor2, saveSensor3, saveSensor4, saveTanggal);
                    if(suksesDatabase) { showToast("Data Sukses Disimpan"); }
                        else { showToast("Data Gagal Disimpan"); }
                }

            }
        });

    }

    private void showToast(String text) {
        Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();
    }
}
