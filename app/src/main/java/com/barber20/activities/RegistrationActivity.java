package com.barber20.activities;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;

import com.barber20.databinding.ActivityRegistrationBinding;
import com.google.firebase.auth.FirebaseAuth;

public class RegistrationActivity extends Activity {

    private ActivityRegistrationBinding binding;

    private FirebaseAuth mAuth;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegistrationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}
