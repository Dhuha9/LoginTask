package com.example.firsttask;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView tvUsername;
    SaveModel saveModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvUsername = findViewById(R.id.tvUsername);
        saveModel = new SaveModel(this);
        showDialogFragment();
    }


    public void showDialogFragment() {
        if ((saveModel.isSignedIn())) {
            setTextView();
        } else {
            LoginFragment loginFragment = new LoginFragment();
            loginFragment.show(getSupportFragmentManager(), null);
        }
    }

    public void setTextView() {
        if (saveModel.getUserName().isEmpty()) {
            tvUsername.setText(R.string.no_value);
        } else {
            tvUsername.setText(saveModel.getUserName());
        }
    }


}
