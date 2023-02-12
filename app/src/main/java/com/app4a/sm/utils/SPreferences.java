package com.app4a.sm.utils;


import android.content.Context;
import android.content.SharedPreferences;

public class SPreferences {
    private SharedPreferences sp;

    public SPreferences(Context context){
        sp = context.getSharedPreferences(context.getPackageName(),Context.MODE_PRIVATE);
    }

    public void setUsers(String USERS){
        sp.edit().putString("USERS",USERS).commit();
    }

    public String getUsers(){
        return sp.getString("USERS","");
    }

}
