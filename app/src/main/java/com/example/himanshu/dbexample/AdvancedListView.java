package com.example.himanshu.dbexample;

import android.app.ListActivity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by HIMANSHU on 6/17/2017.
 */

public class AdvancedListView extends ListActivity {

    String list[][]={{"apple", "orange", "papaya","guava","mango"},{"potato","cauliflower","onion","cucumber","brinjal"},
            {"cardamomom","black pepper","cumin","coriander","nutmeg"},{"oil","salt","sugar","vinegar","soy sauce"}};
    String categories[]={"fruits","vegetables","spices","extras"};
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nested_list_activity);
        setListAdapter(new MyCustomAdapter());
    }

    public class MyCustomAdapter extends BaseAdapter
    {
        private class HeaderViewHolder{
            TextView tv;
            HeaderViewHolder(View v){
                tv= (TextView) v.findViewById(R.id.nestedTVHeader);
            }
        }
        private class ElementViewHolder{
            TextView tv;
            ElementViewHolder(View v){
                tv= (TextView) v.findViewById(R.id.nestedTVElement);
            }
        }

        @Override
        public int getCount() {
            int count =0;
            for(String batch[]:list){
                count+=batch.length;
            }
            count+=categories.length;
            return count;
        }

        @Override
        public Object getItem(int position) {

            int i=0;
            int header=0;
            for(String[] batch:list){
                //add first title
                if(position==i)
                    return categories[header];
                i+=batch.length;
                if(position<=i){
                    return batch[(batch.length-1)-(i-position)];
                }
                header++;
                i++;

            }
            throw new IllegalArgumentException("Invalid position: "+position);



        }

        @Override
        public int getItemViewType(int position) {
            int i=0;
            int header=0;
            for(String[] batch:list){
                //add first title
                if(position==i)
                    return 0;
                i+=batch.length;
                if(position<=i){
                    return 1;
                }
                header++;
                i++;

            }
            throw new IllegalArgumentException("Invalid position");
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
          //if item view type is of type 0 or type header we call the getHeaderView
            if(getItemViewType(position)==0){

              return getHeaderView(position,convertView,parent);
          }
          //Get the convert view and check if it was recycled or not
            View row =convertView;
            if(row==null) {
                //if we get a new layout we inflate it with our custom layout for elements
                row = getLayoutInflater().inflate(R.layout.nested_list_elements, parent, false);
            }
            ElementViewHolder holder;
            Log.i("Element View Position", String.valueOf(position));
                //Try to retreive the holder from the view if it was recycled
            if(row.getTag() instanceof HeaderViewHolder){
                row = getLayoutInflater().inflate(R.layout.nested_list_elements, parent, false);
                holder=new ElementViewHolder(row);
                row.setTag(holder);
                Log.i("ErrorLog","I came here");
            }
             else{holder = (ElementViewHolder) row.getTag();}
            // if the holder is null thats only in cases when we get to create a new view
                //we attach a holder to the view
            if(holder==null ){
                holder=new ElementViewHolder(row);
                row.setTag(holder);
                }
                holder.tv.setText((String) getItem(position));
            return row;

        }

        private View getHeaderView(int position, View convertView, ViewGroup parent) {
            View row=convertView;
            Log.i("Header View Position", String.valueOf(position));
            if(row==null){
                row=getLayoutInflater().inflate(R.layout.nested_list_header,parent,false);
            }
            HeaderViewHolder holder;
            if(row.getTag() instanceof ElementViewHolder){
                row = getLayoutInflater().inflate(R.layout.nested_list_header, parent, false);
                holder=new HeaderViewHolder(row);
                row.setTag(holder);
                Log.i("ErrorLog","I came here");
            }
            holder= (HeaderViewHolder) row.getTag();
            if(holder==null){
                holder=new HeaderViewHolder(row);
                row.setTag(holder);
            }
            holder.tv.setText((String) getItem(position));
            return row;
        }
    }
}
