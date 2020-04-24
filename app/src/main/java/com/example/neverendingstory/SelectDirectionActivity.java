package com.example.neverendingstory;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class SelectDirectionActivity extends AppCompatActivity {
    LinearLayout first;
    LinearLayout second;
    TextView firstTitle;
    TextView firstContent;
    TextView secondTitle;
    TextView secondContent;
    String contentRootHash;
    String parentHash;
    String hash;
    int level;
    int direction;
    String content;
    String title;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_direction);

        // 툴바 홈버튼
        ImageView imageView = findViewById(R.id.home);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

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

//                Log.i("contentRootHash : ", contentRootHash);
//                Log.i("parentHash : ", parentHash);
//                Log.i("level : ", level+"");
//                Log.i("direction : ", direction+"");
            }
        }


        // 내용이 있고 해당 내용을 읽으려고 클릭할 때 레이아웃 리스너
        View.OnClickListener clickListener1 = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                level = level + 1;
                // 레벨에 해당하는 현재 해쉬값 블록체인에서 받아와서 설정
                hash = level+"";
                Intent intent = new Intent(getApplicationContext(), ContentsActivity.class);
                switch (v.getId()) {
                    case R.id.first:
                        Log.i("click", "first");
                        intent.putExtra("level", level);
                        intent.putExtra("parentHash", hash);
                        intent.putExtra("direction", 1);
                        intent.putExtra("contentRootHash", contentRootHash);
                        startActivity(intent);
                        break;
                    case R.id.second:
                        Log.i("click", "second");
                        intent.putExtra("level", level);
                        intent.putExtra("hash", hash);
                        intent.putExtra("direction", 2);
                        intent.putExtra("contentRootHash", contentRootHash);
                        startActivity(intent);
                        break;
                }
            }
        };

        // 내용이 없어서 새로 쓸때 레이아웃 리스너
        View.OnClickListener clickListener2 = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.first:
                        Log.i("click", "first");
                        break;
                    case R.id.second:
                        Log.i("click", "second");
                        break;
                }
            }
        };

        first = findViewById(R.id.first);
        second = findViewById(R.id.second);

        // 내용이 있으면 clickListener1, 없으면 clickListener2
        first.setOnClickListener(clickListener1);
        second.setOnClickListener(clickListener1);

        firstTitle = findViewById(R.id.first_title);
        firstContent = findViewById(R.id.first_content);
        secondTitle = findViewById(R.id.second_title);
        secondContent = findViewById(R.id.second_content);

        // 내용이 있으면 해당 내용을 setText
        firstContent.setText(level + 1 + "의 위쪽의 내용");
        secondContent.setText(level + 1 + "의 아래쪽의 내용");

        // 바텀 네비게이션뷰 설정
        BottomNavigationView b = findViewById(R.id.select_direction_bottom);
        b.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Intent intent;
                switch (item.getItemId()) {
                    case R.id.back_icon:
                        intent = new Intent(getApplicationContext(), ContentsActivity.class);
                        intent.putExtra("contentRootHash", contentRootHash);
                        intent.putExtra("level", level);
                        // level - 2의 해쉬를 구해서 넣어줌
                        intent.putExtra("parentHash", level-2);
                        intent.putExtra("direction", 1);
                        startActivity(intent);
                        return true;
                }
                return false;
            }
        });
    }

    public void getDatas() {
        // 블록체인으로 부터 roothash, level, direction에 해당하는 contents, title을 가져옴.
        if(level == 0)
            content = "level0의 내용";
        if(level == 1)
            content = "level1의 내용";
        title = "제목이에요";
    }
}
