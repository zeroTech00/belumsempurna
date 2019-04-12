package com.example.zero.sensormonitoring;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zero.sensormonitoring.Database.CreateDatabase;
import com.example.zero.sensormonitoring.Database.ShowDatabase;

public class MainActivity extends AppCompatActivity {

    Button btnCreate, btnShow, btnSearch, btnTestJASONARRAY, btnShowLatest;
    TextView tvID, tvSensor1, tvSensor2, tvSensor3, tvSensor4, tvTanggal;

    EditText edtextSearch;


    String keySearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCreate       = findViewById(R.id.btn_Create);
        btnShow         = findViewById(R.id.btn_SHOW);
        btnSearch       = findViewById(R.id.btn_SEARCH);
        tvID            = findViewById(R.id.txt_id);
        tvSensor1       = findViewById(R.id.txt_sensor1);
        tvSensor2       = findViewById(R.id.txt_sensor2);
        tvSensor3       = findViewById(R.id.txt_sensor3);
        tvSensor4       = findViewById(R.id.txt_sensor4);
        tvTanggal       = findViewById(R.id.txt_Tanggal);
        edtextSearch    = findViewById(R.id.edText_search);
        btnTestJASONARRAY =findViewById(R.id.btn_testJSONarray);
        btnShowLatest   = findViewById(R.id.btn_showlatest);


        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentCreate = new Intent(MainActivity.this,CreateDatabase.class);
                startActivity(intentCreate);
            }
        });

        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentShow = new Intent(MainActivity.this,ShowDatabase.class);
                startActivity(intentShow);
            }
        });

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                keySearch = edtextSearch.getText().toString();

                if(keySearch.isEmpty()) {
                    showTost("Data Harus Diisi");
                }else {
                    variabelSearchParcelable vsParcelable = new variabelSearchParcelable();
                    vsParcelable.setDataBaseSearch(keySearch);

                    Intent intentSearch = new Intent(MainActivity.this,SearchbyQuery.class);
                    intentSearch.putExtra(SearchbyQuery.DATA_SEARCH,vsParcelable);
                    startActivity(intentSearch);
                }

                tvSensor4.setText(keySearch);

            }
        });

        btnTestJASONARRAY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentTest = new Intent(MainActivity.this,testJasonArray.class);
                startActivity(intentTest);
            }
        });

        btnShowLatest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLatest = new Intent(MainActivity.this,ShowLatestDatabase.class);
                startActivity(intentLatest);
            }
        });

    }

    private void showTost(String Text) {
        Toast.makeText(getApplicationContext(), Text, Toast.LENGTH_SHORT).show();
    }

}
