package com.danielsoto.niceshop;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;


public class LoginFragment extends Fragment {
    private DatabaseHelper databaseHelper;
    private Context context;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.login_fragment, container, false);
        final TextInputLayout passwordTextInput = view.findViewById(R.id.password_text_input);
        final TextInputEditText passwordEditText = view.findViewById(R.id.password_edit_text);
        final TextInputEditText usernameEditText = view.findViewById(R.id.username_edit_text);
        MaterialButton loginButton = view.findViewById(R.id.login_button);
        MaterialButton registerButton = view.findViewById(R.id.login_register_button);
        databaseHelper = new DatabaseHelper(this.getContext());
        // validar si la contraseña contiene 6 o mas caracteres.

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getUsername = usernameEditText.getText().toString();
                String getPassword = passwordEditText.getText().toString();
                databaseHelper.registerUser(new Data(getUsername, getPassword));

            }
        });



        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String getUsername = usernameEditText.getText().toString();
                String getPassword = passwordEditText.getText().toString();
                databaseHelper.loginUser(new Data(getUsername, getPassword));
//                if(!isPasswordValid(passwordEditText.getText())) {
//                    passwordTextInput.setError(getString(R.string.login_error_message));
//                } else {
//                    passwordTextInput.setError(null); // limpiar el error
//                    ((NavigationHost) getActivity()).navigateTo(new HomeFragment(), false);
//                }
            }
        });

        passwordEditText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if(isPasswordValid(passwordEditText.getText())) {
                    passwordTextInput.setError(null);
                }
                return false;
            }
        });

        return view;
    }
    private boolean isPasswordValid(@Nullable Editable text) { return text != null && text.length() >= 6;}
}
