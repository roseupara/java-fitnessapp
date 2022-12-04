package com.example.activeplan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Aktiviteter när man klickar på "Logga in"-knappen.
    public void LogInButton(View view)
    {
        //Hämtar värden från inmatning.
        EditText txtUsername = findViewById(R.id.usernamemain);
        EditText txtPassword = findViewById(R.id.passwordmain);
        String user = txtUsername.getText().toString();
        String password = txtPassword.getText().toString();

        //Kontrollerar att användarnamn och lösenord stämmer.
        if (user.equals("Hello") && password.equals("World"))
        {
            //Om användarnamn och lösenord stämmer, går vidare till nästa sida "Schedule Activity"
            Intent nextToSchedulePage = new Intent(this, ScheduleActivity.class);
            startActivity(nextToSchedulePage);
        }
        else
        {
            //Om användarnamn och lösenord är inkorrekt visas ett fel meddelande.
            TextView messageLabel = findViewById(R.id.corrMessage);
            String meddelande = "Fel användarnamn eller lösenord,\nvänlig försök igen!";
            messageLabel.setText(meddelande);
        }

    }

    //Toast som visar när användare klickar på denna knappen.
    public void newAccountbtn(View view) {
        Toast.makeText(MainActivity.this, "Du klickade på SKAPA KONTO", Toast.LENGTH_SHORT).show();

    }
}