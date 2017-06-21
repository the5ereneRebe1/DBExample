package com.example.himanshu.dbexample;

import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by HIMANSHU on 6/15/2017.
 */

public class NestedListView extends ListActivity {
    class ViewHolder {
        ImageView icon = null;
        TextView size = null;

        ViewHolder(View row) {
            this.icon = (ImageView) row.findViewById(R.id.icon);
            this.size = (TextView) row.findViewById(R.id.size);
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_activity);
        IconicAdapter ia = new IconicAdapter(this, R.layout.list_element, R.id.label, ListViewerActivity.list);
        setListAdapter(ia);
    }

    protected class IconicAdapter extends ArrayAdapter<String> {

        String items[];

        public IconicAdapter(@NonNull Context context, @LayoutRes int resource, @IdRes int textViewResourceId, @NonNull String[] objects) {
            super(context, resource, textViewResourceId, objects);
            items = objects;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            View row = super.getView(position, convertView, parent);
            ImageView iv = (ImageView) row.findViewById(R.id.icon);
            if (items[position].length() <= 4) {
                iv.setImageDrawable(getDrawable(R.mipmap.ic_launcher_round));
            } else {
                iv.setImageDrawable(getDrawable(R.mipmap.ic_launcher));
            }
            //TextView textView= (TextView) row.findViewById(R.id.label);
            TextView tv2 = (TextView) row.findViewById(R.id.size);
            //textView.setText(items[position]);
            tv2.setText(String.format(getString(R.string.size_template), items[position].length()));

            return row;
        }

        private String getModel(int position) {
            return ((IconicAdapter) getListAdapter()).getItem(position);
        }
    }
}
