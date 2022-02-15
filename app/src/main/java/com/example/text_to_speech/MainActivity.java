package com.example.text_to_speech;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    EditText text;
    Button btn;
    TextToSpeech tospeech;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text=(EditText) findViewById(R.id.texttospeech);
        btn=(Button) findViewById(R.id.speechbtn);

        tospeech=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status==TextToSpeech.SUCCESS){
                    tospeech.setLanguage(Locale.UK);
                }
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tospeech.speak(text.getText().toString(),TextToSpeech.QUEUE_FLUSH,null);
            }
        });
    }
}