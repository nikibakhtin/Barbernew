package com.barber20.repositories;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.HashMap;
import java.util.Map;

public class RegistrationRepository {
    private FirebaseAuth mAuth;
    private FirebaseFirestore db;

    public RegistrationRepository() {
        mAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();
    }

    public void registerUser(String email, String password, OnCompleteListener<AuthResult> listener) {
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(listener);
    }

    public void savePersonalDetails(String firstName, String lastName, String middleName, String birthDate, OnSuccessListener<Void> listener) {
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser != null) {
            String userId = currentUser.getUid();
            Map<String, Object> userDetails = new HashMap<>();
            userDetails.put("firstName", firstName);
            userDetails.put("lastName", lastName);
            userDetails.put("middleName", middleName);
            userDetails.put("birthDate", birthDate);
            db.collection("users").document(userId)
                    .set(userDetails)
                    .addOnSuccessListener(listener);
        }
    }

    public void sendEmailConfirmation(OnSuccessListener<Void> listener) {
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser != null) {
            currentUser.sendEmailVerification()
                    .addOnSuccessListener(listener);
        }
    }
}
