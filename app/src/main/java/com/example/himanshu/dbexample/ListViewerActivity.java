package com.example.himanshu.dbexample;

import android.app.ListActivity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by HIMANSHU on 6/12/2017.
 */

public class ListViewerActivity extends ListActivity implements AdapterView.OnItemClickListener
{

    public static String list[]={"apple","banana","papaya","cake","coconut","ginger","garlic","bread","fish","chicken","beef","pork","grapes","oil"};
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.list_activity);
        getListView().setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        getListView().setOnItemClickListener(this);
        setListAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_multiple_choice,list));


    }

    @Override
    protected void onResume() {
        super.onResume();
        SparseBooleanArray sba= getListView().getCheckedItemPositions();
        for(int i=0;i<sba.size();i++){
            Log.i("SparseBoolaeanArray","Element "+sba.keyAt(i)+":status::"+sba.get(sba.keyAt(i)));
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, "Item selected at position:"+position+" ,"+parent.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();
    }
}
