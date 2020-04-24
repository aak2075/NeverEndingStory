package com.example.neverendingstory;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class WriteActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);

        Toolbar cToolbar = findViewById(R.id.toolbar_content);

        setSupportActionBar(cToolbar);

        getSupportActionBar().setDisplayShowTitleEnabled(false);

//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // 툴바 홈버튼
        ImageView imageView = findViewById(R.id.home);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        Button write = (Button)findViewById(R.id.write);

        Button.OnClickListener btnListener = new View.OnClickListener() {
            public void onClick(View v) {
                switch(v.getId()) {
                    case R.id.write:
                        Intent intent = new Intent(WriteActivity.this, WritePopupActivity.class);
                        startActivityForResult(intent, 1);

                        break;
                }
            }
        };

        write.setOnClickListener(btnListener);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
//        MenuInflater menuInflater = getMenuInflater();
//        menuInflater.inflate(R.menu.toolbar, menu);
//        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}
