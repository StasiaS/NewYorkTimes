package com.example.anastasia.newyorktimes;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class AboutActivity extends AppCompatActivity {
    private EditText etMessage;
    private Button btnSendMessage;
    private ImageButton ibVk;
    private ImageButton ibLinkedIn;
    private ImageButton ibInstagram;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etMessage = findViewById(R.id.et_message);

        btnSendMessage = findViewById(R.id.btn_send_message);
        btnSendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openEmailApp(etMessage.getText().toString());
            }
        });

        ibInstagram = findViewById(R.id.ibtn_instagram);
        ibInstagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = getString(R.string.url_instagram);
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
            }
        });

        ibLinkedIn = findViewById(R.id.ibtn_linkedin);
        ibLinkedIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = getString(R.string.url_linkedin);
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
            }
        });

        ibVk = findViewById(R.id.ibtn_vkontakte);
        ibVk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = getString(R.string.url_vkontakte);
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
            }
        });
    }

    private void openEmailApp(String message) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/html");
        intent.putExtra(Intent.EXTRA_EMAIL, getString(R.string.base_email));
        intent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.android_academy_exercise_3));
        intent.putExtra(Intent.EXTRA_TEXT, message);

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(Intent.createChooser(intent, getString(R.string.send_email)));
        } else {
            Toast.makeText(this, getString(R.string.no_email_app_found), Toast.LENGTH_LONG).show();
        }
    }
}
