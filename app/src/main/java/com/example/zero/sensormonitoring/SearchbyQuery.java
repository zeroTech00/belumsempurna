package com.example.zero.sensormonitoring;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.example.zero.sensormonitoring.Adapter.DataBaseListAdapter;
import com.example.zero.sensormonitoring.Database.DatabaseHelper;
import com.example.zero.sensormonitoring.GetSetDataVariabel.variabelList;
import com.example.zero.sensormonitoring.variabelSearchParcelable;
import com.example.zero.sensormonitoring.R;

import java.util.ArrayList;

public class SearchbyQuery extends AppCompatActivity {

    public static final String DATA_SEARCH = "data search";

    private String[] dataidServer;
    private String[] dataSensor1;
    private String[] dataSensor2;
    private String[] dataSensor3;
    private String[] dataSensor4;
    private String[] dataTanggal;

    private DataBaseListAdapter adapterList;
    private ListView listView;

    TextView tvSearch;

    DatabaseHelper mDB;
    String dataSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchby_query);

        mDB = new DatabaseHelper(this);
        adapterList = new DataBaseListAdapter(this);

        listView = findViewById(R.id.listView_Database);
        listView.setAdapter(adapterList);

        tvSearch = findViewById(R.id.txt_search);

        variabelSearchParcelable vsParcelable = getIntent().getParcelableExtra(DATA_SEARCH);
        dataSearch = vsParcelable.getDataBaseSearch();

        tvSearch.setText(dataSearch);

        addItem();
    }

    private void addItem() {
        Cursor data = mDB.getDataAt(dataSearch);
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
