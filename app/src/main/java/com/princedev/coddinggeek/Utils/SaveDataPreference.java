package com.princedev.coddinggeek.Utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class SaveDataPreference {

    private static final String PREF_ID= "id";

    public static SharedPreferences getSharedPreferences(Context ctx) {
        return PreferenceManager.getDefaultSharedPreferences(ctx);
    }

    //Menghapus data
    public static void clearAllPref(Context ctx)
    {
        SharedPreferences.Editor editor = getSharedPreferences(ctx).edit();
        editor.clear();
        editor.commit();
    }

    //Untuk Menyimpan data
    public static void setUserID(Context ctx, String userID)
    {
        SharedPreferences.Editor editor = getSharedPreferences(ctx).edit();
        editor.putString(PREF_ID, userID);
        editor.commit();
    }

    //Untuk mengambil data
    public static String getUserID(Context ctx)
    {
        return getSharedPreferences(ctx).getString(PREF_ID, "");
    }

}
