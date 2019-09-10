package com.example.firsttask;

import android.content.Context;
import android.content.SharedPreferences;

class SaveModel {
    private SharedPreferences preferences;

    SaveModel(Context context) {
        preferences = context.getSharedPreferences("userInfo", Context.MODE_PRIVATE);

    }

    public boolean SavedUsername(String username, boolean isStaySignedIn) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("username", username);
        editor.putBoolean("isStaySignedIn", isStaySignedIn);
        return editor.commit();
    }

    public String getUsername() {
        return preferences.getString("username", "");
    }

    public boolean getIsStaySignedIn() {
        return preferences.getBoolean("isStaySignedIn", false);
    }
}
