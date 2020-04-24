package com.example.neverendingstory;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.widget.Toolbar;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;


public class ContentsActivity extends AppCompatActivity {

    String contentRootHash;
    String parentHash;
    int level;
    int direction;
    String content;
    String title;
    MenuView.ItemView next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contents);

        Toolbar cToolbar = findViewById(R.id.toolbar_content);

        setSupportActionBar(cToolbar);

        getSupportActionBar().setDisplayShowTitleEnabled(false);

        // 툴바 홈버튼
        ImageView imageView = findViewById(R.id.home);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        TextView tvTitle = findViewById(R.id.title);
        TextView tvContent = findViewById(R.id.content);

        // 인텐트 값 받아오기
        if (savedInstanceState == null) {
            Intent intent = getIntent();
            Bundle extras = intent.getExtras();
            if(extras == null) {
                contentRootHash = null;
                parentHash = null;
            } else {
                contentRootHash = intent.getExtras().getString("contentRootHash");
                parentHash = intent.getExtras().getString("parentHash");
                level = intent.getExtras().getInt("level");
                direction = intent.getExtras().getInt("direction");

                if(level == 0) {
                    contentRootHash = "qwerasdf";
                }
                Log.i("contentRootHash : ", contentRootHash);
                if(parentHash != null)
                    Log.i("parentHash : ", parentHash);
                Log.i("level : ", level+"");
                Log.i("direction : ", direction+"");
            }
        }

        getDatas();
        tvTitle.setText(title);
        tvContent.setText(content);


//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // 바텀 네비게이션뷰 설정
        BottomNavigationView b = findViewById(R.id.contents_bottom);
        b.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Intent intent;
                switch (item.getItemId()) {
                    case R.id.next_icon:
                        intent = new Intent(getApplicationContext(), SelectDirectionActivity.class);
                        intent.putExtra("contentRootHash", contentRootHash);
                        intent.putExtra("level", level);
                        startActivity(intent);
                        return true;
                    case R.id.back_icon:
                        intent = new Intent(getApplicationContext(), SelectDirectionActivity.class);
                        intent.putExtra("contentRootHash", contentRootHash);
                        intent.putExtra("level", level-1);
                        startActivity(intent);
                        return true;
                }
                return false;
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
//        MenuInflater menuInflater = getMenuInflater();
//        menuInflater.inflate(R.menu.contents_bottom, menu);
//        Log.i("selected", "inflate");
//        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        /*
        Log.i("selected", "start");
        switch (item.getItemId()) {
            case R.id.next_icon:
                Intent intent = new Intent(getApplicationContext(), NextContentActivity.class);
                startActivity(intent);
                Log.i("selected", "next");
                return true;
            default :
                return super.onOptionsItemSelected(item);
        }
        */
        return true;
    }



    public void getDatas() {
        // 블록체인으로 부터 roothash, level, direction에 해당하는 contents, title을 가져옴.
        if(direction == 0)
            content = level+"";
        else if(direction == 1)
            content = level + "위쪽의 글입니다.";
        else if(direction == 2)
            content = level + "아래쪽의 글입니다.";

        title = "제목이에요";
    }

}
