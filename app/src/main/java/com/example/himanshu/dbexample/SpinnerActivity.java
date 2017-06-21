package com.example.himanshu.dbexample;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.madrapps.pikolo.HSLColorPicker;
import com.madrapps.pikolo.listeners.OnColorSelectionListener;
import com.madrapps.pikolo.listeners.SimpleColorSelectionListener;

/**
 * Created by HIMANSHU on 6/13/2017.
 */

public class SpinnerActivity extends Activity implements AdapterView.OnItemSelectedListener {

    private String list[]={"gini","apple","banana","papaya","cake","coconut","ginger","garlic","bread","fish","chicken","beef","pork","grapes","oil"};
    HSLColorPicker colorPicker;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);
        Spinner s=(Spinner)findViewById(R.id.spinner);
        colorPicker= (HSLColorPicker) findViewById(R.id.colorPicker);
        ArrayAdapter<String> aa=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,list);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(aa);

        colorPicker.setColorSelectionListener(new SimpleColorSelectionListener(){
            @Override
            public void onColorSelected(int color) {
                Toast.makeText(SpinnerActivity.this, "Color Selected :"+color, Toast.LENGTH_SHORT).show();
            }
        });

        AutoCompleteTextView actv =(AutoCompleteTextView)findViewById(R.id.acTv);
        actv.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,list));
        actv.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
