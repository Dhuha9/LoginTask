package com.example.firsttask;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;

class SaveModel {
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    @SuppressLint("CommitPrefEdits")
    SaveModel(Context context) {
        preferences = context.getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        editor = preferences.edit();
    }

    public void saveUserName(String userName) {
        editor.putString("userName", userName);
        editor.apply();

    }

    public void saveSignedInStatus(boolean isSignedIn) {
        editor.putBoolean("isSignedIn", isSignedIn);
        editor.apply();

    }

    public String getUserName() {
        return preferences.getString("userName", "");
    }

    public boolean isSignedIn() {
        return preferences.getBoolean("isSignedIn", false);
    }
}
