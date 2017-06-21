package com.example.himanshu.dbexample;

import android.app.ListActivity;
import android.content.Intent;
import android.content.UriMatcher;
import android.provider.MediaStore;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import br.com.bloder.magic.view.MagicButton;

public class MainActivity extends AppCompatActivity implements TimePickerFragment.HourMinutePass {
    UriMatcher uriMatcher;
    MagicButton magicButton;

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.help:
                Toast.makeText(this, "Help Clicked!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.about:
                Toast.makeText(this, "About Clicked!", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        setContentView(R.layout.activity_main);

        magicButton= (MagicButton) findViewById(R.id.magic_button);
        magicButton.setMagicButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pickTime(v);
            }
        });

    }
    public void captureImage(View v){
        String title="Society me galat news failao";
        Intent intent=new Intent();
        intent.setAction(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_TEXT,"The earth is flat, NASA just proved it!");
        intent.setType("text/plain");
        Intent chooser =Intent.createChooser(intent,title);
        if(chooser.resolveActivity(getPackageManager())!=null) {
            startActivity(chooser);
        }
    }
    public void pickTime(View view){
        DialogFragment newFragment = new TimePickerFragment();
        newFragment.show(getSupportFragmentManager(), "timePicker");
    }

    public void fireMissiles(View view) {

        DialogFragment newFrag =new AlertDialogFragment();
        newFrag.show(getSupportFragmentManager(),"missile launch");
    }

    @Override
    public void passData(int hour, int minute) {
        Toast.makeText(this,hour+","+minute,Toast.LENGTH_SHORT).show();
    }
    public void passDataSimple(int hour, int minute) {
        Toast.makeText(this,"Howazzzt"+hour+","+minute,Toast.LENGTH_SHORT).show();
    }

    public void openForm(View view) {
        Intent i =new Intent(this,FormActivity.class);
        startActivity(i);
    }

    public void openList(View view) {
        Intent i =new Intent(this,ListViewerActivity.class);
        startActivity(i);
    }

    public void openSpinner(View view) {
        Intent i =new Intent(this,SpinnerActivity.class);
        startActivity(i);
    }

    public void showGrid(View view) {
        Intent i =new Intent(this,GridActivity.class);
        startActivity(i);
    }

    public void openNestedListView(View view) {
        Intent i =new Intent(this,NestedListView.class);
        startActivity(i);
    }

    public void openAdvancedListView(View view) {
        Intent i =new Intent(this,AdvancedListView.class);
        i.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);
    }
}
