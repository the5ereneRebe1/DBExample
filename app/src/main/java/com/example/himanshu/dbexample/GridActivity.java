package com.example.himanshu.dbexample;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;

/**
 * Created by HIMANSHU on 6/13/2017.
 */

public class GridActivity extends Activity implements AdapterView.OnItemClickListener {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);
        GridView gv=(GridView) findViewById(R.id.grid);
        gv.setAdapter(new ArrayAdapter<String>(this,R.layout.cell,ListViewerActivity.list));
        gv.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
