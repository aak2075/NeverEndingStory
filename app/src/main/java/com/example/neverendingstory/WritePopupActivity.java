package com.example.neverendingstory;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class WritePopupActivity extends AppCompatActivity {

    Button write_ok, write_cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_write_popup);

        write_ok = (Button)findViewById(R.id.ok);
        write_cancel = (Button)findViewById(R.id.cancel);

    }

    public void writeOk(View v) {
        finish();
    }

    public void writeCancel(View v) {
        finish();
    }

}
