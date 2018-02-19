package com.androidtutorialshub.sharedpreferences;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class CreateProfileActivity extends AppCompatActivity {


    private TextInputEditText textInputEditTextName;
    private TextInputEditText textInputEditTextEmail;
    private TextInputEditText textInputEditTextPhone;
    private RadioGroup radioGroupUserType;
    private AppCompatButton appCompactButtonSaveUser;

    private AppPreferences appPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_profile);

        // initializing the views
        initViews();

        // initializing the listeners
        initListeners();

        // initializing the objects
        initObjects();


    }


    /**
     * method to initialize the views
     */
    private void initViews() {

        textInputEditTextName = findViewById(R.id.textInputEditTextName);
        textInputEditTextEmail = findViewById(R.id.textInputEditTextEmail);
        textInputEditTextPhone = findViewById(R.id.textInputEditTextPhone);
        radioGroupUserType = findViewById(R.id.radioGroupUserType);
        appCompactButtonSaveUser = findViewById(R.id.appCompactButtonSaveUser);

    }

    /**
     * method to initialize the listeners
     */
    private void initListeners() {

        appCompactButtonSaveUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // ToDO implement here the input validations

                // saving user data
                saveUserData();
            }
        });

    }

    /**
     * method to initialize the objects
     */
    private void initObjects() {

        appPreferences = new AppPreferences(getApplicationContext());

        if (appPreferences.getBooleanPrefs(AppPreferences.KEY_SAVE_USER)) {
            Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
            startActivity(intent);
            finish();
        }

    }

    /**
     * method to save user data in preferences
     */
    private void saveUserData() {

        appPreferences.setBooleanPrefs(AppPreferences.KEY_SAVE_USER, true);
        appPreferences.setStringPrefs(AppPreferences.KEY_USER_NAME, textInputEditTextName.getText().toString().trim());
        appPreferences.setStringPrefs(AppPreferences.KEY_USER_EMAIL, textInputEditTextEmail.getText().toString().trim());
        appPreferences.setStringPrefs(AppPreferences.KEY_USER_PHONE, textInputEditTextPhone.getText().toString().trim());

        RadioButton radioButton = findViewById(radioGroupUserType.getCheckedRadioButtonId());
        if (radioButton != null) {
            appPreferences.setStringPrefs(AppPreferences.KEY_USER_TYPE, radioButton.getText().toString());
        }

        // navigating to profile activity
        Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
        startActivity(intent);
        finish();

    }
}
