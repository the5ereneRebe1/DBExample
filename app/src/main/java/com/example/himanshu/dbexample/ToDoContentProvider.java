package com.example.himanshu.dbexample;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by HIMANSHU on 6/5/2017.
 */

public class ToDoContentProvider extends ContentProvider {

    public static final Uri CONTENT_URI=Uri.parse("content://com.himanshu.todoprovider/todoitems");
    public static final String KEY_ID="_id";
    public static final String KEY_TASK="task";
    public static final String KEY_CREATION_DATE="creation_date";
    private MySqliteOpenHelper mySqliteOpenHelper;
    private static final int ALLROWS=1;
    private static final int SINGLEROWS=2;
    private static final UriMatcher uriMatcher;

    static {
        uriMatcher=new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI("com.himanshu.todoprovider","todoitems",ALLROWS);
        uriMatcher.addURI("com.himanshu.todoprovider","todoitems",SINGLEROWS);
    }


    @Override
    public boolean onCreate() {
        mySqliteOpenHelper=new MySqliteOpenHelper(getContext(),MySqliteOpenHelper.DATABASE_NAME,null,MySqliteOpenHelper.DATABASE_VERSION);

        return true;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        return null;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        switch(uriMatcher.match(uri)){
            case ALLROWS:
                return "vnd.android.cursor.dir/vnd.himanshu.todos";
            case SINGLEROWS:
                return  "vnd.android.cursor.item/vnd.himanshu.todos";
            default: throw new IllegalArgumentException("Unsupported URI "+uri);
        }
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        return null;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }
    private static class MySqliteOpenHelper extends SQLiteOpenHelper
    {
        private static final String DATABASE_NAME="todoDatabase.db";
        private static final int DATABASE_VERSION=1;
        private static final String DATABASE_TABLE="todoItemTable";
        private static final String DATABASE_CREATE="create table "+DATABASE_TABLE+" ("+KEY_ID+
                " integer primary key autoincrement, "+KEY_TASK+" text not null, "+KEY_CREATION_DATE+
                " long);";


        public MySqliteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(DATABASE_CREATE);

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            Log.d("DBVersionChange","Upgraded from version "+oldVersion+" to "+newVersion);
            //TODO: Copy data from previous version to new version

            db.execSQL("DROP TABLE IF IT EXISTS "+DATABASE_TABLE);
            onCreate(db);
        }
    }
}
