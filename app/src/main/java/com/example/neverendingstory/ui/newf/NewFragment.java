package com.example.neverendingstory.ui.newf;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import com.example.neverendingstory.R;
import com.example.neverendingstory.ui.FragmentButtonController;
import com.example.neverendingstory.ui.home.HomeFragmentDirections;
import com.example.neverendingstory.ui.top.TopViewModel;

public class NewFragment extends Fragment {
    private NewViewModel newViewModel;
    private Context topContext;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        newViewModel =
                ViewModelProviders.of(this).get(NewViewModel.class);
        View root = inflater.inflate(R.layout.fragment_new, container, false);
        FragmentButtonController fbController = new FragmentButtonController(root, R.id.nav_new);
        fbController.ButtonControl();

        Spinner newSpinner = (Spinner) root.findViewById(R.id.spinner);
        newSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // 스피너 선택시 구현
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });

        return root;
    }
}