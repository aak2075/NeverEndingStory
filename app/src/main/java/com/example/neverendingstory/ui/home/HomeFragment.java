package com.example.neverendingstory.ui.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.neverendingstory.ContentsActivity;
import com.example.neverendingstory.ImageAdapter;
import com.example.neverendingstory.R;
import com.example.neverendingstory.WriteActivity;
import com.example.neverendingstory.ui.FragmentButtonController;
import com.example.neverendingstory.ui.top.TopFragment;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private Context homeContext;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        final TextView textView = root.findViewById(R.id.text_home);
        homeViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        RecyclerView recommendedNovelView = root.findViewById(R.id.recommendedNovelView);
        recommendedNovelView.setLayoutManager(new LinearLayoutManager(container.getContext(), LinearLayoutManager.HORIZONTAL, false)) ;

        ImageAdapter adapter = new ImageAdapter();
        adapter.setOnItemClickListener(
                new ImageAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(View v, int pos) {
                        Intent contentsIntent = new Intent(getContext(), ContentsActivity.class);

                        contentsIntent.putExtra("pos", pos);
                        contentsIntent.putExtra("direction", 0);
                        contentsIntent.putExtra("level", 0);
                        Log.i("pos", pos+"");
                        startActivity(contentsIntent);
                    }
                });

         String url = "http://imagizer.imageshack.us/v2/100x75q90/923/ioJCM1.jpg";
       // String url = "https://www.google.com/logos/doodles/2020/stay-home-save-lives-april-15-copy-6753651837108782-s.png";
        adapter.addItem(url);
        adapter.addItem(url);
        adapter.addItem(url);
        adapter.addItem(url);
        adapter.addItem(url);
        adapter.addItem(url);
        recommendedNovelView.setAdapter(adapter);

        RecyclerView myNovelView = root.findViewById(R.id.myNovelView);
       myNovelView.setLayoutManager(new LinearLayoutManager(container.getContext(), LinearLayoutManager.HORIZONTAL, false)) ;

        // 어댑터 생략

        myNovelView.setAdapter(adapter);

        RecyclerView recentNovelView = root.findViewById(R.id.recentNovelView);
        recentNovelView.setLayoutManager(new LinearLayoutManager(container.getContext(), LinearLayoutManager.HORIZONTAL, false)) ;

        // 어댑터 생략

        recentNovelView.setAdapter(adapter);
        FragmentButtonController fbController = new FragmentButtonController(root, R.id.nav_home);
        fbController.ButtonControl();

        return root;
    }
}