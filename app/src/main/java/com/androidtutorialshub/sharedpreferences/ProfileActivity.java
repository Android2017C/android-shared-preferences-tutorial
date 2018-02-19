package com.androidtutorialshub.sharedpreferences;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;

/**
 * Created by Lalit Vasan on 2/13/2018.
 */

public class ProfileActivity extends AppCompatActivity {

    private AppCompatTextView appCompactTextViewUserType;
    private AppCompatTextView appCompactTextViewUserName;
    private AppCompatTextView appCompactTextViewUserPhoneNo;
    private AppCompatTextView appCompactTextViewUserEmail;

    private AppCompatButton appCompactButtonClearUser;
    private AppPreferences appPreferences;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // initializing the views
        initViews();

        // initializing the listeners
        initListeners();

        // initializing the objects
        initObjects();

        // set preferences value to views
        showPrefsToViews();
    }


    /**
     * method to initializing the views
     */
    private void initViews() {

        appCompactTextViewUserType = findViewById(R.id.appCompactTextViewUserType);
        appCompactTextViewUserName = findViewById(R.id.appCompactTextViewUserName);
        appCompactTextViewUserPhoneNo = findViewById(R.id.appCompactTextViewUserPhoneNo);
        appCompactTextViewUserEmail = findViewById(R.id.appCompactTextViewUserEmail);

        appCompactButtonClearUser = findViewById(R.id.appCompactButtonClearUser);

    }

    /**
     * method to initializing the listeners
     */
    private void initListeners() {
        appCompactButtonClearUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // clearing the preferences
                appPreferences.clearPrefs();

                // navigating to the profile making activity
                Intent intent = new Intent(getApplicationContext(), CreateProfileActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    /**
     * method to initializing the objects
     */
    private void initObjects() {

        appPreferences = new AppPreferences(getApplicationContext());

    }

    /**
     * method to show preferences values to views
     */
    private void showPrefsToViews() {

        appCompactTextViewUserType.setText(appPreferences.getStringPrefs(AppPreferences.KEY_USER_TYPE));
        appCompactTextViewUserName.setText(appPreferences.getStringPrefs(AppPreferences.KEY_USER_NAME));
        appCompactTextViewUserPhoneNo.setText(appPreferences.getStringPrefs(AppPreferences.KEY_USER_PHONE));
        appCompactTextViewUserEmail.setText(appPreferences.getStringPrefs(AppPreferences.KEY_USER_EMAIL));

    }
}
