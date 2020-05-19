package com.herculinux.lovemovies;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class UserRepository {

    SQLiteDatabase db;

    public UserRepository(Context context) {
        Conexao cn = new Conexao(context, null,null, 1);
        this.db = cn.getWritableDatabase();

    }
    public void Insert(String nome, String senha) {
        this.db.execSQL("INSERT INTO USER(NAME, PASS) VALUES("+ nome +", "+ senha + ")");
    }
    public Boolean Login(String nome, String senha) {
        Cursor cur = db.rawQuery("SELECT * FROM USER WHERE NAME = " + nome, null);
        if (cur.moveToFirst()) {
            if (cur.getString(1).equals(senha)) {
                return true;
            }
        }
        return false;
    }
}
