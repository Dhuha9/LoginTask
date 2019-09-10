package com.example.firsttask;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class LoginFragment extends DialogFragment {
    private TextInputEditText username;
    private CheckBox cbStaySignedIn;
    private SaveModel saveModel;
    private TextInputLayout passwordInputLayout;
    private TextInputEditText userPassword;
    private Button btnLogin;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        return inflater.inflate(R.layout.login_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        super.onViewCreated(view, savedInstanceState);

        username = view.findViewById(R.id.username);
        userPassword = view.findViewById(R.id.userPassword);

        btnLogin = view.findViewById(R.id.btnLogin);
        cbStaySignedIn = view.findViewById(R.id.cbStaySignedIn);

        passwordInputLayout = view.findViewById(R.id.passwordInputLayout);

        btnLogin.setOnClickListener(LoginListener);
        saveModel = new SaveModel(this.getContext());

        userPassword.addTextChangedListener(passwordWatcher);

    }


    private TextWatcher passwordWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            if (charSequence.length() > passwordInputLayout.getCounterMaxLength()) {
                passwordInputLayout.setError("password is too long");
            } else {
                passwordInputLayout.setError(null);
            }
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };


    private View.OnClickListener LoginListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String usernameValue = username.getText().toString();
            String passwordValue = userPassword.getText().toString();

            if (usernameValue.equals("admin") && passwordValue.equals("12345678")) {
                ((MainActivity) getActivity()).tvUsername.setText(username.getText().toString());
                if (cbStaySignedIn.isChecked()) {

                    saveModel.SavedUsername(username.getText().toString(), cbStaySignedIn.isChecked());
                    dismiss();

                } else {
                    dismiss();
                }
            } else {
                Toast.makeText(view.getContext(), "UserName and/or Password are not correct", Toast.LENGTH_LONG).show();
            }
        }

    };


}
